package Pages.textTransfer;

import driver.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AddReadingVoice {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    By chonbtngiongdocLocator = By.id("buttonMenu");
    private static boolean firstExampleExecuted = false;
    public void captureScreen(String name) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("image\\AddReadingVoice\\" + name));
    }

    private static void uncheckAllCheckboxes(WebDriver driver, String checkboxcssSelector) {
        java.util.List<WebElement> checkboxes = driver.findElements(By.cssSelector(checkboxcssSelector));
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
    public static void uncheckAllCheckboxesGender(){
        String selectorGenderMale = "input[type='checkbox'][value='male']";
        String selectorGenderFemale = "input[type='checkbox'][value='female']";
        List<String> checkboxscssSelector = List.of(
                selectorGenderFemale,
                selectorGenderMale
        );
        for (String checkboxcssSelector : checkboxscssSelector) {
            uncheckAllCheckboxes(driver, checkboxcssSelector);
        }

    }
    public static void uncheckAllCheckboxesType(){
        String selectorTypeBasic = "input[type='checkbox'][value='STANDARD']";
        String selectorTypePro = "input[type='checkbox'][value='PREMIUM']";
        List<String> checkboxscssSelector = List.of(
                selectorTypeBasic,
                selectorTypePro
        );
        for (String checkboxcssSelector : checkboxscssSelector) {
            uncheckAllCheckboxes(driver, checkboxcssSelector);
        }

    }
    public AddReadingVoice(WebDriver driver){
        this.driver = driver;
    }
    public void ReadingButton() throws IOException {
        WebElement giongdocbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonbtngiongdocLocator));
        giongdocbtn.click();
    }
    public void selectGender(String gender ) throws InterruptedException, IOException {
        uncheckAllCheckboxesGender();
        String selectorGender = "input[type='checkbox'][value='" + gender.toLowerCase()+"']";
        By genderLocator = By.cssSelector(selectorGender);
        WebElement genderButton = driver.findElement(genderLocator);
        Thread.sleep(1000);
        captureScreen("OptionReading.png");
        genderButton.click();
    }
    public void selectVoiceType(String type){
        uncheckAllCheckboxesType();
        By loaigiongtieuchuanLocator = By.cssSelector("input[type='checkbox'][value='" + type +"']");
        WebElement loaigiong = driver.findElement(loaigiongtieuchuanLocator);
        loaigiong.click();
    }
    public void selectVoiceUser(String User) throws IOException {
        By chonguoiLocator = By.xpath("//button[@aria-label='"+ User +"']");
        WebElement chonnguoi = driver.findElement(chonguoiLocator);
        captureScreen("SelectVoiceUser.png");
        chonnguoi.click();
    }
}

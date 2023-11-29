package Pages.textTransfer;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddReadingVoice {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    By chonbtngiongdocLocator = By.xpath("//button[@aria-label='Chọn giọng đọc']    ");
    By gioitinhnamLocator = By.cssSelector("input[type='checkbox'][value='male']");
    By chonguoiLocator = By.xpath("//button[@aria-label='SG - Trung Kiên voice']");
    private static boolean firstExampleExecuted = false;

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
    public static void uncheckAllCheckboxesLanguage(){
        String cssSeletorLanguageVietNam = "input[type='checkbox'][value='vi-VN']";
        String cssSelectorLanguageTiengAnhUc = "input[type='checkbox'][value='en-AU']";
        String cssSelectorLanguageTiengAnhAnh =  "input[type='checkbox'][value='en-GB']";
        List<String> checkboxscssSelector = List.of(
                cssSeletorLanguageVietNam,
                cssSelectorLanguageTiengAnhUc,
                cssSelectorLanguageTiengAnhAnh
        );
        for (String checkboxcssSelector : checkboxscssSelector) {
            uncheckAllCheckboxes(driver, checkboxcssSelector);
        }
    }
    public static void uncheckAllCheckboxesType(){
        String selectorTypeBasic = "input[type='checkbox'][value='BASIC']";
        String selectorTypePro = "input[type='checkbox'][value='PRO']";
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
    public void ReadingButton(){
        WebElement giongdocbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonbtngiongdocLocator));
        giongdocbtn.click();
    }
    public void selectGender(String gender ) throws InterruptedException {
        uncheckAllCheckboxesGender();
        String selectorGender = "input[type='checkbox'][value='" + gender.toLowerCase()+"']";
        By genderLocator = By.cssSelector(selectorGender);
        WebElement genderButton = driver.findElement(genderLocator);
        Thread.sleep(1000);
        genderButton.click();
    }
    public void selectLanguage(String language) throws InterruptedException {
        uncheckAllCheckboxesLanguage();
        By ngonnguvietnamLocator = By.cssSelector("input[type='checkbox'][value='"+ language +"']");
        Thread.sleep(1000);
        WebElement ngonngubtn = driver.findElement(ngonnguvietnamLocator);
        Thread.sleep(1000);
        ngonngubtn.click();
    }
    public void selectVoiceType(String type){
        uncheckAllCheckboxesType();
        By loaigiongtieuchuanLocator = By.cssSelector("input[type='checkbox'][value='" + type +"']");
        WebElement loaigiong = driver.findElement(loaigiongtieuchuanLocator);
        loaigiong.click();
    }
    public void selectVoiceUser(String User){
        By chonguoiLocator = By.xpath("//button[@aria-label='"+ User +"']");
        WebElement chonnguoi = driver.findElement(chonguoiLocator);
        chonnguoi.click();
    }
}

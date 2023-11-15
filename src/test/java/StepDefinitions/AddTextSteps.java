package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sessionmanagement.WebDriverManager;

import java.time.Duration;

public class AddTextSteps {

    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }

    static Duration timeout50 = Duration.ofSeconds(50);
    static WebDriverWait wait50 = new WebDriverWait(driver, timeout50);
    static Duration timeout10 = Duration.ofSeconds(10);
    static WebDriverWait wait10 = new WebDriverWait(driver, timeout10);

    String roleValue = "textbox";
    By nhapvanbanLocator = By.cssSelector("[role='" + roleValue + "']");
    By dinhdangvideoLocator = By.xpath("//button[@aria-label='Thay đổi định dạng audio'] ");
    By dinhdangmp3Locator = By.xpath("//li[p[text()='mp3']]");
    By chuyenthanhgiongnoiLocator = By.cssSelector("#convert-tts");

    @When("^click on add text button and add (.*)$")
    public void clickOnAddTextButtonAndAddText(String text) throws InterruptedException {
        System.out.println(driver);
        System.out.println("bat dau nhap");
        WebElement nhap = wait50.until(ExpectedConditions.visibilityOfElementLocated(nhapvanbanLocator));
        Thread.sleep(2000);
        nhap.clear();
        Thread.sleep(2000);
        nhap.sendKeys(text);
        Thread.sleep(1000);
        System.out.println("dang nhap gan xong roi");
    }

    @And("click change format video button and click mpba button")
    public void clickChangeFormatVideoButtonAndClickMpbaButton() throws InterruptedException {
        WebElement dinhdang = wait50.until(ExpectedConditions.visibilityOfElementLocated(dinhdangvideoLocator));
        dinhdang.click();
        Thread.sleep(1000);
        WebElement mp3 = wait50.until(ExpectedConditions.visibilityOfElementLocated(dinhdangmp3Locator));
        Thread.sleep(1000);
        mp3.click();
    }

    @And("click on converted into voice button")
    public void clickOnConvertedIntoVoiceButton() throws InterruptedException {
        WebElement chuyenthanhgiongnoi = wait50.until(ExpectedConditions.visibilityOfElementLocated(chuyenthanhgiongnoiLocator));
        Thread.sleep(10000);
        chuyenthanhgiongnoi.click();

    }

    @And("remove cancel")
    public void removeCancel() {
//        try{
//        System.out.println("bat dau tim");
//        By huyLocator = By.xpath("/html/body/div[7]/div[3]/div/div[2]/button[1]");
//        System.out.println(huyLocator);
//        WebElement huybtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(huyLocator));
//        System.out.println(huybtn);
//        huybtn.click();
//        }catch (Exception e) {
//            // Nếu nút Remove không xuất hiện, in thông báo ra console và tiếp tục chạy kiểm thử
//            System.out.println("Nút Remove không xuất hiện. Tiếp tục chạy kiểm thử.");
//        }
    }
}

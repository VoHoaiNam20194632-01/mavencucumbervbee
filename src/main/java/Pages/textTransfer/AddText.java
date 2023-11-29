package Pages.textTransfer;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddText {

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
    //    By nhapvanbanLocator = By.xpath("//div/span[@data-offset-key=5jgu2-0-0]");
    By dinhdangvideoLocator = By.xpath("//button[@aria-label='Thay đổi định dạng audio'] ");
    By chuyenthanhgiongnoiLocator = By.cssSelector("#convert-tts");

    public AddText(WebDriver driver){
        this.driver = driver;
    }
    public void clickAddText(String text) throws InterruptedException {
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
    public  void clickFormatVideo(String format) throws InterruptedException {
        WebElement dinhdangbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(dinhdangvideoLocator));
        dinhdangbtn.click();
        Thread.sleep(1000);
        By dinhdangLocator = By.xpath("//li[p[text()='" + format + "']]");
        WebElement dinhdang  = wait50.until(ExpectedConditions.visibilityOfElementLocated(dinhdangLocator));
        Thread.sleep(1000);
        dinhdang.click();
    }
    public void clickConvertedIntoVoice() throws InterruptedException {
        WebElement chuyenthanhgiongnoi = wait50.until(ExpectedConditions.visibilityOfElementLocated(chuyenthanhgiongnoiLocator));
        Thread.sleep(2000);
        chuyenthanhgiongnoi.click();

    }

}

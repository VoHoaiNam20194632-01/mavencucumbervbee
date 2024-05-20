package Pages.Login;

import driver.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class    LoginPage {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    //wait
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    By mailLocator = By.id("username");
    By passwordLocator = By.id("password");
    By studio = By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div/div[1]/div");
    By captchaLocator = By.id("recaptcha-anchor");
    By loginLocator = By.xpath("//button[contains(text(), 'Đăng nhập')]");
By khongLocator= By.xpath("/html/body/div[7]/div[3]/div/div[1]/button");
By boquaLocator = By.xpath("//button[@aria-label='close' and @data-action='skip']");

    public void captureScreen(String name) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("image\\Login\\" + name));
    }
    public static boolean isElementPresent(WebDriver driver, By by) {
        return !driver.findElements(by).isEmpty();
    }
    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterUsername(String username ){
        WebElement mailbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(mailLocator));
        mailbtn.sendKeys(username);
    }
    public  void enterPassword(String password){
        WebElement passwordbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordbtn.sendKeys(password);
    }
    public  void confirmCaptcha() throws Exception {
        WebElement captcharbtn = driver.findElement(captchaLocator );
        captcharbtn .click();
        Thread.sleep(70000);


    }


    public  void clickLogin() throws IOException {
        WebElement loginbtn = driver.findElement(loginLocator);
        captureScreen("ClickLogin.png");
        loginbtn.click();
    }
    public void ErrorMessage(){
        boolean isErrorMessageDisplayed = isElementPresent(driver, By.className("alert-error"));
        if (!isErrorMessageDisplayed) {
            throw new AssertionError("Kiểm thử không thành công: Thông báo lỗi không xuất hiện.");
        } else {
            System.out.println("Kiểm thử thành công: Thông báo lỗi xuất hiện.");
        }
    }
    public void NotBeLoggedIn( ){
        String URLNotLoggin = "https://dev-studio.vbee.vn/studio/text-to-speech";
        if(driver.getCurrentUrl() == URLNotLoggin){
            throw  new AssertionError("Failse");
        }{
            System.out.println("pass");
        }
    }
    public void clickNoButton() throws InterruptedException {
        WebElement boquabtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(boquaLocator));
        boquabtn.click();
    }

}

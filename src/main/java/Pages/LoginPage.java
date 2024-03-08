package Pages;

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
    // Locator
    By mailLocator = By.id("username");
    By passwordLocator = By.id("password");
    By studio = By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div/div[1]/div");
    By captchaLocator = By.id("recaptcha-anchor");
    By loginLocator = By.xpath("//button[contains(text(), 'Đăng nhập')]");
By khongLocator= By.xpath("/html/body/div[7]/div[3]/div/div[1]/button");
    public void captureScreen(String name) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("image\\Login\\" + name));
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
    public  void confirmCaptcha() throws InterruptedException {
        WebElement captcharbtn = driver.findElement(captchaLocator );
        captcharbtn .click();
        Thread.sleep(70000);
    }
    public  void clickLoginButton() throws IOException {
        WebElement loginbtn = driver.findElement(loginLocator);
        captureScreen("ClickLogin.png");
        loginbtn.click();
    }
    public void clickStudioButton() throws IOException {
        WebElement studiobtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(studio));
        captureScreen("PageStudio.png");
        studiobtn.click();
    }
    public void clickNoButton() throws InterruptedException {
        WebElement khongbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(khongLocator));
        khongbtn.click();
    }
}

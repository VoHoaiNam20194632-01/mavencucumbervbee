package Pages;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    By xLocator = By.xpath("/html/body/div[6]/div[3]/div/div[1]/button");
    By xxLocator = By.xpath("//*[@id=\"mui-61\"]/button");
    By khongLocator = By.id("moe-dontallow_button");
    By boquaLocator = By.xpath("//*[@id=\"react-joyride-step-0\"]/div/div/div[1]/div[3]/button/div/div");

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
        Thread.sleep(20000);
    }
    public  void clickLoginButton(){
        WebElement loginbtn = driver.findElement(loginLocator);
        loginbtn.click();
    }
    public void clickStudioButton(){
        WebElement studiobtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(studio));
        studiobtn.click();
    }
    public void clickNoButton(){
        WebElement xbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(xLocator));
        WebElement khongbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(khongLocator));
        khongbtn.click();
        xbtn.click();
        System.out.println("bat dau tim xx");
        WebElement xxbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(xxLocator));
        xxbtn.click();
        WebElement boquabtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(boquaLocator));
        boquabtn.click();
    }
}

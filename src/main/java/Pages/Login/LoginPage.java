package Pages.Login;

import driver.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class    LoginPage {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    //wait
    static Duration timeout50 = Duration.ofSeconds(50);
    static WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
By bannerLocator = By.cssSelector("#react-joyride-step-0 > div > div > div.css-1d6o3ci > div.css-1549j9j > button");
    public static boolean isElementPresent(WebDriver driver, By by) {
        return !driver.findElements(by).isEmpty();
    }
    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void  UrlLogin(){
        WebElement loginButton = driver.findElement(By.id("login-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
        WebElement ttsloginButton = driver.findElement(By.id("tts-login-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ttsloginButton);
    }
    public void clickLoginBtn(){
        WebElement ggBtn = driver.findElement(By.id("social-google"));
        ggBtn.click();

    }
    public void enterUsername(String username ) throws InterruptedException {
        WebElement email= driver.findElement(By.id("username"));
        email.sendKeys(username);
    }
    public  void enterPassword(String password) throws InterruptedException {
        WebElement pw = driver.findElement(By.id("password"));
        pw.sendKeys(password);
    }
    public void enterUsernamegg(String username ) throws InterruptedException {
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys(username);
        email.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
//        WebElement email= driver.findElement(By.id("username"));
//        email.sendKeys(username);
    }
    public  void enterPasswordgg(String password) throws InterruptedException {
        WebElement pw = driver.findElement(By.name("Passwd"));
        pw.click();
        pw.click();
        Thread.sleep(5000);
        pw.sendKeys(password);
        pw.sendKeys(Keys.ENTER);
//        WebElement pw = driver.findElement(By.id("password"));
//        pw.sendKeys(password);
    }
    public void clickLogin(){
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[1]/div/div/div/div[1]/div/div/div[2]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
    }


    public void ErrorMessagegg(){
        boolean isErrorMessageDisplayed = isElementPresent(driver, By.xpath("//div[@jsname='B34EJ']"));
        if (!isErrorMessageDisplayed) {
            throw new AssertionError("Kiểm thử không thành công: Thông báo lỗi không xuất hiện.");

        } else {
            System.out.println("Kiểm thử thành công: Thông báo lỗi xuất hiện.");
        }
    }
    public  void ErrorMessage(){
        boolean isErrorMessageDisplayed = isElementPresent(driver, By.cssSelector(".text-xs.text-red-500.py-1.pl-1"));
        if (!isErrorMessageDisplayed) {
            throw new AssertionError("Kiểm thử không thành công: Thông báo lỗi không xuất hiện.");

        } else {
            System.out.println("Kiểm thử thành công: Thông báo lỗi xuất hiện.");
        }
    }
    public void clickNoButton() throws InterruptedException {
        Thread.sleep(3000);
        WebElement bannerbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(bannerLocator));
        bannerbtn.click();
    }

}

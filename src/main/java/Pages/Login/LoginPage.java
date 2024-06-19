package Pages.Login;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
By bannerLocator = By.xpath("//button[@aria-label='close' and @data-action='skip']");
    public static boolean isElementPresent(WebDriver driver, By by) {
        return !driver.findElements(by).isEmpty();
    }
    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickLoginBtn(){
        WebElement ggBtn = driver.findElement(By.id("social-google"));
        ggBtn.click();

    }
    public void enterUsername(String username ) throws InterruptedException {
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys(username);
        email.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }
    public  void enterPassword(String password) throws InterruptedException {
        WebElement pw = driver.findElement(By.name("Passwd"));
        pw.click();
        pw.click();
        Thread.sleep(5000);
        pw.sendKeys(password);
        pw.sendKeys(Keys.ENTER);
    }


    public void ErrorMessage(){
        boolean isErrorMessageDisplayed = isElementPresent(driver, By.xpath("//div[@jsname='B34EJ']"));
        if (!isErrorMessageDisplayed) {
            throw new AssertionError("Kiểm thử không thành công: Thông báo lỗi không xuất hiện.");
        } else {
            System.out.println("Kiểm thử thành công: Thông báo lỗi xuất hiện.");
        }
    }
    public void clickNoButton() throws InterruptedException {
        WebElement bannerbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(bannerLocator));
        bannerbtn.click();
    }

}

package Pages.Register;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    By RegisterStartLocator = By.xpath("/html/body/div[1]/div[3]/form/div[3]/span[2]");
    By emailLocator = By.id("email");
    By passwordLocator = By.id("password");
    By pwConfirmLocator = By.id("passwordConfirm");
    By RegisterLocator = By.xpath("//*[@id=\"kc-register-form\"]/div[2]/div[5]/button");

    public RegisterPage(WebDriver driver){
        RegisterPage.driver = driver;
    }
    public static boolean isElementPresent(WebDriver driver, By by) {
        return !driver.findElements(by).isEmpty();
    }
    public void clickRegisterStart(){
        WebElement RegisterStart = wait50.until(ExpectedConditions.visibilityOfElementLocated(RegisterStartLocator));
        RegisterStart.click();
    }
    public void enterEmail(String email){
        WebElement emailInput = wait50.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordInput = wait50.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordInput.sendKeys(password);
    }
    public void PasswwordConfirm(String pwConfirm){
        WebElement passwordConfirmInput = wait50.until(ExpectedConditions.visibilityOfElementLocated(pwConfirmLocator));
        passwordConfirmInput.sendKeys(pwConfirm);
    }
    public void clickRegister(){
        WebElement Register = wait50.until(ExpectedConditions.visibilityOfElementLocated(RegisterLocator));
        Register.click();
    }
    public void ErrorMessageRegister(){
        boolean isErrorMessageDisplayed = isElementPresent(driver, By.cssSelector("div.mt-2.text-red-600.text-xs.font-semibold"));
        if (!isErrorMessageDisplayed) {
            throw new AssertionError("Kiểm thử không thành công: Thông báo lỗi không xuất hiện.");
        } else {
            System.out.println("Kiểm thử thành công: Thông báo lỗi xuất hiện.");
        }
    }



}

package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sessionmanagement.WebDriverManager;

import java.time.Duration;
public class LoginVbeeSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
//    By dangnhapLocator = By.xpath("//*[@id=\"__next\"]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[1]");
//    By AIVoiceLocator = By.xpath("//*[@id=\"dropdown\"]/div/button[2]/div");
    By mailLocator = By.id("username");
    By passwordLocator = By.id("password");
    By studio = By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div/div[1]/div");
    By captchaLocator = By.id("recaptcha-anchor");
    By loginLocator = By.xpath("//button[contains(text(), 'Đăng nhậ')]");
    By xxLocator = By.cssSelector("#mui-91 > button");
    By khongLocator = By.id("moe-dontallow_button");
    By boquaLocator = By.xpath("//*[@id=\"react-joyride-step-0\"]/div/div/div[1]/div[3]/button/div/div");
    By chuyenvanbanLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/ul/li[1]/a");

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        System.out.println("inside Step - user is on login page vbee");
        driver.navigate().to("https://accounts.vbee.ai/auth/realms/vbee-holding/protocol/openid-connect/auth?client_id=vbee-tts-crm&redirect_uri=https%3A%2F%2Fvbee.vn%2Fservice-select&state=7534abb2-f6be-4092-86cb-0ce7c6bd1709&response_mode=fragment&response_type=code&scope=openid&nonce=fc76d0df-940d-48be-b404-a9e72e961f63");
//        WebElement dangnhapbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(dangnhapLocator));
//        dangnhapbtn.click();
//        WebElement AiVoicebtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(AIVoiceLocator));
//        AiVoicebtn.click();
    }

    @When("^user enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String username, String password)  {
        System.out.println("Inside Step - user enters username and password");
        WebElement mailbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(mailLocator));
        mailbtn.sendKeys(username);
        WebElement passwordbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordbtn.sendKeys(password);
    }

    @And("confirm captcha")
    public void confirmCaptcha() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        WebElement captcharbtn = driver.findElement(captchaLocator );
        captcharbtn .click();
        Thread.sleep(20000);
        driver.switchTo().defaultContent();
    }

    @And("click on login button")
    public void clickOnLoginButton() throws InterruptedException {
        WebElement loginbtn = driver.findElement(loginLocator);
        loginbtn.click();
    }

    @And("click on studio button")
    public void clickOnStudioButton() throws InterruptedException {
        System.out.println("dang tim thay studio");
        WebElement studiobtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(studio));
        System.out.println("da tim thay studio");
        studiobtn.click();
    }

    @And("click No")
    public void clickNo() throws InterruptedException {
        Thread.sleep(5000);
        // Tìm và ẩn hoặc loại bỏ phần tử quảng cáo
        System.out.println("bat dau tim x");
        By xLocator = By.xpath("/html/body/div[6]/div[3]/div/div[1]/button");
        System.out.println("dg tim");
        System.out.println(xLocator);
        WebElement xbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(xLocator));
        System.out.println(xbtn);
        WebElement khongbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(khongLocator));
        khongbtn.click();
        xbtn.click();
        System.out.println("bat dau tim xx");
        WebElement xxbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(xxLocator));
        xxbtn.click();
        WebElement boquabtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(boquaLocator));
        boquabtn.click();
    }
    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() throws InterruptedException {
        WebElement  chuyenvanbanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chuyenvanbanLocator));
        chuyenvanbanbtn.click();
        Thread.sleep(1000);
    }


}



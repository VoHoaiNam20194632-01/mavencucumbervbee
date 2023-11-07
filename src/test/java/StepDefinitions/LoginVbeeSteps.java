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

    By mailLocator = By.id("username");
    By passwordLocator = By.id("password");
    By studio = By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div/div[1]/div");
    By captchaLocator = By.id("recaptcha-anchor");
    By loginLocator = By.xpath("//button[contains(text(), 'Đăng nhập')]");
    By xLocator = By.xpath("/html/body/div[6]/div[3]/div/div[1]/button");
    By khongLocator = By.id("moe-dontallow_button");
    By boquaLocator = By.xpath("//*[@id=\"react-joyride-step-0\"]/div/div/div[1]/div[3]/button/div/div");

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        System.out.println("inside Step - user is on login page vbee");
        driver.navigate().to("https://dev-accounts.vbee.ai/auth/realms/vbee-holding/protocol/openid-connect/auth?client_id=vbee-website&redirect_uri=https%3A%2F%2Fdev.vbee.vn%2Fservice-select&state=26abd2aa-0272-4623-8ce8-a32233d08c69&response_mode=fragment&response_type=code&scope=openid&nonce=1b45e277-ce7c-4afb-84dd-4ba3da891734");
    }

    @When("^user enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String username, String password) throws InterruptedException {
        System.out.println("Inside Step - user enters username and password");
        WebElement mailbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(mailLocator));
        mailbtn.sendKeys(username);
        WebElement passwordbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordbtn.sendKeys(password);
    }

    @And("confirm capcha")
    public void confirmCapcha() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        WebElement captcharbtn = driver.findElement(captchaLocator );
        captcharbtn .click();
        Thread.sleep(50000);
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
        WebElement khongbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(khongLocator));
        khongbtn.click();
        WebElement boquabtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(boquaLocator));
        boquabtn.click();
    }
    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {

    }


}

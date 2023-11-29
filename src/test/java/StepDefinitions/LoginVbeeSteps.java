package StepDefinitions;

import Pages.LoginPage;
import driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class LoginVbeeSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
private LoginPage loginPage;
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        System.out.println("inside Step - user is on login page vbee");
        driver.navigate().to("https://accounts.vbee.ai/auth/realms/vbee-holding/protocol/openid-connect/auth?client_id=vbee-website&redirect_uri=https%3A%2F%2Fvbee.vn%2Fservice-select&state=e4d1e4dd-1e6a-478c-84a2-53428e35cf6d&response_mode=fragment&response_type=code&scope=openid&nonce=69d8844f-1e15-4fad-83b0-367cbf579305");
        loginPage = new LoginPage(driver);
    }

    @When("^user enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String username, String password) throws InterruptedException {
        System.out.println("Inside Step - user enters username and password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("confirm captcha")
    public void confirmCaptcha() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        loginPage.confirmCaptcha();
        driver.switchTo().defaultContent();
    }

    @And("click on login button")
    public void clickOnLoginButton() throws InterruptedException {
        loginPage.clickLoginButton();
    }

    @And("click on studio button")
    public void clickOnStudioButton() throws InterruptedException {
        System.out.println("dang tim thay studio");
        loginPage.clickStudioButton();
    }

    @And("click No")
    public void clickNo() throws InterruptedException {
        System.out.println("bat dau tim x");
//        System.out.println("dg tim");
//        System.out.println(xLocator);
//        WebElement xbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(xLocator));
//        System.out.println(xbtn);
        loginPage.clickNoButton();
    }
    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {

    }
    @After
    public  void TearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
    }


}

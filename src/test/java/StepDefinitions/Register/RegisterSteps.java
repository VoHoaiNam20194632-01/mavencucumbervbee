package StepDefinitions.Register;

import Pages.Register.RegisterPage;
import driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class RegisterSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    private RegisterPage registerPage;

    @Given("user is on register page")
    public void userIsOnRegisterPage() throws IOException {
        System.out.println("inside Step - user is on register page vbee");
        driver.navigate().to("https://dev-accounts.vbee.ai/auth/realms/vbee-holding/protocol/openid-connect/auth?client_id=vbee-tts-crm&redirect_uri=https%3A%2F%2Fdev-studio.vbee.vn%2Fstudio%2Ftext-to-speech&state=0c021e5f-9aaa-4c4d-88d9-ade550fe12c7&response_mode=fragment&response_type=code&scope=openid&nonce=d59fd6ea-8bc1-4aba-91ab-3f3a8f0126a8");
        registerPage = new RegisterPage(driver);
        Dimension size = driver.manage().window().getSize();

        // In ra kích thước
        System.out.println("Chiều rộng của cửa sổ: " + size.getWidth());
        System.out.println("Chiều cao của cửa sổ: " + size.getHeight());
        captureScreenshot("trang register");
    }

    @When("click Register")
    public void clickRegister() throws IOException {
        System.out.println("click Register start");
        registerPage.clickRegisterStart();
        captureScreenshot("register strart");
    }
    @And("click  register new")
    public void clickRegisterNew() {
        System.out.println("click Register start");
        registerPage = new RegisterPage(driver);
        registerPage.clickRegisterStartNew();
    }

    @And("user enters {string} username register")
    public void userEntersUsernameRegister(String email) {
        System.out.println("enter email");
        registerPage.enterEmail(email);
    }
    @And("user enter {string}  password register")
    public void userEnterPasswordRegister(String password) {
        System.out.println("enter password");
        registerPage.enterPassword(password);
    }
    @And("user enter {string}  password confirm register")
    public void userEnterPasswordConfirmRegister(String passwordconfirm) throws IOException {
        System.out.println("confirm password");
        registerPage.PasswwordConfirm(passwordconfirm);
        captureScreenshot("hoanthanh register");
    }
    @And("click  Register button")
    public void clickRegisterButton() {
    System.out.println("click register btn");
    registerPage.clickRegister();
    }
    @And("click  Register new button")
    public void clickRegisterNewButton() {
        registerPage.clickRegisterNew();
    }
    @And("Error message register")
    public void errorMessageRegister() {
        registerPage.ErrorMessageRegister();
    }
    @After
    public void TearDown(Scenario scenario) {
        if (
                scenario.isFailed()
        ) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
        }

    }
    public void captureScreenshot(String stepName) throws IOException {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(stepName, new ByteArrayInputStream(screenshot));
    }
}

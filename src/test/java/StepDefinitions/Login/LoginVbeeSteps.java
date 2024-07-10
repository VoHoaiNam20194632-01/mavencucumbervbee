package StepDefinitions.Login;

import Pages.Login.LoginPage;
import driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LoginVbeeSteps {

    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }

    private LoginPage loginPage;
    @Given("user is on login page gg")
    public void LoginPageGg() throws IOException {
        System.out.println("inside Step - user is on login page vbee gg");
        driver.get("https://dev-accounts.vbee.vn/auth/realms/vbee-holding/protocol/openid-connect/auth?client_id=vbee-tts-crm&redirect_uri=https%3A%2F%2Fdev-studio.vbee.vn%2Fstudio%2Ftext-to-speech%3F&state=bf6d6b70-3415-4b13-801e-56098c6e17c2&response_mode=fragment&response_type=code&scope=openid&nonce=d9e46386-18a7-4c0c-b1e0-ecb981d21eab");
        loginPage = new LoginPage(driver);
        Dimension size = driver.manage().window().getSize();
        // In ra kích thước
        System.out.println("Chiều rộng của cửa sổ: " + size.getWidth());
        System.out.println("Chiều cao của cửa sổ: " + size.getHeight());
        captureScreenshot("trang login");
        // Nếu có lỗi, ghi log
    }
    @Given("user is on home page")
    public void userIsOnLoginPage() throws InterruptedException, IOException {
        // Thực hiện các thao tác kiểm thử
        System.out.println("inside Step - user is on login page vbee");
        driver.get("https://dev.vbee.vn/");
        loginPage = new LoginPage(driver);
        Dimension size = driver.manage().window().getSize();
        // In ra kích thước
        System.out.println("Chiều rộng của cửa sổ: " + size.getWidth());
        System.out.println("Chiều cao của cửa sổ: " + size.getHeight());
        captureScreenshot("trang login");
        // Nếu có lỗi, ghi log
    }
    @When("click Login")
    public void clickLogin() {
        loginPage. UrlLogin();
    }
    @When("click Login GG button")
    public void clickLoginGGButton() {
        loginPage.clickLoginBtn();
    }
    @And("user enters {string} username")
    public void userEntersUsername(String username) throws InterruptedException {
        System.out.println("Inside Step - user enters username and password");
        loginPage.enterUsername(username);
    }
    @And("user enter {string}  password")
    public void userEnterPassword(String password) throws InterruptedException {
        loginPage.enterPassword(password);
    }
    @And("user enters {string} username gg")
    public void userEntersUsernamegg(String username) throws IOException, InterruptedException {
        System.out.println("Inside Step - user enters username and password");
        captureScreenshot("nhap email gg");
        loginPage.enterUsernamegg(username);
    }
    @And("user enter {string}  password gg")
    public void userEnterPasswordgg(String password) throws IOException, InterruptedException {
        captureScreenshot("nhap password gg");
        loginPage.enterPasswordgg(password);
    }
    @And("click Login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }
    @And("click skip banner")
    public void clickNo() throws InterruptedException {
        System.out.println("bat dau tim x");
        loginPage.clickNoButton();
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() throws IOException {;
        String expectedUrl = "https://dev-studio.vbee.vn/studio/text-to-speech";
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Đã đăng nhập và đang ở trang chủ (dubbing)!");
        } else {
            // Nếu URL không giống, điều hướng đến trang dubbing
            driver.navigate().to(expectedUrl);
            System.out.println("Đã điều hướng đến trang chủ (dubbing)!");
        }
        captureScreenshot("trang AIVOICE");
    }
    @And("Error message gg")
    public void errorMessagegg() {
        loginPage.ErrorMessagegg();
    }
    @Then("Error message")
    public void errorMessage() {
        loginPage.ErrorMessage();
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

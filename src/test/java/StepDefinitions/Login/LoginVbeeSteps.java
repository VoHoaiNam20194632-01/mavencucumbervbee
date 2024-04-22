package StepDefinitions.Login;

import Pages.LoginPage;
import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginVbeeSteps {

    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
//    public static void checkAPI() {
//        // Setup WebDriver
//
//        DevTools devTools = ((ChromeDriver) driver).getDevTools();
//        devTools.createSession();
//
//        // Enable network domain
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//        // Set up event listener for responseReceived
//        devTools.addListener(Network.responseReceived(), responseReceived -> {
//            Response response = responseReceived.getResponse();
//            int status = response.getStatus();
//            if (status  >= 400) {
//                LogToFile.log("Request URL: " + response.getUrl() + " returned status code: " + status);
//            }
//        });
//    }

private LoginPage loginPage;
    @Given("user is on login page")
    public void userIsOnLoginPage() {
            // Thực hiện các thao tác kiểm thử
            System.out.println("inside Step - user is on login page vbee");
            driver.navigate().to("https://dev-accounts.vbee.ai/auth/realms/vbee-holding/protocol/openid-connect/auth?client_id=vbee-tts-crm&redirect_uri=https%3A%2F%2Fdev-studio.vbee.vn%2Fstudio%2Ftext-to-speech&state=0c021e5f-9aaa-4c4d-88d9-ade550fe12c7&response_mode=fragment&response_type=code&scope=openid&nonce=d59fd6ea-8bc1-4aba-91ab-3f3a8f0126a8");
            loginPage = new LoginPage(driver);
            // Nếu có lỗi, ghi log
    }
//    @When("click Login button")
//    public void clickLoginButton() throws IOException {
//    loginPage.clickLoginbtn();
//    }
//
//    @And("click AI Voice Stuio button")
//    public void clickAIVoiceStuioButton() {
//        loginPage.clickAivoiceStudiobtn();
//    }
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
    public void clickOnLoginButton() throws InterruptedException, IOException {
        loginPage.clickLogin();


    }

    @And("click on studio button")
    public void clickOnStudioButton() throws InterruptedException, IOException {
        System.out.println("dang tim thay studio");
        loginPage.clickStudioButton();


    }

    @And("click No")
    public void clickNo() throws InterruptedException {
        System.out.println("bat dau tim x");
        loginPage.clickNoButton();

    }
    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() throws IOException {
        String expectedUrl = "https://dev-studio.vbee.vn/studio/text-to-speech";
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Đã đăng nhập và đang ở trang chủ (dubbing)!");
        } else {
            // Nếu URL không giống, điều hướng đến trang dubbing
            driver.navigate().to(expectedUrl);
            System.out.println("Đã điều hướng đến trang chủ (dubbing)!");
        }

        captureScreen("HomePage.png");

    }

    public void captureScreen(String name) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("image\\Login\\" + name));
    }

    @When("the user enters an invalid {string} username")
    public void theUserEntersAnInvalidUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("enters a valid {string} password")
    public void entersAValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        loginPage.ErrorMessage();
    }

    @And("the user should not be logged in")
    public void theUserShouldNotBeLoggedIn() {
        loginPage.NotBeLoggedIn();
    }

    @When("the user enters a valid username {string}")
    public void theUserEntersAValidUsername(String username) {
        loginPage.enterUsername(username);

    }

    @And("enters an invalid password {string}")
    public void entersAnInvalidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user leaves the username {string} field and password {string}field empty")
    public void theUserLeavesTheUsernameFieldAndPasswordFieldEmpty(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    private static class LogToFile {
        private static final String FILE_PATH = "image\\excel\\log.txt";

        public static void log(String message) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
                writer.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

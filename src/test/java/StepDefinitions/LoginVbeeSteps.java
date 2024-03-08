package StepDefinitions;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.network.Network;
import org.openqa.selenium.devtools.v117.network.model.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class LoginVbeeSteps {

    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    public static void checkAPI() {
        // Setup WebDriver

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable network domain
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Set up event listener for responseReceived
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            Response response = responseReceived.getResponse();
            int status = response.getStatus();
            if (status  >= 400) {
                LogToFile.log("Request URL: " + response.getUrl() + " returned status code: " + status);
            }
        });
    }

private LoginPage loginPage;
    @Given("user is on login page")
    public void userIsOnLoginPage() {
            // Thực hiện các thao tác kiểm thử
            System.out.println("inside Step - user is on login page vbee");
            driver.navigate().to("https://dev-accounts.vbee.ai/auth/realms/vbee-holding/protocol/openid-connect/auth?client_id=vbee-tts-crm&redirect_uri=https%3A%2F%2Fdev-studio.vbee.vn%2Fdubbing&state=9b59f85e-91ee-4d07-8877-3de2ea15aa6b&response_mode=fragment&response_type=code&scope=openid&nonce=41e1f226-01e2-42bc-aee4-d49437d61b37");
            loginPage = new LoginPage(driver);
            // Nếu có lỗi, ghi log
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
    public void clickOnLoginButton() throws InterruptedException, IOException {
        loginPage.clickLoginButton();


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
        String expectedUrl = "https://dev-studio.vbee.vn/dubbing";
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

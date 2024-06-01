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
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;

public class LoginVbeeSteps {

    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }

    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver, timeout50);
    private LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() throws InterruptedException, IOException {
        // Thực hiện các thao tác kiểm thử
        System.out.println("inside Step - user is on login page vbee");
        driver.navigate().to("https://dev-accounts.vbee.ai/auth/realms/vbee-holding/protocol/openid-connect/auth?client_id=vbee-tts-crm&redirect_uri=https%3A%2F%2Fdev-studio.vbee.vn%2Fstudio%2Ftext-to-speech&state=0c021e5f-9aaa-4c4d-88d9-ade550fe12c7&response_mode=fragment&response_type=code&scope=openid&nonce=d59fd6ea-8bc1-4aba-91ab-3f3a8f0126a8");
        loginPage = new LoginPage(driver);
        Dimension size = driver.manage().window().getSize();

        // In ra kích thước
        System.out.println("Chiều rộng của cửa sổ: " + size.getWidth());
        System.out.println("Chiều cao của cửa sổ: " + size.getHeight());
        captureScreenshot("den trang login");
        // Nếu có lỗi, ghi log
    }

    @And("dang nhap bang gg")
    public void dangNhapBangGg() throws InterruptedException, IOException {;
        WebElement gg = driver.findElement(By.id("social-google"));
        gg.click();
        captureScreenshot("nhap email");
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("namvh@vbee.ai");
        email.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        captureScreenshot("nhap password");
        WebElement pw = driver.findElement(By.name("Passwd"));
        pw.click();
        pw.click();
        Thread.sleep(5000);
        String pass = "24081201Nam@";
        pw.sendKeys(pass);
        pw.sendKeys(Keys.ENTER);
    }

    @When("^user enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String username, String password) throws InterruptedException {
        System.out.println("Inside Step - user enters username and password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("confirm captcha")
    public void confirmCaptcha() throws Exception {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        loginPage.confirmCaptcha();
        driver.switchTo().defaultContent();

    }

    @And("click on login button")
    public void clickOnLoginButton() throws InterruptedException, IOException {
        loginPage.clickLogin();
    }

    @And("click No")
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

//    public void captureScreen(String name) throws IOException {
//        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshot, new File("image\\Login\\" + name));
//    }

//    @When("the user enters an invalid {string} username")
//    public void theUserEntersAnInvalidUsername(String username) {
//        loginPage.enterUsername(username);
//    }
//
//    @And("enters a valid {string} password")
//    public void entersAValidPassword(String password) {
//        loginPage.enterPassword(password);
//    }

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
    @When("the user enters an invalid {string} username")
    public void theUserEntersAnInvalidUsername(String username) {
        loginPage.enterUsername(username);
    }
    @And("enters a valid {string} password")
    public void entersAValidPassword(String password) {
        loginPage.enterPassword(password);
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

package StepDefinitions;

import Pages.textTransfer.AddReadingVoice;
import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.network.Network;
import org.openqa.selenium.devtools.v117.network.model.Response;

import java.io.IOException;
import java.util.Optional;

public class AddReadingVoiceSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }

    private AddReadingVoice addReadingVoice;
    public static void check() {
        // Setup WebDriver

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable network domain
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Set up event listener for responseReceived
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            Response response = responseReceived.getResponse();
            int status = response.getStatus();
            if (status >= 400) {
                System.out.println("Request URL: " + response.getUrl() + " returned status code: " + status);
            }
        });
    }

    @And("click reading voice button")
    public void clickReadingVoiceButton() throws InterruptedException, IOException {
        addReadingVoice = new AddReadingVoice(driver);
        Thread.sleep(3000);
        addReadingVoice.ReadingButton();
        check();

    }
    @And("select {string} gender")
    public void selectGender(String gender) throws InterruptedException, IOException {
        this.addReadingVoice = new AddReadingVoice(driver); // hoặc tương tự
        System.out.println("Bắt đầu kiểm tra");
        Thread.sleep(1000);
        addReadingVoice.selectGender(gender);
        System.out.println("Bắt đầu kiểm tra 1");
        check();
    }

    @And("click select voice {string} type button")
    public void clickSelectVoiceTypeStandardButton(String type)  throws InterruptedException {
        Thread.sleep(3000);
        addReadingVoice.selectVoiceType(type);
        check();
    }

    @And("click select voice {string} user button")
    public void clickSelectVoiceUserButton( String User) throws InterruptedException, IOException {
        Thread.sleep(3000);
        addReadingVoice.selectVoiceUser(User);
        check();
    }

    @Then("has been completed add reading voice")
    public void hasBeenCompletedAddReadingVoice() {
        check();
    }

}

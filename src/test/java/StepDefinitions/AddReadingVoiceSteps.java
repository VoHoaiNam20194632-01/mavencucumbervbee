package StepDefinitions;

import Pages.textTransfer.AddReadingVoice;
import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddReadingVoiceSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }

    private AddReadingVoice addReadingVoice;

    @When("click reading voice button")
    public void clickReadingVoiceButton()  throws InterruptedException {
        addReadingVoice = new AddReadingVoice(driver);
        Thread.sleep(3000);
        addReadingVoice.ReadingButton();

    }
    @And("select {string} gender")
    public void selectGender(String gender)  throws InterruptedException {
        System.out.println("Bắt đầu kiểm tra");
        Thread.sleep(1000);
        addReadingVoice.selectGender(gender);
        System.out.println("Bắt đầu kiểm tra 1");
    }

    @And("click select {string} language button")
    public void clickSelectLanguageButton(String language) throws InterruptedException {
        Thread.sleep(1000);
        addReadingVoice.selectLanguage(language);
    }

    @And("click select voice {string} type button")
    public void clickSelectVoiceTypeStandardButton(String type)  throws InterruptedException {
        Thread.sleep(3000);
        addReadingVoice.selectVoiceType(type);
    }

    @And("click select voice {string} user button")
    public void clickSelectVoiceUserButton( String User) throws InterruptedException {
        Thread.sleep(3000);
        addReadingVoice.selectVoiceUser(User);
    }

    @Then("has been completed add reading voice")
    public void hasBeenCompletedAddReadingVoice() {
    }

}

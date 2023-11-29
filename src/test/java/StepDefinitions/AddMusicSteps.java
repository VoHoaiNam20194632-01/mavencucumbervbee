package StepDefinitions;

import Pages.textTransfer.AddMusic;
import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class AddMusicSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    private AddMusic addMusic;
    @When("click on music button")
    public void clickOnMusicButton()  throws InterruptedException {
        addMusic = new AddMusic(driver);
        Thread.sleep(2000);
        addMusic.clickMusicButton();
    }

    @And("click select {string} music")
    public void clickSelectMusic(String music)    {
        System.out.println(music);
        addMusic.selectMusic(music);
    }

    @And("click on accept music button")
    public void clickOnAcceptMusicButton() {
        addMusic.acceptMusic();
    }

    @Then("has been completed background music")
    public void hasBeenCompletedBackgroundMusic() {
    }
}

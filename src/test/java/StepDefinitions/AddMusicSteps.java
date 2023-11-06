package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sessionmanagement.WebDriverManager;
import  java.time.Duration;


public class AddMusicSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50= Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    By nhannenLocator = By.xpath("//button[@aria-label='Tùy chọn nhạc nền ']");
    By chonnhacnenLocator = By.xpath("/html/body/div[6]/div[3]/div/div/div[1]/ul/li[5]");
    By apdungLocator = By.xpath("//button[contains(text(), 'Áp dụng')]");
    @When("click on music button")
    public void clickOnMusicButton()  throws InterruptedException {
        Thread.sleep(2000);
        WebElement nhacnen = wait50.until(ExpectedConditions.visibilityOfElementLocated(nhannenLocator));
        nhacnen.click();

    }

    @And("select music")
    public void selectMusic()   throws InterruptedException {
        WebElement chonnhacnen = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonnhacnenLocator));
        chonnhacnen.click();

    }

    @And("click on accept music button")
    public void clickOnAcceptMusicButton() throws InterruptedException {
        WebElement apdung = wait50.until(ExpectedConditions.visibilityOfElementLocated(apdungLocator));
        apdung.click();

    }

    @Then("has been completed background music")
    public void hasBeenCompletedBackgroundMusic() {
    }
}

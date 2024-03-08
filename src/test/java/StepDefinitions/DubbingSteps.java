package StepDefinitions;

import Pages.Dubbing;
import driver.WebDriverManager;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class DubbingSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    static Duration timeout50 = Duration.ofSeconds(50);

    static WebDriverWait wait50 = new WebDriverWait(driver, timeout50);
    private Dubbing dubbing;
    @And("click upload files {string} from computer")
    public void clickUploadFilesFromComputer(String Files) throws InterruptedException, AWTException {
        dubbing = new Dubbing(driver);
        dubbing.AddFileSubTitle(Files);

    }
    @And("choose readers {string}")
    public void chooseReaders(String users) {
        dubbing.clickChonNguoi(users);
    }
    @And("click on subtitle switch button")
    public void clickOnSubtitleSwitchButton() {
        dubbing.clickChuyenPhuDe();
    }
}

package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sessionmanagement.WebDriverManager;

import java.time.Duration;

public class AddTextSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);

    By chuyenvanbanLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/ul/li[1]/a");
    By nhapvanbanLocator = By.xpath("//*[@id=\"enter-text-here\"]/div[1]/div/div[2]/div");
    By dinhdangvideoLocator = By.xpath("//button[@aria-label='Thay đổi định dạng audio'] ");
    By dinhdangmp3Locator = By.xpath("//li[p[text()='mp3']]");
    By chuyenthanhgiongnoiLocator = By.cssSelector("#convert-tts");
    By HuynoidungLocator = By.xpath("/html/body/div[6]/div[3]/div/div[2]/button[1]");
    @Given("the home page")
    public void theHomePage() throws InterruptedException {
        WebElement  chuyenvanbanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chuyenvanbanLocator));
        chuyenvanbanbtn.click();
        Thread.sleep(1000);
    }
    @When("click on add text button and add text")
    public void clickOnAddTextButtonAndAddText() throws InterruptedException {
        System.out.println("bat dau nhap");
        WebElement nhap = wait50.until(ExpectedConditions.visibilityOfElementLocated(nhapvanbanLocator));
        nhap.sendKeys("vo hoai nam");
        Thread.sleep(1000);
        System.out.println("dang nhap gan xong roi");
    }
    @And("click change format video button and click mpba button")
    public void clickChangeFormatVideoButtonAndClickMpbaButton() throws InterruptedException {
        WebElement dinhdang = wait50.until(ExpectedConditions.visibilityOfElementLocated(dinhdangvideoLocator));
        dinhdang.click();
        Thread.sleep(1000);
        WebElement mp3 = wait50.until(ExpectedConditions.visibilityOfElementLocated(dinhdangmp3Locator));
        Thread.sleep(1000);
        mp3.click();
    }
    @And("click on converted into voice button")
    public void clickOnConvertedIntoVoiceButton() throws InterruptedException {
        WebElement chuyenthanhgiongnoi = wait50.until(ExpectedConditions.visibilityOfElementLocated(chuyenthanhgiongnoiLocator));
        chuyenthanhgiongnoi.click();
        Thread.sleep(1000);

    }
    @Then("page chuyen van ban")
    public void pageChuyenVanBan() throws InterruptedException {

    }


}

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

import java.time.Duration;

public class AddReadingVoiceSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    By chonbtngiongdocLocator = By.xpath("//button[@aria-label='Chọn giọng đọc']    ");
    By gioitinhnamLocator = By.cssSelector("input[type='checkbox'][value='male']");
    By ngonnguvietnamLocator = By.cssSelector("input[type='checkbox'][value='vi-VN']");
    By loaigiongtieuchuanLocator = By.cssSelector("input[type='checkbox'][value='BASIC']");
    By chonguoiLocator = By.xpath("//button[@aria-label='SG - Trung Kiên voice']");

    @When("click reading voice button")
    public void clickReadingVoiceButton()  throws InterruptedException {
        System.out.println(chonbtngiongdocLocator);
        Thread.sleep(3000);
        WebElement giongdocbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonbtngiongdocLocator));
        giongdocbtn.click();
    }
    @And("click select gender male button")
    public void clickSelectGenderMaleButton()  throws InterruptedException {
        Thread.sleep(1000);
        WebElement gioitinhnambtn = driver.findElement(gioitinhnamLocator);
        Thread.sleep(1000);
        gioitinhnambtn.click();
    }

    @And("click select language Viet Nam button")
    public void clickSelectLanguageVietNamButton() throws InterruptedException {
        Thread.sleep(1000);
        WebElement ngonngubtn = driver.findElement(ngonnguvietnamLocator);
        Thread.sleep(1000);
        ngonngubtn.click();
    }

    @And("click select voice type standard button")
    public void clickSelectVoiceTypeStandardButton()  throws InterruptedException {
        Thread.sleep(3000);
        WebElement loaigiong = driver.findElement(loaigiongtieuchuanLocator);
        loaigiong.click();
    }

    @And("click select voice user button")
    public void clickSelectVoiceUserButton() throws InterruptedException {
        Thread.sleep(3000);
        WebElement chonnguoi = driver.findElement(chonguoiLocator);
        chonnguoi.click();
    }

    @Then("has been completed add reading voice")
    public void hasBeenCompletedAddReadingVoice() {
    }
}

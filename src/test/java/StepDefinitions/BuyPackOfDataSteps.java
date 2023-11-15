package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sessionmanagement.WebDriverManager;

import java.time.Duration;

public class BuyPackOfDataSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    By muagoicuocLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/ul/li[3]/a/div/div");
    By goi3thangLocator =By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/div/div[2]/div/button[2]");
    By muangayLocator = By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/div/div[3]/div[1]/div[2]/div/div/div[2]/button[1]");
    By boquaLocator = By.xpath("//*[@id=\"react-joyride-step-0\"]/div/div/div[1]/div[3]/button");
    By nganhangLocator = By.xpath("//*[@id=\"choosePaymentMethod\"]/div/div/div[2]/div[2]/div/div/div[2]");
    By thaydoisdtLocator = By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div[3]/p");
    By nhapsdtLocator = By.xpath("/html/body/div[6]/div[3]/div/div/div[1]/div[2]/div/div/input");
    By hoanthanhsdtLocator = By.xpath("//button[text()='Hoàn thành']");
    By thanhtoanLocator = By.xpath("//*[@id=\"makePayment\"]/button");
    By hoanthanhLocator = By.xpath("//button[text()='Hoàn tất']");
    @When("click buy pack of data button")
    public void clickBuyPackOfDataButton() throws InterruptedException {
        WebElement muagoicuocbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(muagoicuocLocator));
        muagoicuocbtn.click();
    }

    @And("click pack of data three months button")
    public void clickPackOfDataThreeMonthsButton() throws InterruptedException {
        Thread.sleep(1000);
        WebElement goi3thangbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(goi3thangLocator));
        goi3thangbtn.click();
        Thread.sleep(1000);
    }

    @And("click buy now button")
    public void clickBuyNowButton() throws InterruptedException {
        Thread.sleep(1000);
        WebElement muangaybtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(muangayLocator));
        muangaybtn.click();
        Thread.sleep(1000);
    }

    @And("bo qua")
    public void boQua()  {
        WebElement boquabtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(boquaLocator));
        boquabtn.click();
    }

    @And("Select payment bank")
    public void selectPaymentBank()  {
        WebElement nganhangbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(nganhangLocator));
        nganhangbtn.click();
    }

    @And("click change phone number button")
    public void clickChangePhoneNumberButton() throws InterruptedException {
        WebElement thaydoisdt = wait50.until(ExpectedConditions.visibilityOfElementLocated(thaydoisdtLocator));
        thaydoisdt.click();
    }

    @And("Enter phone number and complete")
    public void enterPhoneNumberAndComplete() throws InterruptedException {
//        WebElement nhapsdt = driver.findElement(nhapsdtLocator);
//        nhapsdt.click();
//        System.out.println("dang bat dau click");
//        Thread.sleep(3000);
//        Thread.sleep(3000);
//        System.out.println("dang bat dau xoa");
//        Thread.sleep(3000);
//        nhapsdt.clear();
//        Thread.sleep(3000);
//        System.out.println("da xoa va bat dau nhap");
//        Thread.sleep(3000);
//        nhapsdt.sendKeys("0355782142");
//        Thread.sleep(3000);
        WebElement hoanthanhsdtbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(hoanthanhsdtLocator));
        hoanthanhsdtbtn.click();
    }

    @And("click agree to pay button")
    public void clickAgreeToPayButton()  {
        WebElement thanhtoanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(thanhtoanLocator));
        thanhtoanbtn.click();
    }

    @And("click agree transfer button")
    public void clickAgreeTransferButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement toidachuyenkhoanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(thanhtoanLocator));
        toidachuyenkhoanbtn.click();
        WebElement hoanthanhbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(hoanthanhLocator));
        hoanthanhbtn.click();
    }

}

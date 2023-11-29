package StepDefinitions;

import Pages.BuyPackOfData;
import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class BuyPackOfDataSteps {

    private static WebDriver driver;
    static {
        driver = WebDriverManager.getDriver();
    }

    private BuyPackOfData buyPackOfData;



    @When("click buy pack of data button")
    public void clickBuyPackOfDataButton() throws InterruptedException {
       buyPackOfData = new BuyPackOfData(driver);
        buyPackOfData.clickBuyOfDataButtonAndCheck();

    }

    @And("click pack of data {string} months button")
    public void clickPackOfDataThreeMonthsButton(String months) throws InterruptedException {
      buyPackOfData.clickDataMonths(months);
    }

    @And("click buy now button")
    public void clickBuyNowButton() throws InterruptedException {
        buyPackOfData.clickBuyNowButton();
    }

    @And("bo qua")
    public void boQua()  {
       buyPackOfData.clickBoQua();

    }

    @And("Select payment bank")
    public void selectPaymentBank()  {
        buyPackOfData.clickSelectPaymentBank();
    }

    @And("click change phone number button")
    public void clickChangePhoneNumberButton() throws InterruptedException {
        buyPackOfData.clickChangePhoneButton();
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
        buyPackOfData.clickCompletePhone();
    }

    @And("click agree to pay button")
    public void clickAgreeToPayButton() throws InterruptedException {
        buyPackOfData.clickAgreeTopayButton();
    }

    @And("click agree transfer button")
    public void clickAgreeTransferButton() throws InterruptedException {
        buyPackOfData.clickAgreeTransferButton();
    }


}

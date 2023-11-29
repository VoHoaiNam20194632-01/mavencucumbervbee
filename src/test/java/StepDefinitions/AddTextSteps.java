package StepDefinitions;

import Pages.textTransfer.AddText;
import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddTextSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    private AddText addText;

    @When("^click on add text button and add (.*)$")
    public void clickOnAddTextButtonAndAddText(String text) throws InterruptedException {
        addText = new AddText(driver);
        addText.clickAddText(text);

    }

    @And("click change {string} format video button")
    public void clickChangeFormatVideoButton(String format) throws InterruptedException {
//        System.out.println(driver);
//        System.out.println("bat dau lan");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        System.out.println(driver);
//        Thread.sleep(3000);
//        js.executeScript("window.scrollBy(0, -100);");
//        System.out.println("da xong");
        addText.clickFormatVideo(format);
    }

    @And("click on converted into voice button")
    public void clickOnConvertedIntoVoiceButton() throws InterruptedException {
        addText.clickConvertedIntoVoice();
    }

    @And("remove cancel")
    public void removeCancel() {
//        try{
//        System.out.println("bat dau tim");
//        By huyLocator = By.xpath("/html/body/div[7]/div[3]/div/div[2]/button[1]");
//        System.out.println(huyLocator);
//        WebElement huybtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(huyLocator));
//        System.out.println(huybtn);
//        huybtn.click();
//        }catch (Exception e) {
//            // Nếu nút Remove không xuất hiện, in thông báo ra console và tiếp tục chạy kiểm thử
//            System.out.println("Nút Remove không xuất hiện. Tiếp tục chạy kiểm thử.");
//        }
    }
}

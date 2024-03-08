package StepDefinitions.DangKy;

import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class checkCaptcha {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    @And("Captcha chưa được xác nhận")
    public void captchaChưaĐượcXácNhận() {
    }

    @Then("Hien thi thong bao Ban can xac nhan Captcha")
    public void hienThiThongBaoBanCanXacNhanCaptcha() {
    }
}

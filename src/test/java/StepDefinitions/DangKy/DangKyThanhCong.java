package StepDefinitions.DangKy;

import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DangKyThanhCong {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    @Given("The user opens the browser and visits the registration page")
    public void theUserOpensTheBrowserAndVisitsTheRegistrationPage() {
    }
    @When("Nhap thong tin email {string} va password {string} hop le")
    public void nhapThongTinEmailVaPasswordHopLe(String email, String password) {
    }

    @And("click Dang ky")
    public void clickDangKy() {

    }

    @Then("Hien thi thong bao Check email de xac nhan dang ky")
    public void hienThiThongBaoCheckEmailDeXacNhanDangKy() {
    }


}

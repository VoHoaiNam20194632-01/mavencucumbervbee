package StepDefinitions.DangKy;

import driver.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class thatBaiEmailTonTai {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    @When("Nhap thong tin email {string} va password {string} ton tai")
    public void nhapThongTinEmailVaPasswordTonTai(String arg0, String arg1) {
    }



    @Then("Hien thi thong bao Email da ton tai")
    public void hienThiThongBaoEmailDaTonTai() {
    }
}

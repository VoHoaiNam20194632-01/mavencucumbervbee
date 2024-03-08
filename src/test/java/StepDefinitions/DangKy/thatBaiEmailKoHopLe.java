package StepDefinitions.DangKy;

import driver.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class thatBaiEmailKoHopLe {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    @When("Nhap thong tin email {string} va password {string} khong hop le")
    public void nhapThongTinEmailVaPasswordKhongHopLe(String arg0, String arg1) {
    }

    @Then("Hien thi thong bao Email khong hop le")
    public void hienThiThongBaoEmailKhongHopLe() {
    }
}

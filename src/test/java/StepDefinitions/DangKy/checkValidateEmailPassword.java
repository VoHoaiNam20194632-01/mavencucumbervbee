package StepDefinitions.DangKy;

import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class checkValidateEmailPassword {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    @When("Nhap thong tin voi truong Email <{string}> trong")
    public void nhapThongTinVoiTruongEmailTrong(String arg0) {
    }

    @And("Di chuyen sang truong khac")
    public void diChuyenSangTruongKhac() {
        
    }

    @Then("Hien thi thong bao Email khong duoc de trong")
    public void hienThiThongBaoEmailKhongDuocDeTrong() {
        
    }

    @When("Nhap password {string} chua dung")
    public void nhapPasswordChuaDung(String arg0) {
        
    }

    @Then("Hien thi thong bao {string}")
    public void hienThiThongBao(String arg0) {
    }
}

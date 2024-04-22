package StepDefinitions;

import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyPackDataSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    static Duration timeout50 = Duration.ofSeconds(50);
    static WebDriverWait wait50 = new WebDriverWait(driver, timeout50);
    private Pages.BuyPackData BuyPackData;

//    #  người dùng đang truy cập trang mua gói cước
    @When("the user is accessing the package purchase page")
    public void theUserIsAccessingThePackagePurchasePage() {
        BuyPackData = new Pages.BuyPackData(driver);
        BuyPackData.clickMuaGoiCuoc();
    }
    @And("Get the initial number of characters the account has")
    public void getTheInitialNumberOfCharactersTheAccountHas() {
        BuyPackData = new Pages.BuyPackData(driver);
        BuyPackData.LaySoKyTuTaiKhoanDaCo();
    }
//#    chọn gói cước miễn phí
    @And("the user selects the free package")
    public void theUserSelectsTheFreePackage() {
        BuyPackData.clickChonMuaGoiMienPhi();
    }

//#  hệ thống hiển thị xác nhận mua thành công
    @And("selects month")
    public void selectsMonth() throws InterruptedException {
        BuyPackData.clickChonGoiThang();
    }
    @And("selects quy")
    public void selectsQuy() {
        BuyPackData.clickChonGoiQuy();
    }
    @And("selects nam")
        public void selectsNam(){
        BuyPackData.clickChonGoiNam();
        }
//#  người dùng chọn gói cước tiêu chuẩn
    @And("the user selects the standard package")
    public void theUserSelectsTheStandardPackage() throws InterruptedException {
        BuyPackData.clickChonMuaGoiTieuChuan();
        Thread.sleep(500);
    }
    //chon mua goi chuyen nghiep
    @And("the user selects the professional package")
    public void theUserSelectsTheProfessionalPackage() {
        BuyPackData.clickChonMuaGoiChuyenNghiep();
    }
    //chon mua goi dac biet
    @And("the user selects the special package")
    public void theUserSelectsTheSpecialPackage() {
        BuyPackData.clickChonMuaGoiDacBiet();
    }
//#  thực hiện thanh toán
    @And("ramdom bank")
    public void ramdomBank() throws InterruptedException {
        BuyPackData.ramdomNganHang();
        Thread.sleep(500);
    }
    @And("select voucher {string} phan tram and pay")
    public void selectVoucherPhanTramAndPay(String voucher) throws InterruptedException {
        BuyPackData.chonVoucherPhanTramVaThanhToan(voucher);
    }
    @And("select voucher {string} giam tien and pay")
    public void selectVoucherGiamTienAndPay(String voucher) throws InterruptedException {
        BuyPackData.chonVoucherGiamTienVaThanhToan(voucher);
    }
    @And("select voucher {string} tang ky tu and pay")
    public void selectVoucherTangKyTuAndPay(String voucher) throws InterruptedException {
        BuyPackData.chonVoucherTangKyTuVaThanhToan(voucher);
    }
//#chuyen sang trang thanh toan
    @And("Switch to the payment history page")
    public void switchToThePaymentHistoryPage() throws InterruptedException {
        BuyPackData.checkChuyenTrangLichSuThanhToan();
    }
    @And("return to home page")
    public void returnToHomePage()  throws InterruptedException {
        Pages.BuyPackData.quayVeTrangChu();
    }
    @And("Check the added character after purchasing the package{string}")
    public void kiemTraKyTuCongVaoSauKhiMuaGoi(String kyTu) {
        BuyPackData.kiemtraKyTuCongThemSauKhiMuaGoiThangTieuChuan(kyTu);
    }
    @And("check han su dung {int}")
    public void checkHanSuDungTheoThang( int thang) {
        BuyPackData.kiemTraHanSuDung(thang);
    }
    @And("check ten goi cuoc sau khi mua {string}")
    public void checkTenGoiCuocSauKhiMua(String tenGoiKhiMua) throws InterruptedException {
        BuyPackData.checkTenGoiCuocSauKhiMua(tenGoiKhiMua);
    }
    // chuyen sang trang duyet don
    @Then("the system displays a successful purchase confirmation")
    public void theSystemDisplaysASuccessfulPurchaseConfirmation() throws InterruptedException {
        BuyPackData.duyetDonHang();
    }
}

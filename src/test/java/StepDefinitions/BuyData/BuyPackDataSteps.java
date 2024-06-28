package StepDefinitions.BuyData;
import Pages.BuyData.BuyPackData;
import driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;

public class BuyPackDataSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    static Duration timeout50 = Duration.ofSeconds(50);
    static WebDriverWait wait50 = new WebDriverWait(driver, timeout50);
    private Pages.BuyData.BuyPackData BuyPackData;
    public void captureScreenshot(String stepName) throws IOException {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(stepName, new ByteArrayInputStream(screenshot));
    }

//    #  người dùng đang truy cập trang mua gói cước
    @When("the user is accessing the package purchase page")
    public void theUserIsAccessingThePackagePurchasePage() throws IOException {
        BuyPackData = new BuyPackData(driver);
        BuyPackData.clickMuaGoiCuoc();
        captureScreenshot("trang mua goi cuoc");
    }
    @And("Get the initial number of characters the account has")
    public void getTheInitialNumberOfCharactersTheAccountHas() throws InterruptedException {
        BuyPackData = new BuyPackData(driver);
        BuyPackData.LaySoKyTuTaiKhoanDaCo();
    }
//#    chọn gói cước miễn phí
    @And("the user selects the free package")
    public void theUserSelectsTheFreePackage() throws IOException {
        BuyPackData.clickChonMuaGoiMienPhi();
        captureScreenshot("chon goi mien phi");
    }

//#  hệ thống hiển thị xác nhận mua thành công
    @And("selects month")
    public void selectsMonth() throws InterruptedException, IOException {
        BuyPackData.clickChonGoiThang();
        captureScreenshot("chon goi thang");
    }
    @And("selects quy")
    public void selectsQuy() throws IOException {
        BuyPackData.clickChonGoiQuy();
        captureScreenshot("chon goi quy");
    }
    @And("selects nam")
        public void selectsNam() throws IOException {
        BuyPackData.clickChonGoiNam();
        captureScreenshot("chon goi nam");
        }
//#  người dùng chọn gói cước tiêu chuẩn
    @And("the user selects the standard package")
    public void theUserSelectsTheStandardPackage() throws InterruptedException, IOException {
        BuyPackData.clickChonMuaGoiTieuChuan();
        Thread.sleep(500);
        captureScreenshot("chon mua goi tieu chuan");
    }
    //chon mua goi chuyen nghiep
    @And("the user selects the professional package")
    public void theUserSelectsTheProfessionalPackage() throws IOException {
        BuyPackData.clickChonMuaGoiChuyenNghiep();
        captureScreenshot("chon mua goi chuyen nghiep");
    }
    //chon mua goi dac biet
    @And("the user selects the special package")
    public void theUserSelectsTheSpecialPackage() throws IOException {
        BuyPackData.clickChonMuaGoiDacBiet();
        captureScreenshot("chon mua goi dac biet");
    }
//#  thực hiện thanh toán
    @And("ramdom bank")
    public void ramdomBank() throws InterruptedException, IOException {
        BuyPackData.ramdomNganHang();
        Thread.sleep(500);
        captureScreenshot("chon ngan hang");
    }
    @And("Check cancel order")
    public void checkCancelOrder() throws IOException {
        BuyPackData.huyDon();
        captureScreenshot("checkCancelOrder");
    }
    @And("selects bank momo")
    public void selectsBankMomo() {
        BuyPackData.selectsBankMomo();
    }
    @And("{string} select voucher {string} phan tram and pay")
    public void selectVoucherPhanTramAndPay(String giatrigoicuoc, String voucher) throws InterruptedException, IOException {
        BuyPackData.chonVoucherPhanTramVaThanhToan( giatrigoicuoc , voucher);
        captureScreenshot("chon voucher %");
    }
    @And("{string} select voucher {string} giam tien")
    public void selectVoucherGiamTien(String giatrigoicuoc, String voucher) throws InterruptedException {
        BuyPackData.ChonVoucherGiamTien(giatrigoicuoc,voucher);
    }
    @And("{string} select voucher {string} giam tien and pay")
    public void selectVoucherGiamTienAndPay(String giatrigoicuoc,String voucher) throws InterruptedException, IOException {
        BuyPackData.chonVoucherGiamTienVaThanhToan(giatrigoicuoc,voucher);
        captureScreenshot("chon voucher giam tien");
    }
    @And("{string} select voucher {string} tang ky tu and pay")
    public void selectVoucherTangKyTuAndPay(String giatrigoicuoc,String voucher) throws InterruptedException, IOException {
        BuyPackData.chonVoucherTangKyTuVaThanhToan(giatrigoicuoc ,voucher);
        captureScreenshot("chon voucher tang ky tu");
    }
//#chuyen sang trang thanh toan
    @And("Switch to the payment history page")
    public void switchToThePaymentHistoryPage() throws InterruptedException, IOException {
        BuyPackData.checkChuyenTrangLichSuThanhToan();
        captureScreenshot("trang cho thanh toan");
    }
    @And("return to home page")
    public void returnToHomePage() throws InterruptedException, IOException {
        Pages.BuyData.BuyPackData.quayVeTrangChu();
        captureScreenshot("mua xong goi quay ve trang chu");
    }
    @And("Check the added character after purchasing the package{string}")
    public void kiemTraKyTuCongVaoSauKhiMuaGoi(String kyTu) throws InterruptedException {
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
    @Then("Shows an invalid code error message")
    public void showsAnInvalidCodeErrorMessage() throws IOException {
        BuyPackData.showsInvalidCodeErrorMessage();
        captureScreenshot("Thông báo lỗi mã voucher không hợp lệ");
    }
    // chuyen sang trang duyet don
    @Then("the system displays a successful purchase confirmation")
    public void theSystemDisplaysASuccessfulPurchaseConfirmation() throws InterruptedException, IOException {
        BuyPackData.duyetDonHang();
        captureScreenshot("duyet don hang vua mua");
    }
    @After
    public void TearDown(Scenario scenario) {
        if (
                scenario.isFailed()
        ) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
        }

    }

}

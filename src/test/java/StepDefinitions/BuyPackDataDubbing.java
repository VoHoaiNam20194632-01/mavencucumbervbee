package StepDefinitions;

import Pages.BuyData.BuyPackData;
import Pages.Login.LoginPage;
import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyPackDataDubbing {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    static Duration timeout50 = Duration.ofSeconds(50);
    static WebDriverWait wait50 = new WebDriverWait(driver, timeout50);
    private BuyPackData dubbing;

    private LoginPage loginPage;
    @When("click buy pack of data dubbing button")
    public void clickBuyPackOfDataDubbingButton() {
        dubbing = new BuyPackData(driver);
//        dubbing.clickMuaGoiCuocbtn();

    }
    @And("kiem tra xem du bon goi cuoc không")
    public void kiemTraXemDuBonGoiCuocKhông() {
        dubbing.kiemtradubongoicuoc();
    }
//    @And("chon ngan hang")
//    public void chonNganHang() {
//    dubbing.clickchonnganhang();
//    }

    @And("click Dong y thanh toan")
    public void clickDongYThanhToan() {
        dubbing.clickDongythanhtoan();
    }
    @And("Toi da chuyen khoan")
    public void toiDaChuyenKhoan() {
    dubbing.clickToidachuyenkhoan();
    }

//    @And("chuyen sang trang lich su thanh toan")
//    public void chuyenSangTrangLichSuThanhToan() throws InterruptedException {
//    dubbing.kiemtramuathanhcongchua();
//    }
    @And("chon goi mien phi")
//    public void chonGoiMienPhi() {
//    dubbing.clickchongoimienphi();
//    }
    @Then("khong hien thi banner ngang cap")
    public void khongHienThiBannerNgangCap() {
        dubbing = new BuyPackData(driver);
        dubbing.checkbannernangcapkhongxuathien();
    }
    @And("Select package tieu chuan dubbing")
    public void selectPackageTieuChuanDubbing() {
        dubbing.clickgoitieuchuan();
    }


    @And("Select package chuyen nghiep dubbing")
    public void selectPackageChuyenNghiepDubbing() {
        dubbing.clickgoichuyennghiep();
    }

    @And("Select package dac biet dubbing")
    public void selectPackageDacBietDubbing() {
        dubbing.clickgoidacbiet();
    }

    @Then("hien thi banner nang cap")
    public void hienThiBannerNangCap() throws InterruptedException {
        dubbing = new BuyPackData(driver);
        dubbing.checkbannernangcapxuathien();
        driver.navigate().refresh();
        loginPage = new LoginPage(driver);
        loginPage.clickNoButton();

    }
}

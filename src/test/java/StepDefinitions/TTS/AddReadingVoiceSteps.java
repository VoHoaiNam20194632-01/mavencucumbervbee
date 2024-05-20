package StepDefinitions.TTS;

import Pages.TTS.textTransfer;
import driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddReadingVoiceSteps {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }

    private textTransfer TextTransfer;
    public void setUp(){
        TextTransfer = new textTransfer(driver);
    }
    @And("Nhap tieu de {string}")
    public void nhapTieuDe(String tieude) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh'h' : mm");

        // Định dạng cho phần tử LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Lấy giá trị LocalTime và LocalDateTime hiện tại
        LocalDateTime now = LocalDateTime.now();

        // Định dạng lại giá trị LocalTime và LocalDateTime thành chuỗi
        String timeFormatted = now.format(timeFormatter);
        String dateTimeFormatted = now.format(dateTimeFormatter);

        // Kết hợp các phần tử đã định dạng lại thành chuỗi "1 12h ngày 20/5/2024"
        String NhapNoiDungTieuDe = tieude +timeFormatted  + " ngày " + dateTimeFormatted;
        setUp();
        TextTransfer.ChonTieuDe(NhapNoiDungTieuDe);
    }
    @And("Nhap van ban can chuyen doi dung thiet ke")
    public void nhapVanBanCanChuyenDoiDungThietKe() {
        TextTransfer.nhapVanBanDungYeuCau();
    }
    @And("Nhap link {string} can chuyen doi")
    public void nhapLinkCanChuyenDoi(String link) throws InterruptedException {
        TextTransfer.addLinkVanBan(link);
    }

    @And("Nhap file {string}can chuyen doi")
    public void nhapFileCanChuyenDoi(String file) throws InterruptedException, AWTException, IOException {
        TextTransfer.addFile(file);
    }
    @And("Click button chuyen van ban")
    public void clickButtonChuyenVanBan() {
            textTransfer.clickBtnChuyenVanBan();
    }
    @And("Check ky tu tai khoan sau khi chuyen doi van ban")
    public void checkKyTuTaiKhoanSauKhiChuyenDoiVanBan() {
        textTransfer.checkKyTuSauTTS();
    }

    @Then("Tai xuong audio voi vua chuyen van ban thanh cong")
    public void taiXuongAudioVoiVuaChuyenVanBanThanhCong() {
        textTransfer.clickBtnTaiXuong();
    }

    @And("Chọn giong doc tieu chuan {string}")
    public void chọnGiongDocTieuChuan(String user) throws IOException {
        textTransfer.selectVoiceType("STANDARD");
        textTransfer.selectVoiceUser(user);
    }
    @And("Chọn giong doc nuoc ngoai {string}")
    public void chọnGiongDocNuocNgoai(String user) throws IOException, InterruptedException {
        textTransfer.selectTypeVoiceNuocNgoai("en-AU");
        textTransfer.selectVoiceUser(user);
    }
    @And("toc do doc {string}, dinh dang audio{string}, nhac nen {string}")
    public void tocDoDocDinhDangAudioNhacNen(String tocdo, String dingdang, String nhacnen) throws IOException, InterruptedException {
        System.out.println("bat  dau nhap toc do");
        textTransfer.nhapTocDoVanBan(tocdo);
        System.out.println("bat  dau nhap dinh dang");
        textTransfer.DingDang(dingdang);
        System.out.println("bat  dau nhap nhac nen");
        textTransfer.NhacNen(nhacnen);
    }

    @And("chon giong doc")
    public void chonGiongDoc() throws IOException {
        textTransfer.ReadingButton();
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

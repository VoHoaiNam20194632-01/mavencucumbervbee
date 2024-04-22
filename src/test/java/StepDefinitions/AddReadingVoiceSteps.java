package StepDefinitions;

import Pages.textTransfer.textTransfer;
import driver.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
        String NhapNoiDungTieuDe = tieude + LocalTime.now() + LocalDateTime.now();
        System.out.println(TextTransfer);
        setUp();
        TextTransfer.ChonTieuDe(NhapNoiDungTieuDe);
    }
    @And("Nhap van ban can chuyen doi dung thiet ke")
    public void nhapVanBanCanChuyenDoiDungThietKe() {
        TextTransfer.nhapVanBanDungYeuCau();
    }


    @And("Click button chuyen van ban")
    public void clickButtonChuyenVanBan() {

    }

    @Then("Tai xuong audio voi {string} vua chuyen van ban thanh cong")
    public void taiXuongAudioVoiVuaChuyenVanBanThanhCong(String tieude) {
    }

    @And("Chọn giong doc tieu chuan {string},")
    public void chọnGiongDocTieuChuan(String user) throws IOException {
        textTransfer.selectVoiceType("STANDARD");
        textTransfer.selectVoiceUser(user);
    }

    @And("toc do doc {string}, dinh dang audio{string}, nhac nen {string}")
    public void tocDoDocDinhDangAudioNhacNen(String tocdo, String dingdang, String nhacnen) {
        textTransfer.nhapTocDoVanBan(tocdo);
        textTransfer.DingDang(dingdang);
        textTransfer.NhacNen(nhacnen);
    }

    @And("chon giong doc")
    public void chonGiongDoc() throws IOException {
        textTransfer.ReadingButton();
    }
}

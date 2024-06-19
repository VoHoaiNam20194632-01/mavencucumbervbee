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
import org.testng.annotations.BeforeMethod;

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
@BeforeMethod
    public void setUp(){
        TextTransfer = new textTransfer(driver);
    }

    @And("Enter a title {string}")
    public void enterATitle(String title) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh'h' : mm");

        // Định dạng cho phần tử LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Lấy giá trị LocalTime và LocalDateTime hiện tại
        LocalDateTime now = LocalDateTime.now();

        // Định dạng lại giá trị LocalTime và LocalDateTime thành chuỗi
        String timeFormatted = now.format(timeFormatter);
        String dateTimeFormatted = now.format(dateTimeFormatter);

        // Kết hợp các phần tử đã định dạng lại thành chuỗi "1 12h ngày 20/5/2024"
        String NhapNoiDungTieuDe = title +timeFormatted  + " ngày " + dateTimeFormatted;
        setUp();
        TextTransfer.ChonTieuDe(NhapNoiDungTieuDe);
    }
    @And("Enter the text to convert")
    public void enterTheTextToConvert() {
        TextTransfer.nhapVanBanDungYeuCau();
    }
    @And("Choose your reading voice")
    public void chooseYourReadingVoice() throws IOException {
        textTransfer.ReadingButton();
    }
    @And("Enter the link {string} to convert")
    public void enterTheLinkToConvert(String link) throws InterruptedException {
        TextTransfer.addLinkVanBan(link);
    }

    @And("Enter the file {string} to convert")
    public void enterTheFileToConvert(String file) throws IOException, InterruptedException, AWTException {
        TextTransfer.addFile(file);
    }
    @And("Click button text transfer")
    public void clickButtonTextTransfer() {textTransfer.clickBtnChuyenVanBan();
    }
    @And("Check the number of remaining characters")
    public void checkTheNumberOfRemainingCharacters() {
        textTransfer.checkKyTuSauTTS();
    }

    @Then("Download audio to your computer")
    public void downloadAudioToYourComputer() {
        textTransfer.clickBtnTaiXuong();
    }

    @And("Choose a standard reading voice {string}")
    public void chooseAStandardReadingVoice(String user) throws IOException {
        textTransfer.selectVoiceType("STANDARD");
        textTransfer.selectVoiceUser(user);
    }
    @And("Choose a foreign accent {string}")
    public void chooseAForeignAccent(String user ) throws InterruptedException, IOException {
        textTransfer.selectTypeVoiceNuocNgoai("en-AU");
        textTransfer.selectVoiceUser(user);
    }
    @And("reading speed {string}, Format audio{string}, soundtrack {string}")
    public void readingSpeedFormatAudioSoundtrack(String tocdo, String dinhdang, String nhacnen) throws IOException, InterruptedException {
        System.out.println("bat  dau nhap toc do");
        textTransfer.nhapTocDoVanBan(tocdo);
        System.out.println("bat  dau nhap dinh dang");
        textTransfer.DingDang(dinhdang);
        System.out.println("bat  dau nhap nhac nen");
        textTransfer.NhacNen(nhacnen);
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

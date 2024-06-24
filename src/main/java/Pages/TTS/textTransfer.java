package Pages.TTS;

import driver.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class textTransfer {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    public void captureScreenshot(String stepName) throws IOException {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(stepName, new ByteArrayInputStream(screenshot));
    }

    static int soKyTuBanDau = 0;
    public static int laySoKyTuTrenTrangWeb(){
        WebElement soKyTuDaCo = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[4]/div/div/p[1]")));
        String numberText = soKyTuDaCo.getText();
        String[] parts = numberText.split("\\s+"); // Tách chuỗi bằng khoảng trắng
        String numberPart = parts[0]; // Phần số sẽ là phần tử đầu tiên trong mảng
        numberPart = numberPart.replaceAll("\\D", ""); // Loại bỏ tất cả các ký tự không phải số
        //        String numberText = numberTextCoDauCham.replace(".","");
        return Integer.parseInt(numberPart);
    }
    public void LaySoKyTuTaiKhoanDaCo(){
        WebElement goiHienTaiDangDung = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[5]/div[2]/p[2]")));
        String goiHienTai = goiHienTaiDangDung.getText();
            soKyTuBanDau = laySoKyTuTrenTrangWeb();
    }
    static Duration timeout50 = Duration.ofSeconds(50);
    static WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    static Duration timeout200 = Duration.ofSeconds(200);
    static WebDriverWait wait200 = new WebDriverWait(driver,timeout200);
    static By chonbtngiongdocLocator = By.id("voice");
    By ChonTieuDeLocator = By.className("size-input");
    private static boolean firstExampleExecuted = false;
    private static void uncheckAllCheckboxes(WebDriver driver, String checkboxcssSelector) {
        java.util.List<WebElement> checkboxes = driver.findElements(By.cssSelector(checkboxcssSelector));
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
    public static void uncheckAllCheckboxesGender(){
        String selectorGenderMale = "input[type='checkbox'][value='male']";
        String selectorGenderFemale = "input[type='checkbox'][value='female']";
        List<String> checkboxscssSelector = List.of(
                selectorGenderFemale,
                selectorGenderMale
        );
        for (String checkboxcssSelector : checkboxscssSelector) {
            uncheckAllCheckboxes(driver, checkboxcssSelector);
        }

    }
    public static void uncheckAllCheckboxesType(){
        String selectorTypeBasic = "input[type='checkbox'][value='STANDARD']";
        String selectorTypePro = "input[type='checkbox'][value='PREMIUM']";
        List<String> checkboxscssSelector = List.of(
                selectorTypeBasic,
                selectorTypePro
        );
        for (String checkboxcssSelector : checkboxscssSelector) {
            uncheckAllCheckboxes(driver, checkboxcssSelector);
        }
    }
    public textTransfer(WebDriver driver){
        this.driver = driver;
    }

    public void ChonTieuDe( String tieude ){
        WebElement TieuDebtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(ChonTieuDeLocator));
        TieuDebtn.click();
        TieuDebtn.sendKeys(tieude);
    }


    static int soKyTu = 0;
    public static int LaySoKyTuVanBan(){
        WebElement soKyTuVanBan = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"request-editor\"]/div/div[1]/div[2]/p[1]/span[1]")));
        String numberText1 = soKyTuVanBan.getText();
        String[] parts1 = numberText1.split("\\s+"); // Tách chuỗi bằng khoảng trắng
        String numberPart1 = parts1[0]; // Phần số sẽ là phần tử đầu tiên trong mảng
        numberPart1 = numberPart1.replaceAll("\\D", ""); // Loại bỏ tất cả các ký tự không phải số
        return Integer.parseInt(numberPart1);
    }

    public void nhapVanBanDungYeuCau(){
        String NoiDung = "Chiều 11.4, sau hơn 1 tháng xét xử sơ thẩm và nghị án, TAND TP.HCM tuyên án đối với bị cáo Trương Mỹ Lan (68 tuổi, Chủ tịch HĐQT Tập đoàn Vạn Thịnh Phát) và 85 bị cáo.\n" +
                "Đề nghị làm rõ dòng tiền 108.878 tỉ đồng và hơn 14,7 triệu USD\n" +
                "Theo đó, HĐXX tuyên phạt bị cáo Trương Mỹ Lan án tử hình về tội \"tham ô tài sản\", 20 năm tù về tội \"đưa hối lộ\" và 20 năm tù về tội \"vi phạm quy định về cho vay trong hoạt động của các tổ chức tín dụng\". Tổng hợp hình phạt là tử hình đối với bị cáo Lan.";
        System.out.println(soKyTuBanDau
        );
        LaySoKyTuTaiKhoanDaCo();
        System.out.println(soKyTuBanDau);
        WebElement nhapVanBan = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"enter-text-here\"]/div[1]/div/div[2]/div")));
        nhapVanBan.click();
        nhapVanBan.sendKeys(NoiDung);
    }

    public void addLinkVanBan(String link) throws InterruptedException {
        WebElement taiLen = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Tải tệp lên hoặc nhập web link']")));
        taiLen.click();
        WebElement taiLinkWeb = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/li[1]")));
        taiLinkWeb.click();
        WebElement dienLink = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/div/div[1]/div/div[1]/div/input")));
        dienLink.sendKeys(link);
        Thread.sleep(3000);
        WebElement tiepTuc = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/div/div[2]/button")));
        tiepTuc.click();
        LaySoKyTuTaiKhoanDaCo();
        System.out.println("So ky tu ban dau" +soKyTuBanDau);
    }
    public void addFile(String file) throws AWTException, InterruptedException, IOException {
        WebElement taiLen = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Tải tệp lên hoặc nhập web link']")));
        taiLen.click();
        WebElement taiFileTxt = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/li[3]")));
        taiFileTxt.click();
//        WebElement chonFile = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Chọn file']")));
//        chonFile.click();
        String filePath = "C:\\Users\\VO HOAI NAM\\Documents\\DataTestVbee\\Text\\" + file+".txt";
        WebElement taifile = driver.findElement(By.xpath("//input[@type='file']"));
        taifile.sendKeys(filePath);
        WebElement tiepTuc = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/div/div[2]/button")));
        tiepTuc.click();
        LaySoKyTuTaiKhoanDaCo();
        System.out.println("So ky tu ban dau" +soKyTuBanDau);
    }
    public static void nhapTocDoVanBan(String tocdo){
        WebElement tocDoBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"request-editor\"]/div/div[3]/div/div[1]/div[1]/div")));
        System.out.println("da click toc do");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerText = arguments[1];", tocDoBtn, tocdo);
        System.out.println("da nhap dc toc to");
    }
    public static void DingDang(String dinhdang){
        WebElement dinhDangBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"request-editor\"]/div/div[3]/div/div[1]/div[2]/div[2]/button")));
        dinhDangBtn.click();
        WebElement chonDinhDang = driver.findElement(By.xpath("//li[p/span[text()='"+dinhdang+"']]"));
        chonDinhDang.click();
    }
    public static void NhacNen(String nhacnen) throws IOException, InterruptedException {
        String File = "C:\\Users\\VO HOAI NAM\\Documents\\DataTestVbee\\music\\" + nhacnen;
        WebElement nhacNenBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"request-editor\"]/div/div[3]/div/div[1]/div[4]/button")));
        nhacNenBtn.click();
        Thread.sleep(2000);
       WebElement tainhacBtn = driver.findElement(By.id("upload-music-file"));
       tainhacBtn.sendKeys(File);
       WebElement Upload = driver.findElement(By.xpath("//button[contains(text(),'upload')]"));
       Upload.click();
        WebElement BtnApDung = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Áp dụng')]")));
        BtnApDung.click();
        Thread.sleep(7000);
    }
    public static void BannerUpgrade(){
        WebElement bannerNangCap = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Nâng cấp ngay']")));
        if (bannerNangCap.isDisplayed()) {
            System.out.println("Banner 'Nâng cấp ngay' đã xuất hiện.");
        } else {
            throw new AssertionError("Banner không hiển thị ");
        }
    }
    public  static void clickBtnChuyenVanBan(){
        WebElement BtnChuyenVanBan = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.id("convert-tts")));
        BtnChuyenVanBan.click();
    }
   static int soKyTuSauKhiTTS = 0;
   public static void checkKyTuSauTTS(){
       soKyTu= LaySoKyTuVanBan();
        System.out.println("so ky tu van ban" + soKyTu);
        WebElement TaixuongButton = wait200.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"request-editor\"]/div/div[1]/div[2]/div[2]/div[1]")));
        System.out.println(TaixuongButton.getText());
        if (TaixuongButton.getText().equalsIgnoreCase("Tải Xuống")){
            soKyTuSauKhiTTS = laySoKyTuTrenTrangWeb();
        }


       System.out.println(soKyTuSauKhiTTS);
       if(soKyTuBanDau - soKyTu == soKyTuSauKhiTTS){
           System.out.println("đã trừ đúng số ký tự");
           System.out.println(soKyTuSauKhiTTS);
       }else {
           throw new AssertionError("so ky tu tru chua dung");
       }

   }
    public  static void clickBtnTaiXuong(){
        WebElement TaiXuongLocator = wait200.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"request-editor\"]/div/div[1]/div[2]/div[2]/div[1]")));
        TaiXuongLocator.click();
    }
    public static void ReadingButton() throws IOException {
        WebElement giongdocbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonbtngiongdocLocator));
        giongdocbtn.click();
    }
    public void selectGender(String gender ) throws InterruptedException, IOException {
        uncheckAllCheckboxesGender();
        String selectorGender = "input[type='checkbox'][value='" + gender.toLowerCase()+"']";
        By genderLocator = By.cssSelector(selectorGender);
        WebElement genderButton = driver.findElement(genderLocator);
        Thread.sleep(1000);
        genderButton.click();
    }
    public static void selectVoiceType(String type){
        uncheckAllCheckboxesType();
        By loaigiongtieuchuanLocator = By.cssSelector("input[type='checkbox'][value='" + type +"']");
        WebElement loaigiong = driver.findElement(loaigiongtieuchuanLocator);
        loaigiong.click();
    }
    public  static void selectTypeVoiceNuocNgoai(String type) throws InterruptedException {
        uncheckAllCheckboxesType();
        Thread.sleep(2000);
        By loaigiongtieuchuanLocator = By.cssSelector("input[type='checkbox'][value='" + type +"']");
        WebElement loaigiong = driver.findElement(loaigiongtieuchuanLocator);
        loaigiong.click();
    }
    public static void selectVoiceUser(String User) throws IOException {
        By chonguoiLocator = By.xpath("//button[@aria-label='"+ User +"']");
        WebElement chonnguoi = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonguoiLocator));
        chonnguoi.click();
    }
}

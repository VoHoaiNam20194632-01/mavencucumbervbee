package Pages.textTransfer;

import driver.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
public class textTransfer {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    By soKytuHienjCoLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[4]/div/div/p[1]");
    int soKyTuBanDau = 0;
    public int laySoKyTuTrenTrangWeb(){
        WebElement soKyTuDaCo = wait50.until(ExpectedConditions.visibilityOfElementLocated(soKytuHienjCoLocator));
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
    static By chonbtngiongdocLocator = By.id("voice");
    By ChonTieuDeLocator = By.className("size-input");
    private static boolean firstExampleExecuted = false;
    public void captureScreen(String name) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("image\\textTransfer\\" + name));
    }

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


    int soKyTu = 0;
    public void nhapVanBanDungYeuCau(){
        String test3000 = "Chiều 11.4, sau hơn 1 tháng xét xử sơ thẩm và nghị án, TAND TP.HCM tuyên án đối với bị cáo Trương Mỹ Lan (68 tuổi, Chủ tịch HĐQT Tập đoàn Vạn Thịnh Phát) và 85 bị cáo.\n" +
                "Đề nghị làm rõ dòng tiền 108.878 tỉ đồng và hơn 14,7 triệu USD\n" +
                "Theo đó, HĐXX tuyên phạt bị cáo Trương Mỹ Lan án tử hình về tội \"tham ô tài sản\", 20 năm tù về tội \"đưa hối lộ\" và 20 năm tù về tội \"vi phạm quy định về cho vay trong hoạt động của các tổ chức tín dụng\". Tổng hợp hình phạt là tử hình đối với bị cáo Lan.";
        LaySoKyTuTaiKhoanDaCo();
        System.out.println(soKyTuBanDau
        );
        var nhapVanBan = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"enter-text-here\"]/div[1]/div/div[2]/div")));
        nhapVanBan.click();
        nhapVanBan.sendKeys(test3000);
        WebElement soKyTuVanBan = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"request-editor\"]/div/div[1]/div[2]/p[1]/span[1]")));
        soKyTu = Integer.parseInt(soKyTuVanBan.getText());
        System.out.println(soKyTu);

    }
    public static void nhapTocDoVanBan(String tocdo){
        WebElement tocDoBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"request-editor\"]/div/div[3]/div/div[1]/div[1]/div")));
        tocDoBtn.sendKeys(tocdo);
        tocDoBtn.sendKeys(Keys.ENTER);
    }
    public static void DingDang(String dinhdang){
        WebElement dinhDangBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"request-editor\"]/div/div[3]/div/div[1]/div[2]/div[2]/button")));
        dinhDangBtn.click();
        WebElement chonDinhDang = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[p/span[text()=' "+dinhdang +" ']]")));
        chonDinhDang.click();
    }
    public static void NhacNen(String nhacnen){
        WebElement nhacNenBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Tùy chọn nhạc nền']")));
        nhacNenBtn.click();
        WebElement chonNhacNen = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[p[contains(text(),'"+ nhacnen +"')]]")));
        chonNhacNen.click();

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
        captureScreen("OptionReading.png");
        genderButton.click();
    }
    public static void selectVoiceType(String type){
        uncheckAllCheckboxesType();
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

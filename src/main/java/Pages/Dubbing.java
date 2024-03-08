package Pages;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Dubbing {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }

    static Duration timeout50 = Duration.ofSeconds(50);

    static WebDriverWait wait50 = new WebDriverWait(driver, timeout50);

    static Duration timeout10 = Duration.ofSeconds(10);
    static  WebDriverWait wait10 = new WebDriverWait(driver, timeout10);

    By taifileLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div/div");
    By chuyenphudeLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[2]/div[1]/button");

    By muagoicuocLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[2]/ul/li[2]");
    By chonNguoiLocator = By.id("buttonMenu");

    By goicuoctieuchuanLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[2]/div[2]/div/div[4]/button");
    By goicuocchuyennghiepLocator = By.xpath("//button[contains(text(), 'Mua ngay')]");
    By goidacbietLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[4]/div[2]/div/div[4]/button");
    By nganhangLocator = By.xpath("//div[div/p[text()='Techcombank']]");
    By dongythanhtoan = By.xpath("//button[contains(text(), 'Đồng ý thanh toán')]");
    By dachuyenkhoanbtn = By.xpath("//button[contains(text(), 'Tôi đã chuyển khoản')]");
    By mienphibtnLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[1]/div[2]/div/div[4]/button");

    By thoiluongLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[4]/div/div/p[1]");
    By thoiluongsrtLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div/div/div/div/div/h5[2]");

    public  Dubbing(WebDriver driver){
       this.driver = driver;
}
public void layketquathoiluongconlai(){
        WebElement thoiluongtaikhoan = wait50.until(ExpectedConditions.visibilityOfElementLocated(thoiluongLocator));
        String thoiluong = thoiluongtaikhoan.getText();
        System.out.println(thoiluong);
    int lastSpaceIndex = thoiluong.lastIndexOf(' ');

    // Tách phần con chuỗi chứa giờ, phút và giây
    String timeSubstring = thoiluong.substring(lastSpaceIndex + 1);

    // Tách giờ, phút, giây
    String[] timeComponents = timeSubstring.split(":");

    // Chuyển đổi thành số nguyên
    int hours = Integer.parseInt(timeComponents[0]);
    int minutes = Integer.parseInt(timeComponents[1]);
    int seconds = Integer.parseInt(timeComponents[2]);

    // In ra các thành phần thời gian
    System.out.println("Giờ: " + hours);
    System.out.println("Phút: " + minutes);
    System.out.println("Giây: " + seconds);
    int tongthoiluong = hours*3600 + minutes *60 + seconds;
}
public void laythoiluongsrt(){
        WebElement thoiluongsrt = wait50.until(ExpectedConditions.visibilityOfElementLocated(thoiluongsrtLocator));

    String durationText = thoiluongsrt.getText();
    String[] timeComponents = durationText.split(":");

    // Chuyển đổi thành số nguyên
    int hours = Integer.parseInt(timeComponents[0]);
    int minutes = Integer.parseInt(timeComponents[1]);
    int seconds = Integer.parseInt(timeComponents[2]);

    // In ra các thành phần thời gian
    System.out.println("Giờ: " + hours);
    System.out.println("Phút: " + minutes);
    System.out.println("Giây: " + seconds);

}

    public boolean  isPackageVisible( String packageName){
        By packageLocator =By.xpath("//div[@class='package-header']//div//p[text()='"+packageName+"']");
        System.out.println(packageLocator);
        WebElement packageElement = wait50.until(ExpectedConditions.visibilityOfElementLocated(packageLocator));
        return !packageElement.isDisplayed();
    }
    public void  AddFileSubTitle(String files) throws InterruptedException, AWTException {

        WebElement taifilebtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(taifileLocator));
        taifilebtn.click();

        String filePath = "C:\\Users\\VO HOAI NAM\\Documents\\DataTestVbee\\dubbing\\" + files;
        // Gửi đường dẫn file đến clipboard
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // Sử dụng Robot Class để tương tác với cửa sổ hộp thoại tải file
        Robot robot = new Robot();
        Thread.sleep(3000);

        // Paste đường dẫn từ clipboard
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        // Nhấn Enter để xác nhận tải file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        // Chờ một khoảng thời gian để file tải lên
        Thread.sleep(5000);

    }
    public void clickChonNguoi(String users){
        WebElement chonnguoibtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonNguoiLocator));
        chonnguoibtn.click();
        By chonmotnguoiLocator = By.xpath("//li[p[contains(text(), '"+ users +"')]]");
        WebElement manhdungbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonmotnguoiLocator));
        manhdungbtn.click();

    }
    public void clickChuyenPhuDe(){
        WebElement chuyenphudebtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chuyenphudeLocator));
        chuyenphudebtn.click();
    }
    public void clickMuaGoiCuocbtn(){
            WebElement muagoicuocbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(muagoicuocLocator));
            muagoicuocbtn.click();
    }
    public void kiemtradubongoicuoc(){
        System.out.println("bat dau kiem tra");
        System.out.println("bat dau 1");
        if ((isPackageVisible("Miễn phí"))) throw new AssertionError("khong có co ban");
        if ((isPackageVisible("Tiêu chuẩn"))) throw new AssertionError("khong có tieu chuan");
        if ((isPackageVisible("Chuyên nghiệp"))) throw new AssertionError("khong có chuyen nghiep");
        if ((isPackageVisible("Đặc biệt"))) throw new AssertionError("khong có dac biet");

    }



//    public void clickChonGoiCuoc(){
//        WebElement tieuchuanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chongoicuocLocator));
//        tieuchuanbtn.click();
//    }
    public void clickchonnganhang(){
        WebElement tech = wait50.until(ExpectedConditions.visibilityOfElementLocated(nganhangLocator));
        tech.click();

    }
    public void clickDongythanhtoan(){
        WebElement dongythanhtoanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(dongythanhtoan));
        dongythanhtoanbtn.click();
    }
    public  void clickToidachuyenkhoan(){
        WebElement toidachuyenkhoanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(dachuyenkhoanbtn));
        toidachuyenkhoanbtn.click();
    }
    public void kiemtramuathanhcongchua() throws InterruptedException {

// So sánh với URL mong đợi
        String expectedUrl = "https://dev-studio.vbee.vn/dubbing/payments-history";

        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        boolean checkUrl = expectedUrl != currentUrl;
        System.out.println(checkUrl);
        if((!checkUrl)) throw  new AssertionError("looi");
    }
    public void clickchongoimienphi(){
        WebElement mienphibtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(mienphibtnLocator));
        mienphibtn.click();
    }
    public void checkbannernangcapxuathien() {
        By snackbarLocator = By.xpath("//button[text()='Nâng cấp ngay']");
        try {
            // Chờ cho thông báo xuất hiện, nhưng không ném ngoại lệ nếu nó không xuất hiện
            wait50.until(ExpectedConditions.presenceOfElementLocated(snackbarLocator));
            // Nếu không có ngoại lệ, tức là snackbar đã xuất hiện, và bạn có thể đánh fail tại đây
            System.out.println("Snackbar không xuất hiện, đánh pass.");
        } catch (TimeoutException e) {
            // Nếu có ngoại lệ, tức là snackbar không xuất hiện, và bạn có thể đánh pass tại đây
            throw new AssertionError("Snackbar xuất hiện, failse");
        }
    }
    public void checkbannernangcapkhongxuathien(){
        By snackbarLocator = By.xpath("//button[text()='Nâng cấp ngay']");
        try {
            // Chờ cho thông báo xuất hiện, nhưng không ném ngoại lệ nếu nó không xuất hiện
            wait50.until(ExpectedConditions.presenceOfElementLocated(snackbarLocator));
            // Nếu không có ngoại lệ, tức là snackbar đã xuất hiện, và bạn có thể đánh fail tại đây
            throw new AssertionError("Snackbar xuất hiện, failse");

        } catch (TimeoutException e) {
            // Nếu có ngoại lệ, tức là snackbar không xuất hiện, và bạn có thể đánh pass tại đây
            System.out.println("Snackbar không xuất hiện, đánh pass.");
        }
    }

    public void clickgoitieuchuan(){
        WebElement chongoitieuchuan = wait50.until(ExpectedConditions.visibilityOfElementLocated(goicuoctieuchuanLocator));
        chongoitieuchuan.click();
    }
    public void clickgoichuyennghiep(){
        WebElement chongoichuyennghiep = wait50.until(ExpectedConditions.visibilityOfElementLocated(goicuocchuyennghiepLocator));
        chongoichuyennghiep.click();
    }
    public void clickgoidacbiet(){
        WebElement chongoidacbiet = wait50.until(ExpectedConditions.visibilityOfElementLocated(goidacbietLocator));
        chongoidacbiet.click();
    }
}

package Pages.BuyData;
import driver.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
public class BuyPackData {
    private static WebDriver driver;
    static {
        driver = WebDriverManager.getDriver();
    }
    static Duration timeout50 = Duration.ofSeconds(50);
    static WebDriverWait wait50 = new WebDriverWait(driver, timeout50);
    static Duration timeout10 = Duration.ofSeconds(10);
    static  WebDriverWait wait10 = new WebDriverWait(driver, timeout10);
    By muaGoiCuocLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[2]/ul/li[4]");
    By chonGoiMienPhiLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[1]/div[2]/div/div[4]/button");
    By chonGoiTieuChuanLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[2]/div[2]/div/div[4]/button");
    By chonGoiChuyenNghiepLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[3]/div[2]/div/div[4]/button");
    By chonGoiDacBietLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[4]/div[2]/div/div[4]/button");
    By chonGoiThangLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[1]");
    By chonGoiQuyLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[2]");
    By chonGoiNamLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[3]");
    By soKytuHienjCoLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[4]/div/div/p[1]");
    By taifileLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div/div");
    By chuyenphudeLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[2]/div[1]/button");
    By chonNguoiLocator = By.id("buttonMenu");
    By goicuoctieuchuanLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[2]/div[2]/div/div[4]/button");
    By goicuocchuyennghiepLocator = By.xpath("//button[contains(text(), 'Mua ngay')]");
    By goidacbietLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[4]/div[2]/div/div[4]/button");
    By TechcombankLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/div");
    By VietcombankLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div");
    By MomoLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div");
    By  VNPAYLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[4]/div");
    By addVoucherLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div");
    By nhapMaKhuyenMai = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/div/input");
    By voucherLocator = By.xpath("//div[contains(div/p/text(),'Giảm 55%')]");
    By dongythanhtoan = By.xpath("//button[contains(text(), 'Đồng ý thanh toán')]");
    By dachuyenkhoanbtn = By.xpath("//button[contains(text(), 'Tôi đã chuyển khoản')]");
    By mienphibtnLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/span/div/div[1]/div[2]/div/div[4]/button");
    By thoiluongLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[4]/div/div/p[1]");
    By thoiluongsrtLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div/div/div/div/div/h5[2]");
    public BuyPackData(WebDriver driver){
       this.driver = driver;
}
public int laySoKyTuTrenTrangWeb(){
        WebElement soKyTuDaCo = wait50.until(ExpectedConditions.visibilityOfElementLocated(soKytuHienjCoLocator));
        String numberText = soKyTuDaCo.getText();
        String[] parts = numberText.split("\\s+"); // Tách chuỗi bằng khoảng trắng
       String numberPart = parts[0]; // Phần số sẽ là phần tử đầu tiên trong mảng
       numberPart = numberPart.replaceAll("\\D", ""); // Loại bỏ tất cả các ký tự không phải số
    //        String numberText = numberTextCoDauCham.replace(".","");
    return Integer.parseInt(numberPart);
}
//public void layketquathoiluongconlai(){
//        WebElement thoiluongtaikhoan = wait50.until(ExpectedConditions.visibilityOfElementLocated(thoiluongLocator));
//        String thoiluong = thoiluongtaikhoan.getText();
//        System.out.println(thoiluong);
//    int lastSpaceIndex = thoiluong.lastIndexOf(' ');
//
//    // Tách phần con chuỗi chứa giờ, phút và giây
//    String timeSubstring = thoiluong.substring(lastSpaceIndex + 1);
//
//    // Tách giờ, phút, giây
//    String[] timeComponents = timeSubstring.split(":");
//
//    // Chuyển đổi thành số nguyên
//    int hours = Integer.parseInt(timeComponents[0]);
//    int minutes = Integer.parseInt(timeComponents[1]);
//    int seconds = Integer.parseInt(timeComponents[2]);
//
//    // In ra các thành phần thời gian
//    System.out.println("Giờ: " + hours);
//    System.out.println("Phút: " + minutes);
//    System.out.println("Giây: " + seconds);
//    int tongthoiluong = hours*3600 + minutes *60 + seconds;
//}
//public void laythoiluongsrt(){
//        WebElement thoiluongsrt = wait50.until(ExpectedConditions.visibilityOfElementLocated(thoiluongsrtLocator));
//
//    String durationText = thoiluongsrt.getText();
//    String[] timeComponents = durationText.split(":");
//
//    // Chuyển đổi thành số nguyên
//    int hours = Integer.parseInt(timeComponents[0]);
//    int minutes = Integer.parseInt(timeComponents[1]);
//    int seconds = Integer.parseInt(timeComponents[2]);
//
//    // In ra các thành phần thời gian
//    System.out.println("Giờ: " + hours);
//    System.out.println("Phút: " + minutes);
//    System.out.println("Giây: " + seconds);
//
//}
int soKyTuBanDau = 0;
    public void LaySoKyTuTaiKhoanDaCo(){
        WebElement goiHienTaiDangDung = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[5]/div[2]/p[2]")));
        String goiHienTai = goiHienTaiDangDung.getText();
        String goimienphi = "Gói Miễn phí - Cơ bản";
        if(goimienphi.equalsIgnoreCase(goiHienTai)){
            soKyTuBanDau = 0;
        }else {
            soKyTuBanDau = laySoKyTuTrenTrangWeb();
        }
    }
    public void clickMuaGoiCuoc(){
        WebElement muaGoiCuocbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(muaGoiCuocLocator));
        muaGoiCuocbtn.click();
    }
    //chọn gói tháng
    public void clickChonGoiThang(){
        WebElement chonGoiThangBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonGoiThangLocator));
        chonGoiThangBtn.click();
    }
    public void clickChonGoiQuy(){
        WebElement chonGoiQuyBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonGoiQuyLocator));
        chonGoiQuyBtn.click();
    }
    public void clickChonGoiNam(){
        WebElement chonGoiNamBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonGoiNamLocator));
        chonGoiNamBtn.click();
    }
    public void clickChonMuaGoiMienPhi(){
        WebElement chonGoiMienPhiBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonGoiMienPhiLocator));
        chonGoiMienPhiBtn.click();
    }
    public void clickChonMuaGoiTieuChuan(){
        WebElement chonGoiTieuChuanBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonGoiTieuChuanLocator));
        chonGoiTieuChuanBtn.click();

    }
    public void clickChonMuaGoiChuyenNghiep(){
        WebElement chonGoiChuyenNghiepBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonGoiChuyenNghiepLocator));
        chonGoiChuyenNghiepBtn.click();
    }
    public void clickChonMuaGoiDacBiet(){
        WebElement chonGoiDacBietBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonGoiDacBietLocator));
        chonGoiDacBietBtn.click();
    }
    public void ramdomNganHang() throws IOException {
        WebElement techcombank = wait50.until(ExpectedConditions.visibilityOfElementLocated(TechcombankLocator));
        WebElement Vietcombank = wait50.until(ExpectedConditions.visibilityOfElementLocated(VietcombankLocator));
        WebElement VNPAY = wait50.until(ExpectedConditions.visibilityOfElementLocated(VNPAYLocator));
        WebElement Momo = wait50.until(ExpectedConditions.visibilityOfElementLocated(MomoLocator));
            WebElement[] nganhang = new WebElement[2];
    nganhang[0] = techcombank;
    nganhang[1]= Vietcombank;
    Random random = new Random();
    int randomIndex = random.nextInt((nganhang.length));
    WebElement randomNganhang = nganhang[randomIndex];
    captureScreen("ramdomBank.png");
    randomNganhang.click();
    }

    int sotienthanhtoan = 0 ; // số tiền thanh toán sau khi áp dụng voucher theo giá gói cước quy định
    double phantramgiam = 0;
    public void chonVoucherPhanTramVaThanhToan(String giatrigoicuco, String voucher) throws InterruptedException {
//        System.out.println("da den dc day r");
//        By tienGoiCuocLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div/span[2]");
//        WebElement tienGoiCuocBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(tienGoiCuocLocator));
//        String tienGoiCuocString = tienGoiCuocBtn.getText();
//        System.out.println("tien mua cac goi cuoc" + tienGoiCuocString);
//        String nam = tienGoiCuocString.replaceAll("[^\\d.]", "");
//
////// Loại bỏ ký tự 'đ' nếu cần thiết
////        if (nam.startsWith("đ")) {
////            nam = nam.substring(1);
////        }
//        String namDaBoDauCham = nam.replace(".", "");
        double tienGoiCuoc = (Integer.parseInt(giatrigoicuco));
        System.out.println("tiengoicuoc" + tienGoiCuoc);
    WebElement AddVoucher = driver.findElement(addVoucherLocator);
    Thread.sleep(1000);
        AddVoucher.click();
        System.out.println("da click button them Voucher");
        WebElement nhapvoucher = driver.findElement(nhapMaKhuyenMai);
        System.out.println("da nhap ma voucher");
        nhapvoucher.sendKeys(voucher);
        Thread.sleep(1000);
        By ApDung = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div/button");
        WebElement ApdungBtn = driver.findElement(ApDung);
        ApdungBtn.click();
        System.out.println("da ap voucher thanh cong");
        // check voucher
        System.out.println(voucher);
        String voucher69 = "GIAM69";
        String voucher5 ="5%";
        String voucher20 = "HUONGGIAM20";
        String voucher60 = "GIAM60%";
        int soTienThanhToanBaSoDau = 0; // số tiền cần thanh toán sau khi ap dung voucher
        if(voucher.equalsIgnoreCase(voucher69)){
            phantramgiam = 69;
            soTienThanhToanBaSoDau = (int) ((tienGoiCuoc - Math.ceil(tienGoiCuoc * phantramgiam /100))/1000);

        }        if(voucher.equalsIgnoreCase(voucher5)){
            phantramgiam = 5;
            soTienThanhToanBaSoDau = (int) ((tienGoiCuoc - Math.ceil(tienGoiCuoc * phantramgiam /100))/1000);

        }
        if (voucher.equalsIgnoreCase(voucher20)) {
            phantramgiam = 20;
            soTienThanhToanBaSoDau= (int) ((tienGoiCuoc - Math.ceil(tienGoiCuoc * phantramgiam /100))/1000);

        }
        if (voucher.equalsIgnoreCase(voucher60)) {
            phantramgiam = 60;
            soTienThanhToanBaSoDau = (int) ((tienGoiCuoc - Math.ceil(tienGoiCuoc * phantramgiam /100))/1000);
        }
        sotienthanhtoan = (int) (soTienThanhToanBaSoDau * 1000);
        System.out.println("den so tien thanh toan dung phai la : " + sotienthanhtoan);
        // lấy số tiền cần thanh toán hiển thị trên Website để so sánh với số tiền mình tính
        By sotienthanhtoanWebLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[4]/p[2]");
        WebElement sotienthanhtoanWebElement = wait50.until(ExpectedConditions.visibilityOfElementLocated(sotienthanhtoanWebLocator));
        String sotienthanhtoanWebText = sotienthanhtoanWebElement.getText();
        System.out.println(sotienthanhtoanWebText);
        String numericString = sotienthanhtoanWebText.replaceAll("[^\\d.]", "");
// Loại bỏ ký tự 'đ' nếu cần thiết
        if (numericString.startsWith("đ")) {
            numericString = numericString.substring(1);
        }
// Chuyển đổi chuỗi thành số
        String numericStringBocham = numericString.replace(".","");
        System.out.println("so tien ap dung voucher da bo dau cham" +numericStringBocham);
        double sotienthanhtoanWeb = (Double.parseDouble(numericStringBocham));
        System.out.println(sotienthanhtoanWeb);
        if(sotienthanhtoan != sotienthanhtoanWeb) throw new AssertionError("tinh sai gia goi cuoc sau khi khuyen mai");
        if(sotienthanhtoan == sotienthanhtoanWeb){
            By DongyThanhToan = By.xpath("//button[contains(text(),'Đồng ý thanh toán')]");
            WebElement DongyThanhToanBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(DongyThanhToan));
            DongyThanhToanBtn.click();
            Thread.sleep(2000);
            By ToiDaChuyenKhoan = By.xpath("//button[contains(text(),'Tôi đã chuyển khoản')]");
            WebElement ToiDaChuyenKhoanBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(ToiDaChuyenKhoan));
            ToiDaChuyenKhoanBtn.click();
        }

    }
    double soTienGiam = 0;
    public void chonVoucherGiamTienVaThanhToan(String giatrigoicuoc, String voucher) throws InterruptedException {
//        By tienGoiCuocLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/p[2]");
//        WebElement tienGoiCuocBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(tienGoiCuocLocator));
//        String tienGoiCuocString = tienGoiCuocBtn.getText();
//        System.out.println(tienGoiCuocString);
//        String nam = tienGoiCuocString.replaceAll("[^\\d.]", "");
//// Loại bỏ ký tự 'đ' nếu cần thiết
//        if (nam.startsWith("đ")) {
//            nam = nam.substring(1);
//        }
//        String namDaBoDauCham = nam.replace(".", "");
        double tienGoiCuoc = (Double.parseDouble(giatrigoicuoc));
        System.out.println("tiengoicuoc" + tienGoiCuoc);
        WebElement AddVoucher = wait50.until(ExpectedConditions.visibilityOfElementLocated(addVoucherLocator));
        Thread.sleep(1000);
        AddVoucher.click();
        WebElement nhapvoucher = wait50.until(ExpectedConditions.visibilityOfElementLocated(nhapMaKhuyenMai));
        nhapvoucher.sendKeys(voucher);
        Thread.sleep(1000);
        By ApDung = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div/button");
        WebElement ApdungBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(ApDung));
        ApdungBtn.click();
        // check voucher
        System.out.println(voucher);
        String voucher5K = "5K";
        if(voucher.equalsIgnoreCase(voucher5K)){
            soTienGiam= 5000;
            sotienthanhtoan = (int) (tienGoiCuoc - soTienGiam);
        }
        System.out.println("den so tien thanh toan dung phai la : " + sotienthanhtoan);
        By sotienthanhtoanWebLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[4]/p[2]");
        WebElement sotienthanhtoanWebElement = wait50.until(ExpectedConditions.visibilityOfElementLocated(sotienthanhtoanWebLocator));
        String sotienthanhtoanWebText = sotienthanhtoanWebElement.getText();
        System.out.println(sotienthanhtoanWebText);
        String numericString = sotienthanhtoanWebText.replaceAll("[^\\d.]", "");
// Loại bỏ ký tự 'đ' nếu cần thiết
        if (numericString.startsWith("đ")) {
            numericString = numericString.substring(1);
        }
// Chuyển đổi chuỗi thành số
        String numericStringBocham = numericString.replace(".","");
        System.out.println("so tien ap dung voucher da bo dau cham" +numericStringBocham);
        double sotienthanhtoanWeb = (Integer.parseInt(numericStringBocham));
        System.out.println(sotienthanhtoanWeb);
        if(sotienthanhtoan != sotienthanhtoanWeb) throw new AssertionError("tinh sai gia goi cuoc sau khi khuyen mai");
        if(sotienthanhtoan == sotienthanhtoanWeb){
            By DongyThanhToan = By.xpath("//button[contains(text(),'Đồng ý thanh toán')]");
            WebElement DongyThanhToanBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(DongyThanhToan));
            DongyThanhToanBtn.click();
            Thread.sleep(2000);
            By ToiDaChuyenKhoan = By.xpath("//button[contains(text(),'Tôi đã chuyển khoản')]");
            WebElement ToiDaChuyenKhoanBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(ToiDaChuyenKhoan));
            ToiDaChuyenKhoanBtn.click();
        }
    }
    int tienGoiCuocTangKyTu = 0;
   public void chonVoucherTangKyTuVaThanhToan(String giatrigoicuoc, String voucher) throws InterruptedException, IOException {
//       By tienGoiCuocLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/p[2]");
//       WebElement tienGoiCuocBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(tienGoiCuocLocator));
//       String tienGoiCuocString = tienGoiCuocBtn.getText();
//       System.out.println(tienGoiCuocString);
//       String nam = tienGoiCuocString.replaceAll("[^\\d.]", "");
//// Loại bỏ ký tự 'đ' nếu cần thiết
//       if (nam.startsWith("đ")) {
//           nam = nam.substring(1);
//       }
//       String namDaBoDauCham = nam.replace(".", "");
        tienGoiCuocTangKyTu = (Integer.parseInt(giatrigoicuoc));
       System.out.println("tiengoicuoc" + tienGoiCuocTangKyTu);
       WebElement AddVoucher = wait50.until(ExpectedConditions.visibilityOfElementLocated(addVoucherLocator));
       Thread.sleep(1000);
       AddVoucher.click();
       WebElement nhapvoucher = wait50.until(ExpectedConditions.visibilityOfElementLocated(nhapMaKhuyenMai));
       nhapvoucher.sendKeys(voucher);
       Thread.sleep(1000);
       By ApDung = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div/button");
       WebElement ApdungBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(ApDung));
       ApdungBtn.click();
       captureScreen("saukhiapdungVoucher.png");
       // check voucher
       System.out.println(voucher);
       By sotienthanhtoanWebLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[4]/p[2]");
       WebElement sotienthanhtoanWebElement = wait50.until(ExpectedConditions.visibilityOfElementLocated(sotienthanhtoanWebLocator));
       String sotienthanhtoanWebText = sotienthanhtoanWebElement.getText();
       System.out.println(sotienthanhtoanWebText);
       String numericString = sotienthanhtoanWebText.replaceAll("[^\\d.]", "");

// Loại bỏ ký tự 'đ' nếu cần thiết
       if (numericString.startsWith("đ")) {
           numericString = numericString.substring(1);
       }

// Chuyển đổi chuỗi thành số
       String numericStringBocham = numericString.replace(".","");
       System.out.println("so tien ap dung voucher da bo dau cham" +numericStringBocham);
       double sotienthanhtoanWeb = (Integer.parseInt(numericStringBocham));
       System.out.println(sotienthanhtoanWeb);
       if(tienGoiCuocTangKyTu != sotienthanhtoanWeb) throw new AssertionError("tinh sai gia goi cuoc sau khi khuyen mai");
       if(tienGoiCuocTangKyTu == sotienthanhtoanWeb){
           By DongyThanhToan = By.xpath("//button[contains(text(),'Đồng ý thanh toán')]");
           WebElement DongyThanhToanBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(DongyThanhToan));
           captureScreen("truockhithanhtoan.png");
           DongyThanhToanBtn.click();
           Thread.sleep(2000);
           By ToiDaChuyenKhoan = By.xpath("//button[contains(text(),'Tôi đã chuyển khoản')]");
           WebElement ToiDaChuyenKhoanBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(ToiDaChuyenKhoan));
           ToiDaChuyenKhoanBtn.click();
       }
   }
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    String ThoiGianDuyetGoi ;
    String ThoiGianHetHan;
    public void duyetDonHang() throws InterruptedException {
        driver.navigate().to("https://dev-back-office.vbee.vn/orders");
        By TimKiemDonHangLocator = By.id("input-with-icon-textfield");
        // tìm kiếm các đơn hàng tên nam
        WebElement TimKiemDonHangBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(TimKiemDonHangLocator));
        TimKiemDonHangBtn.click();
        TimKiemDonHangBtn.sendKeys("nam");
        By DonHangChoDuyet = By.id("PENDING");
        WebElement DonHangChoDuyetBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(DonHangChoDuyet));
        DonHangChoDuyetBtn.click();
        Thread.sleep(3000);
        try {
            // Khởi tạo Robot object
            Robot robot = new Robot();
            // Cuộn xuống 250px bằng cách nhấn nút Page Down nhiều lần
            for (int i = 0; i < 5; i++) { // Thực hiện 5 lần để đạt 250px
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            }

        } catch (AWTException e) {
            e.printStackTrace();
        }
        Thread.sleep(3000);
        System.out.println("phiaduoi" +sotienthanhtoan);
        // timf đơn hàng mà có số tiền = số tiền thanh toán khi đồng ý thanh toán ở bên mua gói cước
        WebElement trElement =wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[5]/table/tbody/tr/td[6]")));
        System.out.println(trElement.getText());
        // lấy số tiền mà đơn hàng đang chờ duyệt , đang lấy đơn đầu tiên
        String nam = trElement.getText();
        String namstring = nam.replace(",", "");
        double namdouble = Integer.parseInt(namstring);
        System.out.println("namformat" + namdouble);
        // Kiểm tra xem phần tử có tồn tại hay không
        if (sotienthanhtoan == namdouble || tienGoiCuocTangKyTu == namdouble) {
            // Tìm nút "Duyệt" và nhấp chuột vào nó
            System.out.println("vao day r");
            WebElement duyetButton = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='approval' and contains(text(), 'Duyệt')]")));
            duyetButton.click();
            By DongYDuyetDonLocator = By.xpath("//button[contains(text(),'Đồng ý')]");
            WebElement DongYDuyetDonBtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(DongYDuyetDonLocator));
            DongYDuyetDonBtn.click();
            ThoiGianDuyetGoi = now.format(formatter);
            LocalDateTime parsedThoiGianDuyetGoi = LocalDateTime.parse(ThoiGianDuyetGoi, formatter);
            System.out.println("Thoi gian duyet goi" +  parsedThoiGianDuyetGoi);
        } else {
            throw new AssertionError("Gia tri don hang khong dung");
        }

    }
    public static void quayVeTrangChu() throws InterruptedException {
        driver.navigate().to("https://dev-studio.vbee.vn/studio/text-to-speech");
        Thread.sleep(2000);
    }
    public void kiemtraKyTuCongThemSauKhiMuaGoiThangTieuChuan(String kyTu){
        System.out.println(soKyTuBanDau);
        int kyTuNumber = Integer.parseInt(kyTu);
        int soKyTuSauKhiMua = laySoKyTuTrenTrangWeb();
        System.out.println(soKyTuSauKhiMua);
        int soKyTuDungNhanDuoc = kyTuNumber+ soKyTuBanDau;
        if(soKyTuSauKhiMua != soKyTuDungNhanDuoc) throw new AssertionError("tinh sai ky tu khi mua goi");
    }
    public void kiemTraHanSuDung(int thang){
        System.out.println("ThoiGianDuyetGoi" +ThoiGianDuyetGoi);
        LocalDateTime parsedThoiGianDuyetGoi = LocalDateTime.parse(ThoiGianDuyetGoi, formatter);
// Cộng 1 tháng vào thời gian duyệt gói cước
        LocalDateTime ThoiGianHetHan = parsedThoiGianDuyetGoi.plusDays(thang) ;
        LocalDateTime ThoiGianHetHan1 = ThoiGianHetHan.plusMinutes(1);
        LocalDateTime ThoiGianHetHan2 = ThoiGianHetHan.plusMinutes(2);
    System.out.println("ThoiGianHetHan" +ThoiGianHetHan);
// Định dạng chuỗi thời gian hết hạn
        String formattedThoiGianHetHan = "HSD: " + ThoiGianHetHan.format(formatter);
        String formattedThoiGianHetHan1 = "HSD: " + ThoiGianHetHan1.format(formatter);
        String formattedThoiGianHetHan2 = "HSD: " + ThoiGianHetHan2.format(formatter);
        System.out.println("formattedThoiGianHetHan " + formattedThoiGianHetHan);
        WebElement ThoiGianHetHanWeb = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[4]/div/div/p[2]")));
        System.out.println("thoi gian het han web " + ThoiGianHetHanWeb.getText());
        if(formattedThoiGianHetHan.equalsIgnoreCase(ThoiGianHetHanWeb.getText()) || formattedThoiGianHetHan1.equalsIgnoreCase(ThoiGianHetHanWeb.getText()) || formattedThoiGianHetHan2.equalsIgnoreCase(ThoiGianHetHanWeb.getText())){
            System.out.println("Han su dung da dung");
        }else{
            throw new AssertionError("Tinh sai han su dung");
        }
    }
    public void checkTenGoiCuocSauKhiMua(String tenGoiKhiMua) throws InterruptedException {
        Thread.sleep(2000);
        WebElement tenGoiTrenWeb = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[5]/div[2]/p[2]")));
        assert tenGoiKhiMua.equalsIgnoreCase(tenGoiTrenWeb.getText()) :  " ten goi cuoc hien thi tren website sai";
        System.out.println("Ten goi cuoc mua da dung");
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
    public void kiemtradubongoicuoc(){
        System.out.println("bat dau kiem tra");
        System.out.println("bat dau 1");
        if ((isPackageVisible("Miễn phí"))) throw new AssertionError("khong có co ban");
        if ((isPackageVisible("Tiêu chuẩn"))) throw new AssertionError("khong có tieu chuan");
        if ((isPackageVisible("Chuyên nghiệp"))) throw new AssertionError("khong có chuyen nghiep");
        if ((isPackageVisible("Đặc biệt"))) throw new AssertionError("khong có dac biet");
    }
    public void clickDongythanhtoan(){
        WebElement dongythanhtoanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(dongythanhtoan));
        dongythanhtoanbtn.click();
    }
    public  void clickToidachuyenkhoan(){
        WebElement toidachuyenkhoanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(dachuyenkhoanbtn));
        toidachuyenkhoanbtn.click();
    }
    public void checkChuyenTrangLichSuThanhToan() throws InterruptedException, IOException {
// So sánh với URL mong đợi
        String expectedUrl = "https://dev-studio.vbee.vn/studio/payment-history";
        Thread.sleep(5000);
        captureScreen("tranglichsuthanhtoan1.png");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(5000);
        captureScreen("tranglichsuthanhtoan2.png");
        if(!expectedUrl.equals(currentUrl)) throw  new AssertionError("looi");
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
    public void captureScreen(String name) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("image\\MuaGoiCuoc\\" + name));
    }
}

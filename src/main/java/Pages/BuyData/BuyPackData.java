package Pages.BuyData;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
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
    By chonGoiTieuChuanLocator =By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[4]/span/div/div[2]/div[2]/div/div[4]/button");
    By chonGoiChuyenNghiepLocator = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[4]/span/div/div[3]/div[2]/div/div[4]/button");
    By chonGoiDacBietLocator = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[4]/span/div/div[4]/div[2]/div/div[4]/button");
    By chonGoiThangLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[1]");
    By chonGoiQuyLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[2]");
    By chonGoiNamLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[3]");
    By soKytuHienjCoLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[4]/div/div/p[1]");
    By TechcombankLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/div");
    By VietcombankLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div");
    By MomoLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div");
    By addVoucherLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div");
    By nhapMaKhuyenMai = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/div/input");
    public BuyPackData(WebDriver driver){
       this.driver = driver;
}
public int laySoKyTuTrenTrangWeb() throws InterruptedException {
        Thread.sleep(3000);
        WebElement soKyTuDaCo = wait50.until(ExpectedConditions.visibilityOfElementLocated(soKytuHienjCoLocator));
        String numberText = soKyTuDaCo.getText();
        String[] parts = numberText.split("\\s+"); // Tách chuỗi bằng khoảng trắng
       String numberPart = parts[0]; // Phần số sẽ là phần tử đầu tiên trong mảng
       numberPart = numberPart.replaceAll("\\D", ""); // Loại bỏ tất cả các ký tự không phải số
    return Integer.parseInt(numberPart);
}
int soKyTuBanDau = 0;
    public void LaySoKyTuTaiKhoanDaCo() throws InterruptedException {
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
            WebElement[] nganhang = new WebElement[2];
    nganhang[0] = techcombank;
    nganhang[1]= Vietcombank;
    Random random = new Random();
    int randomIndex = random.nextInt((nganhang.length));
    WebElement randomNganhang = nganhang[randomIndex];
    randomNganhang.click();
    }
    public void huyDon(){
        try {
            // Chờ banner cảnh báo xuất hiện
            WebElement alertBanner = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiBox-root .content-wrapper .MuiTypography-body1.content")));

            // Kiểm tra nội dung banner
            if (alertBanner.getText().contains("Quý khách có 01 đơn hàng đang chờ duyệt")) {
                // Tìm và click nút "Hủy đơn hàng"
                WebElement cancelOrderButton = wait50.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".MuiButton-root.cancel-button")));
                cancelOrderButton.click();
                System.out.println("Đơn hàng đã được hủy.");
            }
        } catch (Exception e) {
            System.out.println("Không có banner cảnh báo.");
        }

    }
    public void selectsBankMomo(){
        WebElement Momo = wait50.until(ExpectedConditions.visibilityOfElementLocated(MomoLocator));
        Momo.click();
    }
    int sotienthanhtoan = 0 ; // số tiền thanh toán sau khi áp dụng voucher theo giá gói cước quy định
    double phantramgiam = 0;
    public void chonVoucherPhanTramVaThanhToan(String giatrigoicuco, String voucher) throws InterruptedException {
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
    public void ChonVoucherGiamTien(String giatrigoicuoc, String voucher) throws InterruptedException {
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
    }

    public void chonVoucherGiamTienVaThanhToan(String giatrigoicuoc, String voucher) throws InterruptedException {
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
    public void kiemtraKyTuCongThemSauKhiMuaGoiThangTieuChuan(String kyTu) throws InterruptedException {
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
    public void showsInvalidCodeErrorMessage(){
        WebElement messageError = wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Mã không hợp lệ']")));
        if (messageError.isDisplayed()) {
            System.out.println("loi ma khong hop le ");
        } else {
            throw new AssertionError(" khong hien ma khong hop le ");
    }

    }
    public boolean  isPackageVisible( String packageName){
        By packageLocator =By.xpath("//div[@class='package-header']//div//p[text()='"+packageName+"']");
        System.out.println(packageLocator);
        WebElement packageElement = wait50.until(ExpectedConditions.visibilityOfElementLocated(packageLocator));
        return !packageElement.isDisplayed();
    }
    public void kiemtradubongoicuoc(){
        System.out.println("bat dau kiem tra");
        System.out.println("bat dau 1");
        if ((isPackageVisible("Miễn phí"))) throw new AssertionError("khong có co ban");
        if ((isPackageVisible("Tiêu chuẩn"))) throw new AssertionError("khong có tieu chuan");
        if ((isPackageVisible("Chuyên nghiệp"))) throw new AssertionError("khong có chuyen nghiep");
        if ((isPackageVisible("Đặc biệt"))) throw new AssertionError("khong có dac biet");
    }
    public void checkChuyenTrangLichSuThanhToan() throws InterruptedException, IOException {
// So sánh với URL mong đợi
        String expectedUrl = "https://dev-studio.vbee.vn/studio/payment-history";
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(5000);
        if(!expectedUrl.equals(currentUrl)) throw  new AssertionError("looi");
    }
}

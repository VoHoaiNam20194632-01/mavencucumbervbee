package Pages;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyPackOfData {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    Duration timeout10 = Duration.ofSeconds(10);
    WebDriverWait wait10 = new WebDriverWait(driver,timeout10);
    By muagoicuocLocator = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/ul/li[3]/a/div/div");
    By muangayLocator = By.xpath("//button[text()='Mua ngay']");
    By boquaLocator = By.xpath("//*[@id=\"react-joyride-step-0\"]/div/div/div[1]/div[3]/button");
    By nganhangLocator = By.xpath("//*[@id=\"choosePaymentMethod\"]/div/div/div[2]/div[2]/div/div/div[2]");
    By thaydoisdtLocator = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div[3]/p");
    By nhapsdtLocator = By.xpath("/html/body/div[6]/div[3]/div/div/div[1]/div[2]/div/div/input");
    By hoanthanhsdtLocator = By.xpath("//button[text()='Hoàn thành']");
    By thanhtoanLocator = By.xpath("//*[@id=\"makePayment\"]/button");
    By hoanthanhLocator = By.xpath("//button[text()='Hoàn tất']");


    public BuyPackOfData(WebDriver driver){
        this.driver = driver;
    }
    public void clickBuyOfDataButtonAndCheck() throws InterruptedException {
        WebElement buyofdataElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/header/div/div/div[1]/div[1]/div/button"));
        buyofdataElement.click();
        Thread.sleep(1000);
        System.out.println("da den day");
        String buttonText = buyofdataElement.getText();
        System.out.println(buttonText);
        boolean sosanh = buttonText.equals("CHỜ DUYỆT");
        System.out.println(sosanh);
        if (sosanh) {
            // Nếu nội dung là "cho duyet", thì thực hiện click và hủy
            Thread.sleep(1000);
            WebElement namButton = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div[2]/div[2]/button[1]"));
            namButton.click();
        }
    }
    public void clickDataMonths(String months) throws InterruptedException {
        WebElement muagoicuocbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(muagoicuocLocator));
        muagoicuocbtn.click();
        Thread.sleep(1000);
        By goicuocLocator =By.xpath("//button[text()='" + months+ "' and .//span]");
        Thread.sleep(1000);
        WebElement goicuocbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(goicuocLocator));
        goicuocbtn.click();
        Thread.sleep(1000);
    }
    public void clickBuyNowButton() throws InterruptedException {
        Thread.sleep(1000);
        WebElement muangaybtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(muangayLocator));
        muangaybtn.click();
        Thread.sleep(1000);
    }
    public void clickBoQua(){
        try{
            WebElement boquabtn = wait10.until(ExpectedConditions.visibilityOfElementLocated(boquaLocator));
            boquabtn.click();
        }catch (Exception e) {
            // Nếu nút Remove không xuất hiện, in thông báo ra console và tiếp tục chạy kiểm thử
            System.out.println("tiep tuc");
        }
    }
    public void clickSelectPaymentBank(){
        WebElement nganhangbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(nganhangLocator));
        nganhangbtn.click();
    }
    public void clickChangePhoneButton(){
        WebElement thaydoisdt = wait50.until(ExpectedConditions.visibilityOfElementLocated(thaydoisdtLocator));
        thaydoisdt.click();
    }
    public void clickCompletePhone(){
        WebElement hoanthanhsdtbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(hoanthanhsdtLocator));
        hoanthanhsdtbtn.click();
    }
    public void clickAgreeTopayButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement thanhtoanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(thanhtoanLocator));
        thanhtoanbtn.click();

    }
    public void clickAgreeTransferButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement toidachuyenkhoanbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(thanhtoanLocator));
        toidachuyenkhoanbtn.click();
        WebElement hoanthanhbtn = wait50.until(ExpectedConditions.visibilityOfElementLocated(hoanthanhLocator));
        hoanthanhbtn.click();
    }
}

package driver;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            String proxyAddress = "43.239.223.46";
            int proxyPort = 61111;
            // Tạo đối tượng Proxy
            Proxy proxy = new Proxy();
            String proxyString = proxyAddress + ":" + proxyPort;
            proxy.setHttpProxy(proxyString);
            proxy.setSslProxy(proxyString);

            // Cấu hình ChromeOptions với proxy
            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless"); // Chạy ở chế độ ngầm
//            chromeOptions.addArguments("--disable-gpu"); // Tắt GPU acceleration trong headless mode

            // Cài đặt đường dẫn đến driver
            chromeOptions.setCapability("proxy", proxy);
            // Khởi tạo WebDriver nếu chưa tồn tại
            driver = new ChromeDriver(  chromeOptions);
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
            String downloadFilepath = "C:\\Users\\VO HOAI NAM\\Downloads\\audioVbee";

            // Set Chrome options to set download directory
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("download.default_directory", downloadFilepath);
            ChromeOptions chromeOptions = new ChromeOptions();
           chromeOptions.setExperimentalOption("prefs", prefs);
            Dimension windowSize = new Dimension(1532, 880);
            chromeOptions.addArguments("--window-size=" + windowSize.getWidth() + "," + windowSize.getHeight());
//            chromeOptions.addArguments("--headless=new"); // Chạy ở chế độ ngầm
//            chromeOptions.addArguments("--disable-gpu"); // Tắt GPU acceleration trong headless mode
            // Cài đặt đường dẫn đến driver
            chromeOptions.setCapability("proxy", proxy);

            driver = new ChromeDriver(  chromeOptions);

            Dimension windowSize1 = new Dimension(1500, 800); // Kích thước cửa sổ mới (chiều rộng x chiều cao)
            driver.manage().window().setSize(windowSize1); // Thiết lập kích thước cửa sổ
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

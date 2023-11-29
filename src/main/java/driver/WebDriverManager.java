package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            // Khởi tạo WebDriver nếu chưa tồn tại
            driver = new ChromeDriver();
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

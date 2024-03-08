package Pages.DangKy;

import driver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DangKy {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    //wait
    Duration timeout50 = Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);


}

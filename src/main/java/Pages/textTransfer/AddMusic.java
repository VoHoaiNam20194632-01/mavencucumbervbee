package Pages.textTransfer;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddMusic {
    private static WebDriver driver;

    static {
        driver = WebDriverManager.getDriver();
    }
    Duration timeout50= Duration.ofSeconds(50);
    WebDriverWait wait50 = new WebDriverWait(driver,timeout50);
    By nhacnenLocator = By.xpath("//*[@id=\"request-editor\"]/div[1]/div[2]/div[1]/button[4]");
    By chonnhacnenLocator = By.xpath("/html/body/div[6]/div[3]/div/div/div[1]/ul/li[5]");
    By apdungLocator = By.xpath("//button[contains(text(), 'Áp dụng')]");

    public AddMusic(WebDriver driver){
        this.driver = driver;
    }
    public void clickMusicButton(){
        WebElement nhacnen = wait50.until(ExpectedConditions.visibilityOfElementLocated(nhacnenLocator));
        nhacnen.click();
    }
    public void selectMusic(String music){
        By chonnhacnenLocator = By.xpath("//li[p[text()='" + music + "']]");
        WebElement chonnhacnen = wait50.until(ExpectedConditions.visibilityOfElementLocated(chonnhacnenLocator));
        chonnhacnen.click();
    }
    public void acceptMusic(){
        WebElement apdung = wait50.until(ExpectedConditions.visibilityOfElementLocated(apdungLocator));
        apdung.click();

    }
}

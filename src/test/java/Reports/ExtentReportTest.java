package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentReportListener.class)
public class ExtentReportTest {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void setUp() {
        // Đặt đường dẫn để lưu trữ báo cáo
        String reportPath = "target/report.html";

        // Khởi tạo ExtentReports
        extent = ExtentManager.createInstance(reportPath);
    }

    @Test
    public void testExample() {
        // Khởi tạo test case trong báo cáo
        test.set(extent.createTest("testExample"));

        // Thực hiện test và log thông tin chi tiết
        test.get().log(Status.INFO, "Starting test");
        // Thực hiện các bước test khác
        test.get().log(Status.PASS, "Test passed");
    }

    @AfterSuite
    public void tearDown() {
        // Đóng ExtentReports và xuất báo cáo
        extent.flush();
    }
}

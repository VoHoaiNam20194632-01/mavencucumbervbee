package Reports;//package Reports;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class ExtentReportListener implements ITestListener {
//    private static ExtentReports extent = ExtentManager.createInstance();
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//
//    @Override
//    public void onStart(ITestContext context) {
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        extent.flush();
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        // Thay vì sử dụng method name, bạn có thể lấy tên thực tế của test
//        String methodName = result.getTestClass().getName();
//        ExtentTest extentTest = extent.createTest(methodName);
//        test.set(extentTest);
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.get().log(Status.PASS, "Test passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.get().log(Status.FAIL, "Test failed");
//        test.get().log(Status.FAIL, result.getThrowable());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        test.get().log(Status.SKIP, "Test skipped");
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        logStep(result.getName(), "Test failed within success percentage");
//    }
//
//    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//        logStep(result.getName(), "Test failed with timeout");
//    }
//
//    private void logStep(String stepName, String stepStatus) {
//        test.get().log(Status.INFO, stepName + ": " + stepStatus);
//    }
//}

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.createInstance("target/report.html");
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        PickleWrapper pickleWrapper = (PickleWrapper) result.getParameters()[0];
        String scenarioName = pickleWrapper.getPickle().getName();
        System.out.println("batdau");
        System.out.println(result);
        System.out.println("ketthuc");
        test.set(extent.createTest(scenarioName));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        PickleWrapper pickleWrapper = (PickleWrapper) result.getParameters()[0];
        FeatureWrapper featureWrapper = (FeatureWrapper) result.getParameters()[1];

        String scenarioName = pickleWrapper.getPickle().getName();
        String featureName = featureWrapper.getClass().getName();

        System.out.println("Scenario Name: " + scenarioName);
        System.out.println("Feature Name: " + featureName);

        // Lấy danh sách các bước test từ PickleStepTestStep
        for (TestStep testStep : pickleWrapper.getTestSteps()) {
            if (testStep instanceof PickleStepTestStep) {
                PickleStepTestStep pickleStepTestStep = (PickleStepTestStep) testStep;
                PickleStep pickleStep = pickleStepTestStep.getPickleStep();
                String stepText = pickleStep.getText();
                String stepStatus = result.getStatus() == ITestResult.SUCCESS ? "PASS" : "FAIL";
                System.out.println("Test Case: " + stepText + " - " + stepStatus);
            }
        }
    }

    // Phương thức để log thông tin chi tiết của từng bước
    private void logStepDetails(String stepName, String stepDetails) {
        test.get().log(Status.INFO, stepName + ": " + stepDetails);
    }

}


package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pageObjects.BasePage;

import java.io.File;

public class Listeners implements ITestListener {
    private ExtentReports extent;
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        // Initialize the report
        String path = System.getProperty("user.dir") + "\\report\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Video Platform Test Results");
        reporter.config().setDocumentTitle("Automation Test Report");
        
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Helen");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create test entry in report
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test); // Set the current test in ThreadLocal
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (driver != null) {
            String screenshotDirectory = System.getProperty("user.dir") + "/screenshots/";
            String fileName = result.getMethod().getMethodName() + "_" + System.currentTimeMillis() + ".png";
            String filePath = screenshotDirectory + fileName;

            try {
                BasePage.getScreenshot(filePath, driver);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (new File(filePath).exists()) {
                extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
            } else {
                extentTest.get().fail("Screenshot file path is invalid or file does not exist.");
            }
        } else {
            extentTest.get().fail("Driver is null. Screenshot could not be captured.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the report
        extent.flush();
    }
}

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import resources.Base;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {
    ExtentTest test;
    ExtentReports extent=ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        test= extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

    }

    public void onTestSuccess(ITestResult iTestResult) {
        // TODO Auto-generated method stub
        extentTest.get().log(Status.PASS, "Test Passed");

    }

    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());
        WebDriver driver =null;
        String testMethodName =result.getMethod().getMethodName();

        try {
            driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch(Exception e)
        {

        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext)
    {
    extent.flush();
    }
}

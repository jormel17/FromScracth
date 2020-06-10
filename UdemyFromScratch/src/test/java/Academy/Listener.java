package Academy;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;

public class Listener extends base implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal <ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {

        test= extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS, "Test Passed");
        extentTest.set(test);
    }

    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());
        WebDriver driver=null;
        String testMethodName= result.getMethod().getMethodName();
        try {

            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        }catch (Exception e)
        {

        }
        try{
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver),result.getMethod().getMethodName());


        } catch ( IOException e){
            e.printStackTrace();
        }


    }


    public void onTestSkipped(ITestResult result) {

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onTestFailedWithTimeout(ITestResult result) {

    }


    public void onStart(ITestContext context) {

    }


    public void onFinish(ITestContext context) {
        extent.flush();

    }
}

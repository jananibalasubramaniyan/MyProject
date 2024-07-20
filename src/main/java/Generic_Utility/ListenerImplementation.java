package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener 
{

	 ExtentReports report;
	 ExtentTest test;
	
    public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result)
	{
	test.log(Status.PASS, result.getMethod().getMethodName());
	test.log(Status.PASS, result.getThrowable());
		
	}

	public void onTestFailure(ITestResult result){
		
        test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("<--------I am Listening----------->");
		 
		String screenShot=null;
		
			try {
screenShot = WebDriver_Utility.takeScreenShot((WebDriver) BaseClass.sDriver, result.getMethod().getMethodName());
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
	
		test.addScreenCaptureFromPath(screenShot);
	
	}

	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		
		Java_Utitlity jlib = new Java_Utitlity();
		int ranNum = jlib.getRandomNum();
		
ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+ranNum);
spark.config().setTheme(Theme.STANDARD);
spark.config().setDocumentTitle("Testing");
spark.config().setReportName("Janani");

//system configuration
report=new ExtentReports();
	
report.attachReporter(spark);
report.setSystemInfo("platform", "windows10");
report.setSystemInfo("executed by", "Janani");
report.setSystemInfo("reviewed by", "Karthi");
}
public void onFinish(ITestContext context) {
		report.flush();
	}
}
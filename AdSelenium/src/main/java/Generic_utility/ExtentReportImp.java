package Generic_utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener{

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		//Step 3: Create the Test Method during the test execution starts
		report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//Step4: Log the pass Method
		test.log(Status.PASS,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Step5 Log the Fail Method
		String testName = result.getMethod().getMethodName();
		System.out.println("---------Execute------------");
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.Sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("./Screen/"+testName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//Step6 Log the Skip Method
		
		test.log(Status.SKIP,result.getMethod().getMethodName());
	}

	
	public void onStart(ITestContext context) {
		//Step 1 Extent Report Configuration
		Date d = new Date();
		System.out.println(d);
		d.toString().replace(":", "-").replace(" ", "*");
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(new String("ExtentReports.html"));
		htmlreport.config().setDocumentTitle("ActiTime ExtentReport");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Automation Test");
		
		/*Step 2:
		 * Attach the physical report and do the same configuration*/
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "MAC");
		report.setSystemInfo("Environment", "Automation Testing");
		report.setSystemInfo("url", "https://demo.actitime.com/login.do");
		report.setSystemInfo("Reporter Name", "Shail");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//Step7: 
		report.flush();
	}
	
	

}

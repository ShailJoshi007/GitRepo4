package Generic_utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.protobuf.ByteString.Output;

public class ListenerImplimentation implements ITestListener{
	public void onTestFailure(ITestResult result)
	{
		/*
		String testData= result.getMethod().getMethodName();
		System.out.println("-----Execute-------");
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.Sdriver);
		File src  = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File("./ScreenShot"+testData+".png") );
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
	
	
		//To Take multiple ScreenShot
		String testName= result.getMethod().getMethodName();
		System.out.println("-----Execute-------");
		
		TakesScreenshot screen = (TakesScreenshot) BaseClass.Sdriver;
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.Sdriver);
		File src  = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File("./ScreenShot"+testName+".png") );
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
	

}

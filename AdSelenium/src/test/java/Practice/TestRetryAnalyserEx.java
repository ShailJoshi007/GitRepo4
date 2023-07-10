package Practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.File_Utility;

public class TestRetryAnalyserEx extends BaseClass{

	
//@Test
	@Test(retryAnalyzer= Generic_utility.RetryAnalyser.class)
	public void createContact() throws Throwable
	{
		int RAcount =0;
		
		System.out.println("ContactCreated");

		File_Utility flib = new File_Utility();
//		//System.out.println("Contact Created");
		String URL = flib.getStringKeyAndValue("url");
		System.out.println(URL);	
		driver.get(URL);
		System.out.println("ContactCreated");
		driver.findElement(By.id("username")).sendKeys("trainee");
		driver.findElement(By.name("pwd")).sendKeys("trainee");
		driver.findElement(By.id("loginButton")).click();
		Assert.assertEquals(false, true);
		Thread.sleep(1000);
		RAcount++;
		System.out.println("RA Count is "+RAcount);
		
	}
	
	


}

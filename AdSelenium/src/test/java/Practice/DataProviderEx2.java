package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utility.File_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx2 {
	@Test(dataProvider="getData")
	public void mi(String userName,String passWord) throws Throwable {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Uid is"+userName+"and Password is "+passWord);
		//System.out.println("Uid is"+userName+"and Password is "+passWord);
		
		File_Utility flib = new File_Utility();
		String URL = flib.getStringKeyAndValue("url");
		driver.get(URL);
		//driver.get("https://demo.actitime.com/login.do");			
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.name("pwd")).sendKeys(passWord);
		driver.findElement(By.id("loginButton")).click();
		
		Thread.sleep(1000);
	//	driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] obj = new Object[1][2];
		obj[0][0]= "trainee";
		obj[0][1]= "trainee";	
		

//		obj[1][0]= "admin";
//		obj[1][1]= "admin";
		return obj;
		
	}
	
	

}

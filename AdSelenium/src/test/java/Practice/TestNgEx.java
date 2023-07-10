package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.File_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgEx extends BaseClass{
	
@Test
	
	public void createContact() throws Throwable
	{
		//Pulling the data from the Git Repo2
		System.out.println("ContactCreated");
//		WebDriver driver = null;
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
////		driver.get("https://www.amazon.in/");
//		
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
		
	}
	
	public void createModified()
	{
		System.out.println("ContactModified");
	}
	
	public void createDeleted()
	{
		System.out.println("ContactDeleted");
	}
}

package vTigerEx;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_utility.Java_Utility;
import Generic_utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
//import jnr.posix.WindowsLibC;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.get("http://localhost:8888/");
		//driver.manage().window().maximize();
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicitWait(driver);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");  
		driver.findElement(By.name("user_password")).sendKeys("admin");  
		driver.findElement(By.id("submitButton")).click();	
		//Step 1:Creating Product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//		Random ran= new Random();
//		int ranNum = ran.nextInt(1000);
		
		// Calling Random method from Java Utility Class
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandom();
				
		String productName = "bluetooth"+ranNum;
		System.out.println("1"+productName);
		driver.findElement(By.name("productname")).sendKeys(productName);	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 1:Creating Campaign and selecting same product
		
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();		
		driver.findElement(By.name("campaignname")).sendKeys("Marketing"+ranNum);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		wlib.switchWindow(driver, "Products&action");
	
//		Set<String> allWindows = driver.getWindowHandles();
//		Iterator<String> id=  allWindows.iterator();
//		
//		while(id.hasNext())
//		{
//			String win = id.next();
//			driver.switchTo().window(win);
//			String title = driver.getTitle();
//			if(title.contains("Products&action"))
//			{
//				break;
//			}
//		}
		Thread.sleep(1000);
		driver.findElement(By.name("search_text")).sendKeys(productName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		System.out.println("2"+productName);
		 driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		 
		 wlib.switchWindow(driver, "Campaigns&action");
		 
//		 Set<String> allWindows1 = driver.getWindowHandles();
//			Iterator<String> id1=  allWindows1.iterator();
//			
//			while(id1.hasNext())
//			{
//				String win1 = id1.next();
//				driver.switchTo().window(win1);
//				String title1 = driver.getTitle();
//				if(title1.contains("Campaigns&action"))
//				{
//					break;
//				}
//			}
		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();	
			driver.findElement(By.linkText("Sign Out")).click();
		
		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();	
//		driver.findElement(By.linkText("Sign Out")).click();
	}

}

package vTigerEx;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampainWithProduct {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");  
		driver.findElement(By.name("user_password")).sendKeys("admin");  
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='More']")).click();
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();

		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();		
		driver.findElement(By.name("campaignname")).sendKeys("HealthAwareness");
		
		// return the parent window name as a String
		//Store the ID of the original window
				 String parentWindow=driver.getWindowHandle();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				//Check we don't have other windows open already
				 assert driver.getWindowHandles().size() == 1;	 
		
				//Click the link which opens in a new window                
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!parentWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("hp");
		        driver.findElement(By.name("search")).click();
		       // driver.close();
		     
		    }
		}
		//driver.switchTo().window(parentWindow);
		

		
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();



	}

}

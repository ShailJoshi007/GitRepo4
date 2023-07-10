package vTigerEx;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicitWait(driver);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		//driver.manage().window().maximize();
		wlib.maximizeScreen(driver);
		driver.findElement(By.name("user_name")).sendKeys("admin");  
		driver.findElement(By.name("user_password")).sendKeys("admin");  
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='More']")).click();
		//driver.findElement(By.linkText("More")).click();
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		//driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();		
		driver.findElement(By.name("campaignname")).sendKeys("HealthAwareness");
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();	
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Logout using Action Class
		
	}

}

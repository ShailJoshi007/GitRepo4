package vTigerEx;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_utility.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");  
		driver.findElement(By.name("user_password")).sendKeys("admin");  
		driver.findElement(By.id("submitButton")).click();		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		// Calling Random method from Java Utility Class
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandom();
		
		driver.findElement(By.name("productname")).sendKeys("iphone"+ranNum);	
		WebElement data = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]"));
		Rectangle val = data.getRect();
		System.out.println(val.getX());
		System.out.println(val.getY());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=0;i<4;i++)
		{
			js.executeScript("window.scrollBy(0,229)");
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();	
//	WebElement data1 = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));	
//	Rectangle val1 = data1.getRect();
//	System.out.println(val1.getX());
//	System.out.println(val1.getY());
	



	}


}

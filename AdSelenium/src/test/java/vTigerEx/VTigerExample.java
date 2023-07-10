package vTigerEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VTigerExample {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.get("http://localhost:8888/");

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");  
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");  
		
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//table[@class='hdrTabBg']//table/tbody/tr[*]//a[text()= 'Organizations']B")).click();
		

	}

}

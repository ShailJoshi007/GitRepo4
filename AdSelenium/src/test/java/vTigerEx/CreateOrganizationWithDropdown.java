package vTigerEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Generic_utility.Excel_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithDropdown {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		// Calling Random method from Java Utility Class
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandom();
		//We are calling the method from File_Utility class to Optimzed the code
		File_Utility flib = new File_Utility();
		
		String URL = flib.getStringKeyAndValue("url");
		String UserName = flib.getStringKeyAndValue("username"); 
		String Password = flib.getStringKeyAndValue("password");		
			
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);  
		driver.findElement(By.name("user_password")).sendKeys(Password);	
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//Fetching Data from Excel Sheet using Excel_Utility Generic Class
		
		Excel_Utility elib = new Excel_Utility();
		String OrganizationName = elib.getExcelData("OrgData", 1, 0)+ranNum;
		driver.findElement(By.name("accountname")).sendKeys(OrganizationName);
		
		String PhoneNo = elib.getExcelDataUsingDataFormatter("OrgData", 2, 0);
		driver.findElement(By.id("phone")).sendKeys(PhoneNo); 
		System.out.println(PhoneNo);
		
		String EmailId = elib.getExcelDataUsingDataFormatter("OrgData", 3, 0);
		driver.findElement(By.id("email1")).sendKeys(EmailId);
		
		
		String Industry = elib.getExcelDataUsingDataFormatter("OrgData", 3, 0);
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		Select drpIndustry = new Select(industry);
		//drpIndustry.selectByVisibleText("ANTARCTICA");
		
		//String Type = elib.getExcelDataUsingDataFormatter("Sheet1", 3, 0);
		//driver.findElement(By.xpath("//select[@name='accounttype']"));
		
		//driver.findElement(By.name("accountname")).sendKeys("Jhony"+ranNum);  
		//driver.findElement(By.id("phone")).sendKeys("1234567891"); 
		//driver.findElement(By.id("email1")).sendKeys("jhony@gmail.com");
		
		/*driver.findElement(By.name("accountname")).sendKeys(OrganizationName);  
		driver.findElement(By.id("phone")).sendKeys(PhoneNo); 
		driver.findElement(By.id("email1")).sendKeys(EmailId);*/
		
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	

	}

}

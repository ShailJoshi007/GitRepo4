package vTigerEx;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_utility.Excel_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
//		driver.get("http://localhost:8888/");
//		driver.findElement(By.name("user_name")).sendKeys("admin");  
//		driver.findElement(By.name("user_password")).sendKeys("admin");  
		
		//Random ran= new Random();
		//int ranNum = ran.nextInt(1000);
		
		// Calling Random method from Java Utility Class
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandom();
		
		/*
		//Making TEst Script Generic Using Properties and Excel file
				FileInputStream fis1 = new FileInputStream("src/test/resources/VTigerProp.properties");
				
				Properties pro = new Properties();
				pro.load(fis1);
				String URL = pro.getProperty("url");
				String UserName = pro.getProperty("username"); 
				String Password = pro.getProperty("password");
				*/
		
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
		
		/*FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Documents\\TestDataWrite1.xlsx");		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(0);
		String OrgName = cel.getStringCellValue();
		System.out.println(OrgName);
		
		Row row1 = sh.getRow(2);
		Cell cel1 = row1.getCell(0);
		DataFormatter format = new DataFormatter();
		String PhoneNo = format.formatCellValue(cel1);
		//String PhoneNo = cel1.getStringCellValue();
		System.out.println(PhoneNo);
		
		
		Row row2 = sh.getRow(3);
		Cell cel2 = row2.getCell(0);
		String EmailId = cel2.getStringCellValue();
		System.out.println(EmailId);
		String OrganizationName = OrgName+ranNum;
		System.out.println(OrganizationName);*/
		
		//Fetching Data from Excel Sheet using Excel_Utility Generic Class
		
		Excel_Utility elib = new Excel_Utility();
		String OrganizationName = elib.getExcelData("Sheet1", 1, 0)+ranNum;
		driver.findElement(By.name("accountname")).sendKeys(OrganizationName);
		
		String PhoneNo = elib.getExcelDataUsingDataFormatter("Sheet1", 2, 0);
		driver.findElement(By.id("phone")).sendKeys(PhoneNo); 
		System.out.println(PhoneNo);
		
		String EmailId = elib.getExcelDataUsingDataFormatter("Sheet1", 3, 0);
		driver.findElement(By.id("email1")).sendKeys(EmailId);
		
		
		
		
		//driver.findElement(By.name("accountname")).sendKeys("Jhony"+ranNum);  
		//driver.findElement(By.id("phone")).sendKeys("1234567891"); 
		//driver.findElement(By.id("email1")).sendKeys("jhony@gmail.com");
		
		/*driver.findElement(By.name("accountname")).sendKeys(OrganizationName);  
		driver.findElement(By.id("phone")).sendKeys(PhoneNo); 
		driver.findElement(By.id("email1")).sendKeys(EmailId);*/
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	}

}

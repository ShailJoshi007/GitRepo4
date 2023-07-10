package vTigerEx;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProduct {

	public static void main(String[] args) throws Throwable, IOException {
		//Step 1: Create Product
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		
		//Making TEst Script Generic Using Properties and Excel file
		FileInputStream fis1 = new FileInputStream("src/test/resources/VTigerProp.properties");
		
		Properties pro = new Properties();
		pro.load(fis1);
		String URL = pro.getProperty("url");
		String UserName = pro.getProperty("username"); 
		String Password = pro.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);  
		driver.findElement(By.name("user_password")).sendKeys(Password);
		
		
		//driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
//		driver.findElement(By.name("user_name")).sendKeys("admin");  
//		driver.findElement(By.name("user_password")).sendKeys("admin");  
		driver.findElement(By.id("submitButton")).click();	
		//Step 1:Creating Product
				
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		Random ran= new Random();
		int ranNum = ran.nextInt(1000);
//		String productName = "bluetooth"+ranNum;
//		System.out.println("1"+productName);
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Documents\\TestDataWrite1.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		String data = cel.getStringCellValue();
		System.out.println(data);
		
		String productName = data+ranNum;
		System.out.println(productName);
		driver.findElement(By.name("productname")).sendKeys(productName);	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		
		//Step:2 Delete Product
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+productName+"']/../preceding-sibling::td/input")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();

	}

}

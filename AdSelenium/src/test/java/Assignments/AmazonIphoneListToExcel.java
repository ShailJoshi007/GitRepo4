package Assignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonIphoneListToExcel {

	public static void main(String[] args) throws Throwable {
		
		//Step 1: Set the path
		//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		//FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Documents\\TestDataWrite1.xlsx");
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataWrite1.xlsx");
		//Step 2: Open the workbook  in read mode
		Workbook book = WorkbookFactory.create(fis);
		//Step 3: get the control to the sheet
		Sheet sh = book.getSheet("FlipkartData");
		
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://flipkart.com");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement searchIPhone = driver.findElement(By.name("q"));
		searchIPhone.sendKeys("iphone");
		searchIPhone.submit();
		Thread.sleep(1000);
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		System.out.println(allLinks.size());
		for(int i = 0;i<allLinks.size();i++)
		{
			System.out.println(allLinks.get(i).getText());
			
			Row row = sh.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getText());
			
		}
//		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
        FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataWrite1.xlsx");
	book.write(fos);
	book.close();
		
	}

}

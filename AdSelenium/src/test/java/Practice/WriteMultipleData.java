package Practice;

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

public class WriteMultipleData {

	public static void main(String[] args) throws Throwable {
		
		//Step 1: Set the path
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		//FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Desktop\\AmazonLinkData.xlsx");
		//Step 2: Open the workbook  in read mode
		Workbook book = WorkbookFactory.create(fis);
		//Step 3: get the control to the sheet
		Sheet sh = book.getSheet("Sheet3");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElements(By.xpath("//a"));
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		for(int i = 0;i<allLinks.size();i++)
		{
			Row row = sh.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
			
		}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		//FileOutputStream fos = new FileOutputStream("C:\\Users\\Hp\\Desktop\\AmazonLinkData.xlsx");
	book.write(fos);
	book.close();
		
		
		

	}

}

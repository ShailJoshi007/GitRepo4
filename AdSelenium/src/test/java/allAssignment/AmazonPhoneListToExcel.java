package allAssignment;


import java.io.FileInputStream;
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

import Generic_utility.Excel_Utility;
import Generic_utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPhoneListToExcel {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		Webdriver_Utility wlib = new Webdriver_Utility();
		Excel_Utility elib = new Excel_Utility();
		driver.get("https://flipkart.com");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement searchIPhone = driver.findElement(By.name("q"));
		searchIPhone.sendKeys("iphone");
		searchIPhone.submit();
		
		wlib.implicitWait(driver);
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='col col-7-12']/div[@class='_4rR01T']"));
		wlib.implicitWait(driver);
		List<WebElement> price =  driver.findElements(By.xpath("//div[@class='_25b18c']/div[@class='_30jeq3 _1_WHN1']"));
		//Thread.sleep(3000);
		System.out.println("Size of name list:  "+names.size());
		System.out.println("Size of price list:  "+price.size());
		
	
		
		
//		//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
//		FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Documents\\TestDataWrite1.xlsx");
//				//Step 2: Open the workbook  in read mode
//        Workbook book = WorkbookFactory.create(fis);
//				//Step 3: get the control to the sheet
//		Sheet sh = book.getSheet("PhoneList");	
//		for(int i=0;i<names.size();i++)
//		{
//			System.out.println(names.get(i).getText()+"\t"+price.get(i).getText());
//			//System.out.println(allLinks.get(i).getText());
//			
//			Row row = sh.createRow(i);
//			Cell cell = row.createCell(0);
//			cell.setCellValue(names.get(i).getText());
//			
//		}
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\Hp\\Documents\\TestDataWrite1.xlsx");
//	book.write(fos);
//	book.close();
//		
//		
		
	}

}

package Assignments;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();

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
			
//			Row row = sh.createRow(i);
//			Cell cell = row.createCell(0);
//			cell.setCellValue(allLinks.get(i).getAttribute("href"));
			
		}
//		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
//		//FileOutputStream fos = new FileOutputStream("C:\\Users\\Hp\\Desktop\\AmazonLinkData.xlsx");
//	book.write(fos);
//	book.close();
		
		
		
		
	

	}

}

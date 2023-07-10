package allAssignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utility.Excel_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_Utility;
import Generic_utility.Webdriver_Utility;
import OrganizationPOM.HomePage;
import OrganizationPOM.LoginPage;
import OrganizationPOM.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProduct {

	public static void main(String[] args) throws Throwable, IOException {

		Webdriver_Utility wlib = new Webdriver_Utility();
		Java_Utility jlib = new Java_Utility();	
		File_Utility flib = new File_Utility();	
		Excel_Utility elib = new Excel_Utility();
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new  ChromeDriver();
		String BROWSER = flib.getStringKeyAndValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new  ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new  EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		wlib.implicitWait(driver);
		
		String URL = flib.getStringKeyAndValue("url");
		String UserName = flib.getStringKeyAndValue("username"); 
		String Password = flib.getStringKeyAndValue("password");						
		driver.get(URL);
		wlib.maximizeScreen(driver);
		//Login
		//Calling from POM
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToPage(UserName, Password);
//		driver.findElement(By.name("user_name")).sendKeys(UserName);  
//		driver.findElement(By.name("user_password")).sendKeys(Password);	
//		driver.findElement(By.id("submitButton")).click();
		//Step 1:Creating Product
				
		//Click on Product Link
		//Calling the Product link From HomePage POM
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		//Click on + Link
		ProductPage product = new ProductPage(driver);
		product.createProductLinkClick();
	   // driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				
		//java Utility method	
		int ranNum = jlib.getRandom();
		String ProductName = elib.getExcelData("Product", 0, 0)+ranNum;
		System.out.println(ProductName);
		product.productName(ProductName);
		product.saveButtonClick(driver);
	
		
		//Step:2 Delete Product
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+ProductName+"']/../preceding-sibling::td/input")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+ProductName+"']/../preceding-sibling::td/input")).click();
		//
		driver.findElement(By.xpath("//input[@value='Delete']")).click();		
		wlib.alertAccept(driver);
		
		//(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]
		//Validation
		List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		
		boolean flag=false;
		
		for(WebElement prodName:productList)
		{
			String actData = prodName.getText();
			if(actData.contains(ProductName))
			{
				flag = true;
				break;
			}
		}
			if(flag)
			{
				System.out.println("product data is deleted");
			}
			else
			{
				System.out.println("product data is not deleted");
			}
			//Logout
			home.logOut(driver);
//			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();	
//			driver.findElement(By.linkText("Sign Out")).click();
		}
		
}

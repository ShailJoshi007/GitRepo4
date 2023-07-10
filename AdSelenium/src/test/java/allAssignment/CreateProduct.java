package allAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
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

public class CreateProduct {

	public static void main(String[] args) throws Throwable {

		
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
		//Login
		
		//Calling from POM
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToPage(UserName, Password);
//		driver.findElement(By.name("user_name")).sendKeys(UserName);  
//		driver.findElement(By.name("user_password")).sendKeys(Password);	
//		driver.findElement(By.id("submitButton")).click();
		//Click on Product Link
		//Calling the Product link From Home Page POM
		
		HomePage home = new HomePage(driver);
		home.clickProductLink();
	
		//Click on + Link to create a product from ProductPage POM
		ProductPage product = new ProductPage(driver);
		product.createProductLinkClick();

		//java Utility method	
		int ranNum = jlib.getRandom();
		String ProductName = elib.getExcelData("Product", 0, 0)+ranNum;
		System.out.println(ProductName);
		product.productName(ProductName);
		product.saveButtonClick(driver);
		Thread.sleep(3000);
		//Validation
		String actualData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		if(actualData.contains(ProductName))
		{
			System.out.println("Validation Pass");
		}
		else
		{
			System.out.println("Validation Failed");
		}
		//Logout
		home.logOut(driver);
	}

}

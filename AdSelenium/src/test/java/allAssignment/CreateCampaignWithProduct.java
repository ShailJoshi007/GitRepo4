package allAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utility.Excel_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_Utility;
import Generic_utility.Webdriver_Utility;
import OrganizationPOM.CreateCampaignPage;
import OrganizationPOM.HomePage;
import OrganizationPOM.LoginPage;
import OrganizationPOM.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct {

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
		wlib.maximizeScreen(driver);
		//Login to Vtiger
		
		//Calling from POM
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToPage(UserName, Password);
//		driver.findElement(By.name("user_name")).sendKeys(UserName);  
//		driver.findElement(By.name("user_password")).sendKeys(Password);	
//		driver.findElement(By.id("submitButton")).click();		
		
		//Click on Product Link to create Product First
		
		//Calling the Product link From Home Page POM
				
		HomePage home = new HomePage(driver);
		home.clickProductLink();
			
		//Click on + Link to create a product from ProductPage POM
		ProductPage product = new ProductPage(driver);
		product.createProductLinkClick();
		
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//Getting the random number from Java Utility
		int ranNum = jlib.getRandom();	
		//Fetching the Product Name from Excel Sheet
		String ProductName = elib.getExcelData("Product", 0, 0)+ranNum;
		System.out.println(ProductName);
		
		product.productName(ProductName);
		product.saveButtonClick(driver);
		
		//driver.findElement(By.name("productname")).sendKeys(ProductName);	
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();		
		//Step 1:Creating Campaign and selecting same product
		home.clickCampLink();
		CreateCampaignPage campPage= new CreateCampaignPage(driver);
		campPage.clickOnImg();
		
		
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.linkText("Campaigns")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();	
		//Fetching the Campaign Name from Excel Sheet
		String CampaignName = elib.getExcelData("Campaign", 0, 0)+ranNum;
		System.out.println(CampaignName);	
		
		campPage.campaignsName(CampaignName);
		//driver.findElement(By.name("campaignname")).sendKeys(CampaignName);		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		wlib.switchWindow(driver, "Products&action");

		driver.findElement(By.name("search_text")).sendKeys(ProductName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		System.out.println("2"+ProductName);
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
		 
		wlib.switchWindow(driver, "Campaigns&action");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		//Validation
		String actualData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		if(actualData.contains(CampaignName))
		{
			System.out.println("Validation Pass");
		}
		else
		{
			System.out.println("Validation Failed");
		}

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();	
		driver.findElement(By.linkText("Sign Out")).click();

	}

}

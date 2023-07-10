package allAssignment;

import java.util.concurrent.TimeUnit;

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
import OrganizationPOM.CreateCampaignPage;
import OrganizationPOM.HomePage;
import OrganizationPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign {

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
		int ranNum = jlib.getRandom();
		wlib.implicitWait(driver);
		
		String URL = flib.getStringKeyAndValue("url");
		String UserName = flib.getStringKeyAndValue("username"); 
		String Password = flib.getStringKeyAndValue("password");						
		driver.get(URL);	
		wlib.maximizeScreen(driver);
		//Calling from LOGIN POM
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToPage(UserName, Password);

		HomePage home = new HomePage(driver);
		home.clickCampLink();
		
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.clickOnImg();
		
		//Fetching Data from Excel Sheet using Excel_Utility Generic Class	
		String CampaignName = elib.getExcelData("Campaign", 0, 0)+ranNum;
		System.out.println(CampaignName);	
		//Locating the element and saving data from Campaign POM
		campPage.campaignsName(CampaignName);	
		campPage.saveCamp();
		
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
		
		home.logOut(driver);
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wlib.moveToElement(driver, ele);
//		driver.findElement(By.linkText("Sign Out")).click();
	}

}

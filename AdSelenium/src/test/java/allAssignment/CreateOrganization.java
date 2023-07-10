package allAssignment;

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
import OrganizationPOM.CreateOrganizationPage;
import OrganizationPOM.HomePage;
import OrganizationPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
	
			Webdriver_Utility wlib = new Webdriver_Utility();
			Java_Utility jlib = new Java_Utility();
			Excel_Utility elib = new Excel_Utility();
			//We are calling the method from File_Utility class to Optimzed the code
			File_Utility flib = new File_Utility();	
			
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
			
			//Calling from POM
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginToPage(UserName, Password);
			
			//Calling the Organization link FRom POM
			HomePage homePage = new HomePage(driver);
			homePage.organizationLinkClick();			
	
			//Calling + link from POM calss
			CreateOrganizationPage org = new CreateOrganizationPage(driver);
			org.clickOnImg();
			
			// Calling Random method from Java Utility Class
			int ranNum = jlib.getRandom();
			//Fetching Data from Excel Sheet using Excel_Utility Generic Class			
			String OrganizationName = elib.getExcelData("Organization", 1, 0)+ranNum;
			System.out.println(OrganizationName);			
			String PhoneNo = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);			
			System.out.println(PhoneNo);		
			String EmailId = elib.getExcelDataUsingDataFormatter("Organization", 3, 0);			
			org.orgData(OrganizationName, PhoneNo, EmailId);
			Thread.sleep(3000);	
			//Call the save locator from POM class
			org.clickSaveButton();			
			//Validation
			Thread.sleep(3000);	
			String actualData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
			if(actualData.contains(OrganizationName))
			{
				System.out.println("Validation Pass");
			}
			else
			{
				System.out.println("Validation Failed");
			}
			//Logout
			// Call from POM Class
			homePage.logOut(driver);
	}


}

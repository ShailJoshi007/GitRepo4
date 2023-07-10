package Generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver Sdriver;
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void beforeSuite()
	{
		System.out.println("Database Connection");
	}
	@BeforeTest(groups={"smokeTest","regressionTest"})
	public void beforeTest()
	{
		System.out.println("Parallel Execution");
	}

	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void beforeClass() throws Throwable
	{
		File_Utility flib = new File_Utility();	
		String BROWSER = flib.getStringKeyAndValue("browser");
		//WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new  ChromeDriver();
			System.out.println("Chrome driver got selected");
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
		
		Sdriver = driver;
	}
}

package Practice;

import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_utility.File_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertDataToProperties {

	public static void main(String[] args) throws Throwable {
		Properties pro = new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "https://demo.actitime.com/login.do");
		pro.setProperty("username", "trainee");
		pro.setProperty("pwd", "trainee");
		FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/CommonData.properties");
		pro.store(fout,"Common Data");
		fout.close();
		
		
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
////		driver.get("https://www.amazon.in/");
//		
		File_Utility flib = new File_Utility();
//		//System.out.println("Contact Created");
		String URL = flib.getStringKeyAndValue("url");
		System.out.println(URL);
		String USERNAME = flib.getStringKeyAndValue("username");
		String PASSWORD = flib.getStringKeyAndValue("pwd");
		driver.get(URL);
	//	System.out.println("ContactCreated");
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.id("loginButton")).click();
		

	}

}

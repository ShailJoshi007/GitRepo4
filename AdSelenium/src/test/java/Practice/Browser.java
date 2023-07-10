package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static void main(String[] args) throws Throwable {
		//To test with new Token 
		//WebDriver driver = new ChromeDriver();
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.amazon.in/");
		
		//WebDriverManager.edgedriver().setup();
		//driver = new EdgeDriver();
		driver.get("https://demo.actitime.com/login.do");
		//driver.manage().timeouts().implicitlyWait(0, null);
		//driver.findElement(By.xpath(""));
		FileInputStream fis = new FileInputStream("src\\test\\resources\\PropertyFile1.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String Username = pro.getProperty("username");
		String Pwd = pro.getProperty("pwd");
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.name("pwd")).sendKeys(Pwd);
		driver.findElement(By.id("loginButton")).click();
		
	}

}


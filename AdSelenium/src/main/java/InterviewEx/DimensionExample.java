package InterviewEx;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DimensionExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.get("https://www.amazon.in/");
		Dimension di = new Dimension(200,300);
		driver.manage().window().setSize(di);
		
		Point pt = new Point(300,400);
		driver.manage().window().setPosition(pt);
		
		}

}

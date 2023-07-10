package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SequilliEx {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	    driver.findElement(By.cssSelector("svg[class='gb_h']")).click();
		Screen src = new Screen();
		Pattern play = new Pattern("/Users/shail/eclipse-workspace/AdSelenium/Screenshot 2023-06-29 at 10.58.31 AM.png");
		src.click(play);
		

	}

}

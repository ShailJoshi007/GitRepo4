package Generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

 
public class Webdriver_Utility {
	/**
	 * This method is used to maximize the screen
	 * @param driver
	 */
	public void maximizeScreen(WebDriver driver){
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method is used to minimize the screen
	 * @param driver
	 */
	public void minimizeScreen(WebDriver driver){
		//driver.manage().window().minimize;
		
	}
	/**
	 * Wait for the page to load before identifying any synchronized element in DOM
	 * @param driver
	 */
	public void implicitWait(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	/**
	 * Used to switch to any window based on window Title
	 * @param driver
	 * @param partialText
	 */
	public void switchWindow(WebDriver driver,String partialText){
		 Set<String> allWindows = driver.getWindowHandles();
			Iterator<String> id=  allWindows.iterator();
			
			while(id.hasNext())
			{
				String win = id.next();
				driver.switchTo().window(win);
				String title = driver.getTitle();
				if(title.contains(partialText))
				{
					break;
				}
			}		
	}
	
	/**
	 * Aftwer every action it will wait for next action to perform
	 * @param driver
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	/**
	 * Used to wait for the element to be clickable in GUI and check for specific element for every 500 milliseconds
	 * @param driver
	 * @param element
	 * @param pollingTime
	 */
	public void waitForELementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime){
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to switch to ALertWindow and Accept(Click on OK Button)
	 * @param driver
	 */
	public void switchToAlertAndAccept(WebDriver driver){
		driver.switchTo().alert().accept();;
	}
	
	/**
	 * used to switch to ALertWindow and Dismiss(Click on Cancel Button)
	 * @param driver
	 */
	public void switchToAlertAndDismiss(WebDriver driver){
		driver.switchTo().alert().dismiss();
	}
	
/**
 * used to switch to FrameWindow based on index
 * @param driver
 * @param index
 */
	public void switchToFrame(WebDriver driver,int index){
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to switch to FrameWindow based on id or name attribute
	 * @param driver
	 * @param id_name_Attribute
	 */
		public void switchToFrame(WebDriver driver,String id_name_Attribute){
			driver.switchTo().frame(id_name_Attribute);
		}
		
		/**
		 * Used to select the value from the dropdown based on Index
		 * @param element
		 * @param index
		 */
		public void handleDropDown(WebElement element, int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		
		/**
		 * Used to select the value from the dropdown based on Texta
		 * @param element
		 * @param text
		 */
		public void handleDropDownByText(WebElement element, String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		
		/**
		 * used to place mouse over specified element
		 * @param driver
		 * @param element
		 */
		public void mouseOverOnElement(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		/**
		 * used to right click on specific element
		 * @param driver
		 * @param element
		 */
		public void rightClickOnElement(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		
		public void moveByOffset(WebDriver driver,int x, int y)
		{
			Actions act = new Actions(driver);
			act.moveByOffset(x, y).click().perform();
		}
		
		public void moveToElement(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.moveToElement(element).click().perform();
		}
		/**
		 * This method is used to scrolling
		 * @param driver
		 * @param element
		 */
		public void javaScriptExecutor(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()",element);
		}
		public void alertAccept(WebDriver driver)
		{
			Alert alt = driver.switchTo().alert();
			alt.accept();
		}
		public void alertDismiss(WebDriver driver)
		{
			Alert alt = driver.switchTo().alert();
			alt.dismiss();
		}
		
		
}

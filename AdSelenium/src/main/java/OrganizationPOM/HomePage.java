package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utility.Webdriver_Utility;

public class HomePage {
	//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	//ForSign Out
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrator;
	
	
	//ForSign Out
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOutLink;
		
	//More Link
	@FindBy(xpath="//a[text()='More']")
	private WebElement MoreLink;
		
		//Campaign Link
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement CampaignsLink;	
	
	//Product Link
	@FindBy(linkText="Products")
	private WebElement ProductLink;		

	public WebElement getAdministrator() {
		return Administrator;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}
	public WebElement getProductLink() {
		return ProductLink;
	}
	//Business Logic
	/**
	 * This method is used to click on Organization Link to Create Organization
	 */
	public void organizationLinkClick()
	{
		organizationLink.click();
	}
	/**
	 * This Method is used to Logout from the VTiger APp
	 * @param driver
	 */
	public void logOut(WebDriver driver)
	{
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.moveToElement(driver, Administrator);
//		Actions act = new Actions(driver);
//		act.moveToElement(Administrator).click().perform();
		SignOutLink.click();
	}
	
	public void clickCampLink()
	{
		MoreLink.click();
		CampaignsLink.click();
	}
	
	public void clickProductLink()
	{
		ProductLink.click();
	}
}

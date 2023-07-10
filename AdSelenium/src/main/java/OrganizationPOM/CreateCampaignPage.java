package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	//Initialization
			public CreateCampaignPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			//Click on Plus sign to create Campaign Out
			@FindBy(xpath="//img[@alt='Create Campaign...']")
			private WebElement ClickPlusImg;
			
			@FindBy(name="campaignname")
			private WebElement CampName;
			
			@FindBy(xpath="//input[@title='Save [Alt+S]']")
			private WebElement SaveButton;
			
			@FindBy(name="search_text")
			private WebElement productNameSwitching;
			
			@FindBy(name="search")
			private WebElement productSearchSwitching;

			
			public WebElement getProductNameSwitching() {
				return productNameSwitching;
			}

			public WebElement getProductSearchSwitching() {
				return productSearchSwitching;
			}
			
			public WebElement getClickPlusImg() {
				return ClickPlusImg;
			}

			public WebElement getCampName() {
				return CampName;
			}

			public WebElement getSaveButton() {
				return SaveButton;
			}
			
			//Business Logic
			public void clickOnImg()
			{
				ClickPlusImg.click();
			}
			
			public void campaignsName(String campName)
			{
				CampName.sendKeys(campName);
			}
			
			public void saveCamp()
			{
				SaveButton.click();
			}
			
			public void selectPusButton()
			{
				SaveButton.click();
			}
			
}

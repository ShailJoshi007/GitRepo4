package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement clickImg;
	
	@FindBy(name="accountname")
	private WebElement OrgName;
	
	@FindBy(id="phone")
	private WebElement OrgPhone;
	
	@FindBy(id="email1")
	private WebElement OrgEmail;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//Getter Methods

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getClickImg() {
		return clickImg;
	}

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getOrgPhone() {
		return OrgPhone;
	}

	public WebElement getOrgEmail() {
		return OrgEmail;
	}

	//Business Logic
	/**
	 * This method is used to Click on + sign to Create Organization
	 */
	public void clickOnImg()
	{
		clickImg.click();
	}
	/**
	 * This method is used to pass OrgName, Phone number and Email
	 * @param orgName
	 * @param orgPhone
	 * @param orgEmail
	 */
	public void orgData(String orgName, String orgPhone, String orgEmail)
	{
		OrgName.sendKeys(orgName);
		OrgPhone.sendKeys(orgPhone);
		OrgEmail.sendKeys(orgEmail);
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
}

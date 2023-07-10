package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utility.Webdriver_Utility;

public class ProductPage {
	//Initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement CreateProductLink;
	@FindBy(name="productname")
	private WebElement ProductName;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement ProductSaveButton;

	//Getter Method
	public WebElement getCreateProductLink() {
		return CreateProductLink;
	}
	
	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getProductSaveButton() {
		return ProductSaveButton;
	}

	public void createProductLinkClick()
	{
		CreateProductLink.click();
	}

	public void productName(String prodName)
	{
		ProductName.sendKeys(prodName);
	}
	
	public void saveButtonClick(WebDriver driver)
	{
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.javaScriptExecutor(driver,ProductSaveButton);
		ProductSaveButton.click();
	}
	
}

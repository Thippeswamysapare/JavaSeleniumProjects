package PageObjects;

import java.awt.print.PageFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@type='submit' and @value='checkout']")
	private WebElement checkOutBtn;
	
	@FindBy(xpath="//input[@id='termsofservice' and @type='checkbox']")
	private WebElement termsOfServiceCheckBox;
	
	@FindBy(id="CountryId")
	private WebElement countryIdDropDown;
	
	@FindBy(id="StateProvinceId")
	private WebElement stateNameDropDown;
	
	@FindBy(xpath="//p[text()='Please accept the terms of service before the next step.']")
	private WebElement termsOfServicePopup;
	
	@FindBy(xpath="//div[contains(text(),'Your Shopping Cart is empty!')]")
	private WebElement emptyCardMsg;
	
	public void clickOnTermsOfServiceCheckBox()
	{
		termsOfServiceCheckBox.click();
	}
	public CheckOutPage clickOnCheckOut()
	{
		checkOutBtn.click();
		return new CheckOutPage(driver);
	}
	
	public void clickOnSelectedItemCheckBox(String itemName)
	{
		String xpathExp="//tr[@class='cart-item-row']/td[@class='product']/a[text()='"+itemName+"']/ancestor::td/preceding-sibling::td[2]";
		
		WebElement checkBox=driver.findElement(By.xpath(xpathExp));
		if(checkBox.isDisplayed() && checkBox.isEnabled())
		{
			checkBox.click();
		}
	}
	
	public void selectCountryName(String countryName)
	{
		countryIdDropDown.click();
		Select select=new Select(countryIdDropDown);
		select.selectByVisibleText(countryName);
	}

	public void selectStateName(String stateName)
	{
		stateNameDropDown.click();
		Select select=new Select(stateNameDropDown);
		select.selectByVisibleText(stateName);
	}
	
	public String getTermsOfServicePopupMessage()
	{
		return termsOfServicePopup.getText();
	}
	public WebDriver getCartPageDriver()
	{
		return driver;
	}
	
	public WebElement getEmptyCartMessage()
	{
		return emptyCardMsg;
	}
}

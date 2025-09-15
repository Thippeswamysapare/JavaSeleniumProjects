package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
	public WebDriver driver;
	
	public HomePageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	 @FindBy(xpath="//input[@value='Log out']")
	 WebElement logoutBtn;
	 
	 @FindBy(xpath="//div[@class='content']/h4")
	 WebElement emailIdDisplayed;
	 
	 @FindBy(xpath="//div[@class='content']")
	 WebElement signInAs;
	 
	 @FindBy(xpath="//a[@role='presentation' and text()='Home']")
	 WebElement homeBtn;
	 
	 @FindBy(xpath="//a[text()='Request Quotation']")
	 WebElement requestQuotationBtn;
	 
	 @FindBy(xpath="//a[text()='Retrieve Quotation']")
	 WebElement retireveQuotationBtn;
	
	 @FindBy(xpath="//a[text()='Profile']")
	 WebElement profileBtn;
	 
	@FindBy(xpath="//a[text()='Edit Profile']")
	WebElement editProfileBtn;
	
	public void clickOnHome()
	{
		homeBtn.click();
	}

	public void clickOnRequestQuotation()
	{
		requestQuotationBtn.click();
	}
	
	public void clickOnRetrieveQuotation()
	{
		retireveQuotationBtn.click();
	}
	
	public void clickOnProfile()
	{
		profileBtn.click();
	}
	
	public void clickOnEditProfile()
	{
		editProfileBtn.click();
	}
	
	public void clickOnLogout()
	{
		logoutBtn.click();
	}
	
	public String getLoggedInEmailId()
	{
		return emailIdDisplayed.getText();
		
	}
}

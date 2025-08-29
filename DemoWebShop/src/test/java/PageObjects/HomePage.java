package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	
	@FindBy(xpath="(//a[@class='account'])[1]")
	private WebElement userEmailId;
	
	@FindBy(xpath="//a[text()='Log out']")
	private WebElement logoutButton;
	
	
	public WebElement getLoggedInUserEmail()
	{
		return userEmailId;
		
	}
	
	public LoginPage clickOnLogoutButton()
	{
		logoutButton.click();
		return new LoginPage(driver);
	}
	
	
}

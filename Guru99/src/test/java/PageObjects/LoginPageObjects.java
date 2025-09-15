package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

import UtilityClasses.BaseClass;

public class LoginPageObjects extends BaseClass{
	public WebDriver driver;
	public LoginPageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="email")
	WebElement emailTextBox;
	
	@FindBy(id="password")
	WebElement passwordTextBox;
	
	@FindBy(name="submit")
	WebElement loginBtn;

	@FindBy(xpath="//a[text()='Register']")
	WebElement registerBtn;
	
	@FindBy(xpath="//h3[text()='Login']")
	WebElement loginText;
	
	public void clickOnRegisterBtn()
	{
		registerBtn.click();
	}
	
	public HomePageObjects loginToGuruApp(String username, String password) throws InterruptedException
	{
		
		emailTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		Thread.sleep(2000);
		loginBtn.click();
		Thread.sleep(5000);
		return new HomePageObjects(driver);
	}
}

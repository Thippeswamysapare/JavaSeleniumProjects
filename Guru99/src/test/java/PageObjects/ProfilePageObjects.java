package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProfilePageObjects {
	
	public WebDriver driver;
	
	public ProfilePageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user_title")
	WebElement userTitleDD;
	
	public void selectTitle(String title)
	{
		Select select=new Select(userTitleDD);
		select.selectByVisibleText(title);
		
	}
}

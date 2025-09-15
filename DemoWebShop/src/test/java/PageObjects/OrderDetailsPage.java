package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {
	WebDriver driver;
	public OrderDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h1[text()='Order information']")
	private WebElement orderInfo;
	
	@FindBy(xpath="//div[@class='order-number']/strong")
	private WebElement orderNumber;
	

}

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCompletedPage {
	
	WebDriver driver;
	public OrderCompletedPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath="//div[@class='title']/strong")
	private WebElement orderSuccessmsg;
	
	@FindBy(xpath="//li[contains(text(),'Order number')]")
	private WebElement orderNumber;
	
	@FindBy(xpath="//a[contains(text(),'Click here for order details.')]")
	private WebElement orderDetails;
	
	public String getOrderSuccessMessage()
	{
		return orderSuccessmsg.getText();
	}
	
	public String getOrderNumber()
	{
		return orderNumber.getText();				
	}

	public OrderDetailsPage clickOnOrderDetailsLink()
	{
		orderDetails.getText();
		return new OrderDetailsPage(driver);
	}
}

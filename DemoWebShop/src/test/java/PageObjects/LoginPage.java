package PageObjects;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.utilites.BaseTest;

public class LoginPage extends BaseTest {

	public WebDriver driver;
	public Properties prop = readProperties();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginButton1;

	@FindBy(xpath = "//input[@name='Email']")
	private WebElement Email;

	@FindBy(id = "Password")
	private WebElement userPassword;

	@FindBy(xpath = "//input[@type='submit' and @value='Log in']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerUser;

	public HomePage loginToDemoWebShop(String UserEmail, String password) {
		Email.sendKeys(UserEmail);
		userPassword.sendKeys(password);
		loginButton.click();
		return new HomePage(driver);
	}

	public void clickOnLoginButton() {
		loginButton1.click();
	}

	public RegisterPage clickOnRegister() {
		registerUser.click();
		return new RegisterPage(driver);
	}
}

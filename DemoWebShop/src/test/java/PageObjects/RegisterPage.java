package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='M']")
	private WebElement maleGender;

	@FindBy(xpath = "//input[@value='F']")
	private WebElement femaleGender;

	@FindBy(id = "FirstNameNa")
	private WebElement firstname;

	@FindBy(id = "LastName")
	private WebElement lastname;

	@FindBy(name = "Email")
	private WebElement email;

	@FindBy(name = "ConfirmPassword")
	private WebElement confirmPassword;

	@FindBy(name = "Password")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Register']")
	private WebElement registerButton;
	
	@FindBy(xpath="//span[contains(text(),'First name is required')]")
	private WebElement firstnamerequired;
	
	@FindBy(xpath="//span[contains(text(),'Last name is required')]")
	private WebElement lastnamerequired;
	
	@FindBy(xpath="//span[contains(text(),'Email is required')]")
	private WebElement emailrequired;
	
	@FindBy(xpath="//span[@for='Password']")
	private WebElement passwordrequired;
	
	@FindBy(xpath="//span[@for='ConfirmPassword']")
	private WebElement confirmpasswordrequired;

	public void selectGenderMale() {
		maleGender.click();
	}

	public void selectGenderFemale() {
		femaleGender.click();
	}

	public void enterFirstname(String firstName) {
		firstname.sendKeys(firstName);
	}

	public void enterLastname(String lastName) {
		lastname.sendKeys(lastName);
	}

	public void enterEmail(String Email) {
		email.sendKeys(Email);
	}

	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}

	public void enterConfirmPassword(String confirmpassword) {
		confirmPassword.sendKeys(confirmpassword);
	}

	public void clickOnRegisterBtn() {
		registerButton.click();
	}

	public WebDriver getDrive() {
		return driver;
	}

	public WebElement getFirstName() {
		return firstname;
	}
	
	public String getFNRequiredMsg()
	{
		return firstnamerequired.getText();
	}
	public String getLNRequiredMsg()
	{
		return lastnamerequired.getText();
	}
	
	public String getEmailRequiredMsg()
	{
		return emailrequired.getText();
	}
	
	public String getpassRequiredMsg()
	{
		return passwordrequired.getText();
	}
	public String getCnfmpassRequiredMsg()
	{
		return confirmpasswordrequired.getText();
	}
}

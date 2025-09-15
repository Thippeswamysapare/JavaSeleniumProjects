package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='account'])[1]")
	private WebElement userEmailId;

	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logoutButton;

	@FindBy(xpath = "//div[@class='title']/strong[text()='Categories']")
	private WebElement categoriesSection;

	@FindBy(xpath = "//div[@class='listbox']/ul/li/a[contains(text(),'Bookss')]")
	private WebElement booksLink;

	@FindBy(xpath = "//span[@class='cart-qty']")
	private WebElement cartQuantity;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLinkHomePage;

	public WebElement getLoggedInUserEmail() {
		return userEmailId;

	}

	public LoginPage clickOnLogoutButton() {
		logoutButton.click();
		return new LoginPage(driver);
	}

	public BooksPage clickOnBooksLink() {
		booksLink.click();
		return new BooksPage(driver);
	}

	public int getCartQuantity() {
		String qty = cartQuantity.getText();
		System.out.println("Quantity: " + String.valueOf(qty.charAt(1)));
		return Integer.parseInt(String.valueOf(qty.charAt(1)));

	}

	public CartPage clickOnshoppingCartLinkInHomePage() {
		shoppingCartLinkHomePage.click();
		return new CartPage(driver);
	}

	public WebDriver getHomePageDriver() {
		return driver;

	}
}

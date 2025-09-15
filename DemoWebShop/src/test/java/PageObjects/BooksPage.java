package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BooksPage {

	public WebDriver driver;
	private static String xpathForSelectedProductAddToCart;

	public BooksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "products-orderby")
	private WebElement productsOrderByDD;

	@FindBy(id = "products-viewmode")
	private WebElement productsViewMode;

	@FindBy(id = "products-pagesize")
	private WebElement productsPageSize;

	@FindBy(xpath = "//div[@class='details']/h2/a")
	private List<WebElement> booksProductList;

	@FindBy(xpath = "//span[@class='cart-qty']")
	private WebElement cartQuantity;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLinkInBooksPage;

	public void ClickOnAddToCart(String productName) {
		String dynamicXpath = "//h2[@class='product-title']/a[text()='" + productName
				+ "']/ancestor::div[@class='details']/div[@class='add-info']/div/input";
		WebElement addToCartBtn = driver.findElement(By.xpath(dynamicXpath));
		if (addToCartBtn.isDisplayed() && addToCartBtn.isEnabled()) {
			addToCartBtn.click();

		}

	}

	public int getCartQuantity() {
		String qty = cartQuantity.getText();
		System.out.println("Number of Items in Cart: " + qty.charAt(1));
		return Integer.parseInt(String.valueOf(qty.charAt(1)));
	}

	public CartPage clickOnshoppingCartLinkInBooksPage() {
		shoppingCartLinkInBooksPage.click();
		return new CartPage(driver);
	}

	public void setXpath(String textToBeAddToXpath) {
		xpathForSelectedProductAddToCart = "//h2[@class='product-title']/a[text()='" + textToBeAddToXpath
				+ "']/ancestor::div[@class='details']/div[@class='add-info']/div/input";
	}

	public String getXpath() {
		return xpathForSelectedProductAddToCart;
	}

	public void selectProductOrderBy(String orderByValue) {
		Select select = new Select(productsOrderByDD);
		select.selectByVisibleText(orderByValue);
	}

	public void selectProductsViewMode(String viewByValue) {
		Select select = new Select(productsViewMode);
		select.selectByVisibleText(viewByValue);
	}

	public void selectProductsPageSize(String pageSize) {
		Select select = new Select(productsPageSize);
		select.selectByVisibleText(pageSize);
	}

	public void deSelectProductOrderBy(String orderByValue) {
		Select select = new Select(productsOrderByDD);
		select.deselectByVisibleText(orderByValue);
	}

	public void deSelectProductsViewMode(String viewByValue) {
		Select select = new Select(productsViewMode);
		select.deselectByVisibleText(viewByValue);
	}

	public void deSelectProductsPageSize(String pageSize) {
		Select select = new Select(productsPageSize);
		select.deselectByVisibleText(pageSize);
	}

	public List<String> DisplayBookProductList()

	{
		List<String> bookList = new ArrayList<>();
		for (WebElement ele : booksProductList) {
			bookList.add(ele.getText());
		}
		return bookList;
	}

	public void selectBookFromProductList(String bookName) {
		for (WebElement ele : booksProductList) {
			if (ele.getText().equalsIgnoreCase(bookName)) {
				ele.click();
				break;
			}
		}
	}

	public WebDriver getBookPageDriver() {
		return driver;
	}
}

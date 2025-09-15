package com.shop.grocery;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.shop.utilites.BaseTest;

import PageObjects.BooksPage;
import PageObjects.CartPage;
import PageObjects.HomePage;

public class AddToCartWithoutLogin extends BaseTest {
	HomePage homePage;
	BooksPage booksPage;
	CartPage cartPage;
	Properties prop = readProperties();
	WebDriverWait wait;

	@Test
	public void addBookToCardWithoutLogin() throws InterruptedException {

		test = extent.startTest("Add To Cart Without Login");
		homePage = new HomePage(getDriver());
		test.log(LogStatus.INFO, "user clicks on Books link");
		booksPage = homePage.clickOnBooksLink();
		Thread.sleep(2000);
		JavascriptExecutor jsbooksPage = (JavascriptExecutor) booksPage.getBookPageDriver();
		jsbooksPage.executeScript("window.scrollBy(0,200)");
		booksPage.ClickOnAddToCart(prop.getProperty("bookPage_BookName1"));
		jsbooksPage.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(4000);
		// booksPage.ClickOnAddToCart(browser);
		cartPage = booksPage.clickOnshoppingCartLinkInBooksPage();
		Thread.sleep(4000);
		cartPage.clickOnCheckOut();

	}

}
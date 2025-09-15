package com.shop.grocery;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shop.utilites.BaseTest;
import com.shop.utilites.ExtentReportManager;

import PageObjects.BooksPage;
import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.HomePage;

public class VerifyTermsOfServicePopup extends BaseTest {
	
	HomePage homePage;
	BooksPage booksPage;
	CartPage cartPage;
	CheckOutPage checkoutPage;
	Properties prop;

	@Test
	public void verifyTermsOfServicewhenuserclickOnCheckout() throws InterruptedException {
		test=ExtentReportManager.createTest("verify Terms Of Service when user click On Checkout");
		prop= readProperties();
		homePage= new HomePage(getDriver());
		booksPage=homePage.clickOnBooksLink();
		JavascriptExecutor jsBookPage= (JavascriptExecutor)booksPage.getBookPageDriver();
		jsBookPage.executeScript("window.scrollBy(0,300)");
		//Selecting Book
		booksPage.ClickOnAddToCart(prop.getProperty("bookPage_BookName1"));
		jsBookPage.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(2000);
		cartPage=booksPage.clickOnshoppingCartLinkInBooksPage();
		cartPage.clickOnCheckOut();
		Thread.sleep(2000);
		//String termsOfServiceMsg=cartPage.getTermsOfServicePopupMessage();
		Assert.assertEquals(cartPage.getTermsOfServicePopupMessage(),prop.getProperty("termsOfService"));
		System.out.println("Terms of Service message: " + cartPage.getTermsOfServicePopupMessage());
	}
}

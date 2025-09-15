package com.shop.grocery;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
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
import PageObjects.LoginPage;
import PageObjects.OrderCompletedPage;

public class Orderbooks extends BaseTest {

	BooksPage bookPage;
	HomePage homePage;
	LoginPage loginPage;
	CheckOutPage checkOutPage;
	OrderCompletedPage ordercompletedPage;
	Properties prop;

	@Test
	public void orderBooks() throws InterruptedException {
		
		test=ExtentReportManager.createTest("Test order books scenrios");
		List<String> bookProductList = new ArrayList<>();
		Properties properties = readProperties();
		loginPage = new LoginPage(getDriver());
		CartPage cartPage;
		prop = readProperties();
		//test.info("login to DemoShop");
		loginPage.clickOnLoginButton();
		homePage = loginPage.loginToDemoWebShop(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		System.out.println(homePage.getLoggedInUserEmail().getText());
		// get Cart quantity before adding item to cart
		//test.info("get Cart quantity before adding item to cart");
		int quantity = homePage.getCartQuantity();
		// StringBuilder sb=new StringBuilder();

		System.out.println("Cart quantity before adding item to cart: " + quantity);

		assertEquals(homePage.getLoggedInUserEmail().getText(), prop.getProperty("USERNAME"));
		bookPage = homePage.clickOnBooksLink();
		JavascriptExecutor js = (JavascriptExecutor) bookPage.getBookPageDriver();
		bookPage.selectProductOrderBy(prop.getProperty("bookPage_SoryBy_A2Z"));
		bookProductList = bookPage.DisplayBookProductList();

		for (String list : bookProductList) {
			System.out.println("Book list: " + list);
		}

		// bookPage.selectBookFromProductList("Computing and Internet");

		// click on Add to Card button for computing and Internet
		js.executeScript("window.scrollBy(0,200)");
		bookPage.ClickOnAddToCart(properties.getProperty("bookPage_BookName1"));
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(5000);
		int quantity2 = bookPage.getCartQuantity();
		System.out.println("Cart quantity after adding item to cart: " + quantity2);

		Assert.assertTrue(( quantity2 >  quantity));

		cartPage = bookPage.clickOnshoppingCartLinkInBooksPage();
		JavascriptExecutor js1 = (JavascriptExecutor) cartPage.getCartPageDriver();
		Thread.sleep(2000);
		cartPage.clickOnSelectedItemCheckBox(properties.getProperty("bookPage_BookName1"));
		Thread.sleep(2000);
		js1.executeScript("window.scrollBy(0,400)");
		cartPage.selectCountryName(prop.getProperty("country"));
		Thread.sleep(2000);
		cartPage.selectStateName(prop.getProperty("state"));
		cartPage.clickOnTermsOfServiceCheckBox();
		checkOutPage = cartPage.clickOnCheckOut();
		JavascriptExecutor jsCheckoutPage=(JavascriptExecutor)checkOutPage.getCheckOutPageDriver();
		jsCheckoutPage.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		// Checkout Page - selecting Billing address and shipping Address
		List<String> billingAddressList = checkOutPage.clickOnBillingAddressDropDown();
		int listSize = billingAddressList.size();
		System.out.println("Adress list count+ " + listSize);
		if ((listSize == 1) && billingAddressList.equals(prop.getProperty("billingShippingAddress"))) {
			checkOutPage.SelectBillingAddressByVisitbleText(prop.getProperty("billingShippingAddress"));
			checkOutPage.enterBillingAddressFirstName("");
			checkOutPage.enterBillingAddressLasttName("");
			checkOutPage.enterBillingAddressEmail("");
			checkOutPage.enterBillingAddressCompany("");
			checkOutPage.selectBillingAddressCountry("");
			checkOutPage.selectBillingAddressState("");
			checkOutPage.enterBillingAddressCity("");
			checkOutPage.enterBillingAddressAddress1("");
			checkOutPage.enterBillingAddressAddress2("");
			checkOutPage.enterBillingAddressPostalCode("");
			checkOutPage.enterBillingAddressphoneNumber("");
			checkOutPage.enterBillingAddressfaxNumber("");

		} else {
			checkOutPage.SelectBillingAddressByIndex(1);
		}

		checkOutPage.clickOnContinueInBillinggAddressSection();
		Thread.sleep(2000);
		List<String> shippingAddressList = checkOutPage.clickOnShippingAddressDropDown();
		int billingAddressListSize = shippingAddressList.size();
		System.out.println("Adress list count+ " + billingAddressListSize);
		if ((billingAddressListSize == 1) && shippingAddressList.equals(prop.getProperty("billingShippingAddress"))) {
			checkOutPage.SelectShippingAddressByVisitbleText(prop.getProperty("billingShippingAddress"));
			checkOutPage.enterShippingAddressFirstName("");
			checkOutPage.enterShippingAddressLasttName("");
			checkOutPage.enterShippinggAddressEmail("");
			checkOutPage.enterShippingAddressCompany("");
			checkOutPage.selectShippingAddressCountry("");
			checkOutPage.selectShippingAddressState("");
			checkOutPage.enterShippingAddressCity("");
			checkOutPage.enterShippingAddressAddress1("");
			checkOutPage.enterShippingAddressAddress2("");
			checkOutPage.enterShippingAddressPostalCode("");
			checkOutPage.enterShippingAddressphoneNumber("");
			checkOutPage.enterShippingAddressfaxNumber("");

		} else {
			checkOutPage.SelectShippingAddressByIndex(2);
		}

		Thread.sleep(2000);
		checkOutPage.clickOnContinueInShippingAddressSection();
		checkOutPage.clickOnContinueInShippingMethodSection();
		checkOutPage.clickOnContinueInPaymentMethodSection();
		checkOutPage.clickOnContinueInPaymentInfoSection();
		
		ordercompletedPage=checkOutPage.clickOnConfirmOrderBtn();
		Thread.sleep(2000);
		// Order completed page objects
		String orderMsg=ordercompletedPage.getOrderSuccessMessage();
		Assert.assertEquals(prop.getProperty("orderSuccessMessage"), orderMsg);
		//test.pass("Order succesful");
		System.out.println("Order Number: "+ordercompletedPage.getOrderNumber());
		ordercompletedPage.clickOnOrderDetailsLink();
	}

}

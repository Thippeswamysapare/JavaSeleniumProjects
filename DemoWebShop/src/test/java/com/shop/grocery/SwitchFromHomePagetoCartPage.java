package com.shop.grocery;

import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.shop.utilites.BaseTest; 

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class SwitchFromHomePagetoCartPage extends BaseTest{
	public HomePage homePageObj;
	public CartPage cartPageObj;
	public LoginPage loginPageObj;
	@Test
	public void userClicksOnShoppingCarrLink() throws InterruptedException
	{
		test=extent.startTest("Switch From Home Page to CartPage");
		//test=ExtentReportManager.createTest("Switch From Home Page to CartPage");
		loginPageObj= new LoginPage(getDriver());
		Properties prop=readProperties();
		loginPageObj.clickOnLoginButton();
		homePageObj= loginPageObj.loginToDemoWebShop(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		
		int cartQty=homePageObj.getCartQuantity();
		
		if(cartQty==0)
		{
			test.log(LogStatus.PASS	, "The cart is Empty");
		}
		else {
		cartPageObj= homePageObj.clickOnshoppingCartLinkInHomePage();
		JavascriptExecutor jscart= (JavascriptExecutor)cartPageObj.getCartPageDriver();
		jscart.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		cartPageObj.clickOnCheckOut();
		test.log(LogStatus.PASS, "User switched to Cart Page");
		}
		Thread.sleep(2000);
	}

}

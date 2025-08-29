package com.shop.grocery;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.annotations.Test;

import com.shop.utilites.BaseTest;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class Orderbooks extends BaseTest{



@Test
public void orderBooks() throws InterruptedException
{
	LoginPage loginPage= new LoginPage(getDriver());
	Properties prop= readProperties();
	 
	loginPage.clickOnLoginButton();
	HomePage homePage= loginPage.loginToDemoWebShop(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	Thread.sleep(3000);
	System.out.println(homePage.getLoggedInUserEmail().getText());
	assertEquals(homePage.getLoggedInUserEmail().getText(), prop.getProperty("USERNAME"));
	
	homePage.clickOnLogoutButton();
	Thread.sleep(3000);
}

}

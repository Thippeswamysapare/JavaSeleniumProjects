package com.shop.grocery;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.shop.utilites.BaseTest;
import com.shop.utilites.ExtentReportManager;

import PageObjects.LoginPage;
import PageObjects.RegisterPage;

public class RegisterNewUser extends BaseTest {
	
	Properties prop=readProperties();
	@Test
	public void registerNewUSer() throws Exception
	{
		test=extent.startTest("register New USer");
		String firstName=getFirstName();
		String lastName=getLastName();
		test.log(LogStatus.INFO, "Register user test case execution started");
		LoginPage logPage=new LoginPage(getDriver());
		RegisterPage registerPage= logPage.clickOnRegister();
		registerPage.selectGenderMale();
		registerPage.enterFirstname(firstName);
		JavascriptExecutor js= (JavascriptExecutor)registerPage.getDrive();
		js.executeScript("arguments[0].style.border='3px solid red'", registerPage.getFirstName());
		Thread.sleep(2000);
		registerPage.enterLastname(lastName);
		registerPage.enterEmail(firstName+"_test@gmail.com");
		registerPage.enterPassword(prop.getProperty("registerUserPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("registerUserPassword"));
		Thread.sleep(1000);
		registerPage.clickOnRegisterBtn();
		//ExtentManager.getTest().get().log(LogStatus.PASS, "passed");
	}
}

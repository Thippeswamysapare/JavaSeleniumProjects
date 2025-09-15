package com.shop.grocery;

import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.shop.utilites.BaseTest;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;

public class VerifyMandatoryFieldsInRegistrationPage extends BaseTest {

	Properties prop;
	RegisterPage regPage;

	@Test
	public void verfyingMandatoryFields() throws InterruptedException {
		prop = readProperties();
		LoginPage loginpage = new LoginPage(getDriver());
		test = extent.startTest("Verify Mandatory Fields In Registration Page");
		regPage = loginpage.clickOnRegister();
		regPage.clickOnRegisterBtn();
		Thread.sleep(2000);
		Assert.assertEquals(regPage.getFNRequiredMsg(), prop.getProperty("regPageFNReq"));
		Assert.assertEquals(regPage.getLNRequiredMsg(), prop.getProperty("regPageLNReq"));
		Assert.assertEquals(regPage.getEmailRequiredMsg(), prop.getProperty("regPageEmailReq"));
		Assert.assertEquals(regPage.getpassRequiredMsg(), prop.getProperty("regPagePasswordReq"));
		Assert.assertEquals(regPage.getCnfmpassRequiredMsg(), prop.getProperty("regPageConfirmPasswordReq"));
	}
}

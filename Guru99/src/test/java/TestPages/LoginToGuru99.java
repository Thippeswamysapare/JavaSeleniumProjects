package TestPages;


import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.LoginPageObjects;
import UtilityClasses.BaseClass;

public class LoginToGuru99 extends BaseClass{
	
	Properties props;
	@Test
	public void LoginTest() throws IOException, InterruptedException
	
	{
		props=GetPropertieVaules();
		LoginPageObjects loginPage=new LoginPageObjects(getDriver());
		HomePageObjects homePageObjects;
		homePageObjects= loginPage.loginToGuruApp(props.getProperty("username"),props.getProperty("password"));
		Assert.assertEquals(props.getProperty("username"), homePageObjects.getLoggedInEmailId());
		
	}

}

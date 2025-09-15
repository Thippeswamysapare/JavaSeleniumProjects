package TestPages;

import java.util.Base64;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.LoginPageObjects;
import UtilityClasses.BaseClass;

public class EditProfile extends BaseClass{
	
	public WebDriver driver;
	public Properties prop;
	public HomePageObjects homePageObj;
	@Test
	public void editUserProfile() throws InterruptedException
	{
		prop=GetPropertieVaules();
		LoginPageObjects loginPageObj= new LoginPageObjects(getDriver());
		Thread.sleep(3000);
		 homePageObj= loginPageObj.loginToGuruApp(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		 
		homePageObj.clickOnEditProfile();
		
	}
}

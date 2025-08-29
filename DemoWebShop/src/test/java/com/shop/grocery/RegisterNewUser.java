package com.shop.grocery;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;
import com.shop.utilites.BaseTest;
import com.shop.utilites.ExtentManager;

public class RegisterNewUser extends BaseTest {
	
	@Test
	public void registerNewUSer() throws Exception
	{
		Faker faker= new Faker();
		String firstName= faker.name().firstName();
		ExtentManager.getTest().get().log(LogStatus.INFO, "Test case execution is started....");
		getDriver().findElement(By.xpath("//a[text()='Register']")).click();
		getDriver().findElement(By.xpath("//input[@value='M']")).click();
		getDriver().findElement(By.id("FirstName")).sendKeys(firstName);
		getDriver().findElement(By.id("LastName")).sendKeys(faker.name().lastName());
		getDriver().findElement(By.name("Email")).sendKeys(firstName + "@gmail.com");
		getDriver().findElement(By.name("Password")).sendKeys("Pass@1234");
		getDriver().findElement(By.name("ConfirmPassword")).sendKeys("Pass@1234");
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//input[@value='Register']")).click();
		ExtentManager.getTest().get().log(LogStatus.PASS, "passed");
		
	}

}

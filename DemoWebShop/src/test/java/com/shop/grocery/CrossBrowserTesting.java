package com.shop.grocery;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;
import com.shop.utilites.BaseTest;
import com.shop.utilites.ExtentManager; 

public class CrossBrowserTesting extends BaseTest{
			
	@Test
	public void loginToWebShop() throws Exception 
	{
		
		//System.setProperty("webdirve.chromw.driver", null)
		ExtentManager.getTest().get().log(LogStatus.INFO, "Test case execution is started....");
		getDriver().findElement(By.xpath("//a[@class='ico-login']")).click();
		getDriver().findElement((By.id("Email"))).sendKeys("sapare.thippeswamy@ltimindtree.com");
		getDriver().findElement((By.id("Password"))).sendKeys("R@cclive2020");
		Thread.sleep(3000);
		getDriver().findElement(By.className("login-button")).click();
		getDriver().findElement(By.xpath("//a[text()='Log out']")).click();
		
		ExtentManager.getTest().get().log(LogStatus.PASS, "passed");
	
	}
	
		
}

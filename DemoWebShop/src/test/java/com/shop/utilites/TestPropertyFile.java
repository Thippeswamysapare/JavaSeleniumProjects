package com.shop.utilites;

import java.util.Properties;

import org.testng.annotations.Test;

public class TestPropertyFile extends BaseTest {
	
	@Test
	public static void testPropertyfile()
	{
		Properties prop=readProperties();
		System.out.println("-----" + prop.getProperty("LoginPageEmailField"));
	}

}

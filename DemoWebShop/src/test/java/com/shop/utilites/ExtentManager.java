package com.shop.utilites;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	
private static ExtentReports extent;
private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();;

public static synchronized ExtentReports getInstance()
{
	if(extent ==null)
	{
	extent= new ExtentReports("C:\\Users\\61086862\\eclipse-workspace\\DemoWebShop\\Reports\\report.html", true);
	
	}
	return extent;
	
}


public static ThreadLocal<ExtentTest> getTest()
{
	return test;
}

public static void setTest(ExtentTest extentTest)
{
	test.set(extentTest);
}
}

package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AnnottionsInTestNG {

	
		@BeforeSuite
		public static void beforeSuite()
		{
			System.out.println("This is beforeSuite");
		}
		
		@BeforeTest
		public static void beforeTest()
		{
			System.out.println("This is beforeTest");
		}
		@BeforeClass
		public static void beforeClass()
		{
			System.out.println("This is beforeClass");
		}
		
		@BeforeMethod
		public static void beforeMethod()
		{
			System.out.println("This is BeforeMethod");
		}
		
		
		
		@Test
		public static void testcase1()
		{
			System.out.println("This is test1");
		}
		
		@Test
		public static void testcase2()
		{
			System.out.println("This is test2");
		}
		
		@Test
		public static void testcase3()
		{
			System.out.println("This is test3");
		}
		
		@AfterMethod
		public static void afterMethod()
		{
			System.out.println("This is afterMethod");
		}
		 
		@AfterClass
		public static void afterClass()
		{
			System.out.println("This is afterClass");
		}
		
		@AfterTest
		public static void afterTest()
		{
			System.out.println("This is afterTest");
		}
		
		@AfterSuite
		public static void afterSuite()
		{
			System.out.println("This is afterSuite");
		}
	 
	 
}

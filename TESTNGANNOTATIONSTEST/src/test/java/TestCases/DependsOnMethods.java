package TestCases;

import org.testng.annotations.Test;

public class DependsOnMethods {

	@Test
	public void Test1()
	{
		System.out.println("Test-1");
		int i=10/0;
	}
	
	@Test(dependsOnMethods = "Test1" , alwaysRun = true)
	public void Test2()
	{
		System.out.println("Test-2");
	}
	
	@Test(dependsOnMethods = {"Test1","Test2"})
	public void Test3()
	{
		System.out.println("Test-3");
	}
	
	@Test(dependsOnMethods = "Test2")
	public void Test4()
	{
		System.out.println("Test-4");
	}
}

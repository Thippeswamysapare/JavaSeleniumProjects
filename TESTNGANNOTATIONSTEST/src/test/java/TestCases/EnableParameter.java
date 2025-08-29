package TestCases;

import org.testng.annotations.Test;

public class EnableParameter {
	
	@Test
	public void test1()
	{
		System.out.println("Test-1");
	}
	
	@Test(enabled = false)
	public void test2()
	{
		System.out.println("Test-2");
	}

	@Test
	public void test3()
	{
		System.out.println("Test-3");
	}
	
	@Test(enabled  =true)
	public void test4()
	{
		System.out.println("Test-4");
	}
}

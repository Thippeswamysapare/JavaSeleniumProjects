package TestCases;

import org.testng.annotations.Test;

public class GroupsTest {
	
	@Test(groups = "sanity")
	public void Test1()
	{
		System.out.println("This is Test1");
	}

	@Test(groups = "regression")
	public void Test2()
	{
		System.out.println("This is Test2");
	}

	@Test(groups = {"sanity","regression"} )
	public void Test10()
	{
		System.out.println("This is Test10");
	}
	
	@Test(groups = "sanity")
	public void Test3()
	{
		System.out.println("This is Test3");
	}

	@Test(groups = "regression")
	public void Test4()
	{
		System.out.println("This is Test4");
	}
	
	@Test(groups = "e2e")
	public void Test5()
	{
		System.out.println("This is Test4");
	}

}

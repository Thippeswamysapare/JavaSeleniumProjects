package TestCases;

import org.testng.annotations.Test;

//No priority mentioned, So default priority is 0
public class Priority {
	
	@Test(priority = 1)
	public void abc()
	{
		System.out.println("test1");  
	}
	
	@Test(priority = -1)
	public void xyz()
	{
		System.out.println("test2");  
	}
	
	@Test(priority = 0)
	public void lmn()
	{
		System.out.println("test3");  
	}
	
	@Test(priority = 2)
	public void ghj()
	{
		System.out.println("test4");  
	}
	@Test()
	public void omn()
	{
		System.out.println("test5");  
	}
	 
}

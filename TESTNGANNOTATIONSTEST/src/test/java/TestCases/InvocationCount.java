package TestCases;

import org.testng.annotations.Test;

public class InvocationCount {
	
	@Test
	public void InvocationMethod1()
	{
		System.out.println("Test1");
	}

	@Test(threadPoolSize = 5, invocationCount = 5, timeOut = 1000)
	public void InvocationMethod2()
	{
		System.out.println("Test2");
		System.out.println("Thread name is: "+Thread.currentThread().getName());
	}
}

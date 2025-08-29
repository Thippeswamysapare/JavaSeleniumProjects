package TestCases;

import org.testng.annotations.Test;

public class ParallelExecutionTest2 {
	
	@Test
	public void test5()
	{
		System.out.println("This is test-5");
		System.out.println("Thread name is : "+Thread.currentThread().getName());
	}
	@Test
	public void test6()
	{
		System.out.println("This is test-6");
		System.out.println("Thread name is : "+Thread.currentThread().getName());
	}
	

}

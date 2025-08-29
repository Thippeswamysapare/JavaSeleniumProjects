package TestCases;

import org.testng.annotations.Test;

public class ParallelExecutionTest {
	
	@Test
	public static void Test1()
	{
		System.out.println("This is Test 1");
		System.out.println("Thread name is: " + Thread.currentThread().getName());
		
	}

	@Test
	public static void Test2()
	{
		System.out.println("This is Test 2");
		System.out.println("Thread name is: " + Thread.currentThread().getName());
	}
	
	@Test
	public static void Test3()
	{
		System.out.println("This is Test 3");
		System.out.println("Thread name is: " + Thread.currentThread().getName());
	}
	
	@Test
	public static void Test4()
	{
		System.out.println("This is Test 4");
		System.out.println("Thread name is: " + Thread.currentThread().getName());
	}
}

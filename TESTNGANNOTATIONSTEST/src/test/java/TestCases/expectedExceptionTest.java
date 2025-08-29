package TestCases;

import org.testng.annotations.Test;

public class expectedExceptionTest {
	@Test
	public void exceptionTest1()
	{
		System.out.println("exceptionTest-1");
	}
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void exceptionTest2()
	{
		System.out.println("exceptionTest-2");
		int i=1/0;
	}
	
	@Test
	public void exceptionTest3()
	{
		System.out.println("exceptionTest-3");
	}

}

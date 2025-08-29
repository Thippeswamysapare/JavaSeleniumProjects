package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
	
	@Test
	@Parameters({"username","password"})
	public void displayUserNamePass(String username, String password)
	{
		System.out.println("username is : "+ username);
		System.out.println("password is : "+ password);
	}

	
	
}

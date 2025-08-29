package TestCases;

import org.testng.annotations.Test;

public class DataProviderFromOtherClass {

	@Test(dataProvider = "testdata", dataProviderClass = TestData.class)
	public void getTestDatafromDataProvider(String username,String pass)
	{
		System.out.println("Username:- "+username);
		System.out.println("Username:- "+pass);
	}
}

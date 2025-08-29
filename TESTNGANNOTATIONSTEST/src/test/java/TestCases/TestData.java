package TestCases;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="testdata")
	public Object getData()
	{
		return new Object[][] {{"manu@gmail.com","pass@123"},
							  {"james@yopmail.com","abe@123"}};
	}

}

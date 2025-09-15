package TestCases;

 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	
	@Test(dataProvider = "mytest")
	public void GetDataFromDataProvider(String un, String pwd)
	{
		
		System.out.println("username is : "+un);
		System.out.println("password is : "+pwd);
		org.testng.Reporter.log("this is Data provider class");
	}
	
	@DataProvider(name="mytest")
	public Object[][] data()
	{
		return new Object[][]  {{"Swamy","pass@123"},
								{"abc","pwddddd"},
								{"Tanmayee","Triveni"}
								};
	}
	
	
}

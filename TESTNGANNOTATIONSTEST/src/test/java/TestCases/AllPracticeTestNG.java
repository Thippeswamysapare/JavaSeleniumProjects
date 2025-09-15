package TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AllPracticeTestNG {

@Test(invocationCount = 3)
public void PacticeTest6 ()
{
System.out.println("PacticeTest6- Invocation count");
}

@Test(groups="sanity")
@Parameters({"paramFromXml"})
public void PacticeTest7 (String paramFromXml)
{
System.out.println("PacticeTest7- Parameter from testng.xml file: "+paramFromXml);
}

@Test(dataProvider = "practice", groups="sanity")
public void PacticeTest1(String username, String password)
{
System.out.println("PacticeTest1");	
System.out.println("Data provide details: "+username);
System.out.println("Data provide details: "+password);

}

@Test(dataProvider = "testdata",dataProviderClass = TestData.class,groups="regression")
public void PacticeTest5(String username, String password)
{

System.out.println("PacticeTest5: "+username);
System.out.println("PacticeTest5: "+password);

}

@Test(alwaysRun =true, groups="sanity")
public void PacticeTest3()
{
	System.out.println("PacticeTest3- always run the TC");	
}
	
@Test(priority = -1)
public void PacticeTest2()
{
System.out.println("PacticeTest2");	

}

@Test(enabled=false)
public void PacticeTest4()
{
System.out.println("PacticeTest4- Skipping test case execution");	

}


@DataProvider(name="practice")
public Object[][] getData()
{
	return new Object[][] {{"userone","passone"},{"usertwo","passtwo"}};
	 
}
}

package TestNGListers;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListers.ListenerTest.class)
public class LoginToGuru99 {
	
	WebDriver driver;
	@Test
	public void logintoguru()
	{
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://demo.guru99.com/insurance/v1/index.php");
	JavascriptExecutor js=  (JavascriptExecutor)driver;
	try {
	js.executeScript("document.body.style.zoom='90%'");
	js.executeScript("window.scrollBy(0,100)");
	driver.findElement(By.id("email")).sendKeys("saparethippeswamy@gmail.com");
	driver.findElement(By.id("password")).sendKeys("R@cclive2020");
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.xpath("//input[@value='Log out']")).click();
	
	boolean result=driver.findElement(By.xpath("//h3[text()='Login']")).isDisplayed();
	 
	//Assert.assertEquals(true , result);
	Assert.assertTrue(result);
	}
	catch(Exception e)
	{
		e.getMessage();
	}
	driver.quit();
	
	}
	
	@Test		
	public void TestToFail()				
	{		
	    System.out.println("This method to test fail");					
	    Assert.assertTrue(false);			
	}		
	

}

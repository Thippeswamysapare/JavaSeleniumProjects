package UtilityClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod; 

public class BaseClass {

	public static WebDriver driver;
	public String browserName;
	public WebDriverWait wait;

	public Properties prop;

	@BeforeMethod
	public void setUp() throws IOException
	{
		browserName="chrome";

		switch(browserName)
		{
		case "chrome":	
			driver= new ChromeDriver();
			System.out.println("Launching chrome brower");
			break;
		case "firefox":
			driver=new FirefoxDriver();
			System.out.println("Launching Firefox brower");
			break;

		case "edge":
			driver= new EdgeDriver();
			System.out.println("Launching Edge brower");
			break;
		 }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(GetPropertieVaules().getProperty("url"));	
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='90%'");
		js.executeScript("window.scrollBy(0,100)");
			
	}

	public Properties GetPropertieVaules()  
	{
		prop=new Properties();
		try {
			FileInputStream file= new FileInputStream("testdata.properties");
			prop.load(file);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return prop;
	}

	public WebDriverWait getExplicitWait()
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait;
	}

	public static WebDriver getDriver()
	{
		return driver;
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

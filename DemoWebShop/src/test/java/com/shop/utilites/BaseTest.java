package com.shop.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
 

public class BaseTest {

	//public WebDriver driver;
	//public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	ChromeOptions chromeoptions= new ChromeOptions();
	FirefoxOptions firefoxoptions = new FirefoxOptions();
	EdgeOptions edgeoptions = new  EdgeOptions();
	static Properties props ;
	 
	public static Properties readProperties() 
	{
		props= new Properties();
		try {
		FileInputStream  fis= new FileInputStream("config.properties");
		props.load(fis);
		 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return props;
	}
	 

	//String browser="chrome";
	@Parameters("browser")
	@BeforeTest	
	public void launchBrowser(String browser) throws IOException
	{


		if( browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("Chrome Driver lunnched");
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver());
			 //driver= new ChromeDriver();
		}
		else
			if(browser.equalsIgnoreCase("firefox"))
			{

				System.out.println("FireFox Browser launched");
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
				//driver= new FirefoxDriver();
		}
			else
				if (browser.equalsIgnoreCase("edge"))
				{

					System.out.println("Edge browser launched");
					WebDriverManager.edgedriver().setup();
					DriverManager.setDriver(new EdgeDriver());
					//driver= new EdgeDriver();
				}
	 
		getDriver().manage().window().maximize();
		getDriver().get(readProperties().getProperty("URL"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		//report= new ExtentReports("C:\\Users\\61086862\\eclipse-workspace\\DemoWebShop\\Reports\\report.html", true);
		//test=report.startTest("Test name is ");
//		driver.manage().window().maximize();
//		driver.get("https://demowebshop.tricentis.com");
		 ExtentTest test = ExtentManager.getInstance().startTest("Test on " + browser);
	        ExtentManager.setTest(test);
	}
	

public WebDriver getDriver() {
        return DriverManager.getDriverInstance();
    }
	


@AfterTest
public void teamDown()
{
	DriverManager.quitDriver();
	ExtentManager.getInstance().endTest(ExtentManager.getTest().get());;
	//driver.quit();
	//report.endTest(test);
	//report.flush();
}

@AfterSuite
public void tearDown() {
    ExtentManager.getInstance().flush();
    ExtentManager.getInstance().close();
}

 
}

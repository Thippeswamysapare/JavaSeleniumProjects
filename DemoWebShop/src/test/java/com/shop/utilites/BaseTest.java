package com.shop.utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	// public WebDriver driver;
	// public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	ChromeOptions chromeoptions = new ChromeOptions();
	FirefoxOptions firefoxoptions = new FirefoxOptions();
	EdgeOptions edgeoptions = new EdgeOptions();
	public String browser = "chrome";
	static Properties props;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	public Faker faker;

	public static Properties readProperties() {
		props = new Properties();
		try {
			FileInputStream fis = new FileInputStream("config.properties");
			props.load(fis);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return props;
	}

	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
		
	}

	@AfterSuite
	public void teardownReport() {
		extent.endTest(test);
		extent.flush();
	}

	// @Parameters("browser")
	@BeforeMethod
	public void launchBrowser() throws IOException {
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome browser is lunching");
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver());
			// driver= new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			System.out.println("FireFox browser is lunching");
			WebDriverManager.firefoxdriver().setup();
			DriverManager.setDriver(new FirefoxDriver());
			// driver= new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

			System.out.println("Edge browser is lunching");
			WebDriverManager.edgedriver().setup();
			DriverManager.setDriver(new EdgeDriver());
			// driver= new EdgeDriver();
		}

		getDriver().manage().window().maximize();
		getDriver().get(readProperties().getProperty("URL"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
}

	public WebDriver getDriver() {
		return DriverManager.getDriverInstance();
	}

	public WebDriverWait getWebDriverWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}

//	@AfterTest
//	public void addTestResultToReport(ITestResult result)
//	{
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			String screenshotPath=ExtentReportManager.captureScreenshot(getDriver(), "testFailure");
//			test.fail("Test Failed -screenshot",
//					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//		}
//	}
	@AfterMethod
	public void teamDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ExtentReportManager.captureScreenshot(getDriver());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath) + "Test Failed");
			//Adding error logs to report
			test.log(LogStatus.INFO, result.getThrowable());
			//Adding test case name to defects report
			test.log(LogStatus.INFO, result.getTestName());
			}

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test Pass");
			}
		DriverManager.quitDriver();
	}

	public String getFirstName() {
		faker = new Faker();
		return faker.name().firstName();
	}

	public String getLastName() {
		faker = new Faker();
		return faker.name().lastName();

	}

}

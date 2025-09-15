package com.shop.utilites;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportManager {
	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports getReportInstance() {
		if (extent == null) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String reportPath = "Reports/Extent_report_" + timeStamp + ".html";
			System.out.println("Report Path : " + reportPath);
			//Creating extent report in html format along with time stamp
			extent = new ExtentReports(reportPath, true);
			}
		return extent;
	}

	public static String captureScreenshot(WebDriver driver) {
		try {
			// Create source file for screenshot
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Create destination file to copy screenshot
			File destinationFile = new File(
					System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png");
			System.out.println("path of the screenshot is : " + destinationFile);
			//Getting absolute path of destination file
			String absolutepathOfScreenshot = destinationFile.getAbsolutePath();
			//Copying screenshot(file) to destination file
			FileUtils.copyFile(sourceFile, destinationFile);
			return absolutepathOfScreenshot;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ExtentTest createTest(String testName) {
		test = extent.startTest("Sanity Test");
		return test;
	}

}

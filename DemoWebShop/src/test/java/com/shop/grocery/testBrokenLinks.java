package com.shop.grocery;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testBrokenLinks {

	WebDriver driver;

	@Test
	public void checkBrokenLinkstest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(5000);
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println("Links count= " + links.size());
		
		int brokenLinksCount=0;
		for (WebElement link : links) {

			String url = link.getAttribute("href");
			if (url == null || url.isEmpty())
				continue;

			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
				int respCode = connection.getResponseCode();

				if (respCode >= 400) {
					//System.out.println("Broken link: " + url + " - Code: " + respCode);
					brokenLinksCount ++;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("brokenLinksCount: "+ brokenLinksCount);

		driver.quit();
	}
}

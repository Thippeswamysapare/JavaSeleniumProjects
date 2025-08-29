package com.shop.utilites;

import org.openqa.selenium.WebDriver;

public class DriverManager 
{
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    public DriverManager()
    {
    	
    }

    public static WebDriver getDriverInstance() {
    	return driver.get();
        
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }
    
   
    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}

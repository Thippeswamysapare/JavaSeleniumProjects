package com.shop.utilites;

import org.openqa.selenium.WebDriver;

import jdk.internal.org.jline.utils.Log;

public class DriverManager 
{
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
      public static WebDriver getDriverInstance() {
    	return driver.get();
        
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }
    
   
    public static void quitDriver() {
       if(driver!=null)
       {
    	//Log.info("closing browser.......!");
    	driver.get().quit();
        driver.remove();
       }
    }
}

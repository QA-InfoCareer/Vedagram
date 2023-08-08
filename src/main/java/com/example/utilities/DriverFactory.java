package com.example.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver driver;
	
	 public enum browserType {
	        
		 Chrome,
	     
		 FireFox,
	     
		 IE,     //not implemented
	     
		 SAFARI  //not implemented
	    
	 }
	
	 public static WebDriver getDriver(browserType browser) {
		
		 if(driver == null) {
		            
				 switch (browser) {
		         
				 case Chrome:
		                 
					 ChromeOptions options = new ChromeOptions();

			    	 options.addArguments("--remote-allow-origins=*");
			    		
			    	 options.addArguments("force-device-scale-factor=1.2");
			    	    
					   driver = new ChromeDriver(options);

					   driver.manage().window().maximize();
		                 
		             break;
		                
		         case FireFox:
		                
		             driver = new FirefoxDriver();
		                    
		             break;
		                
		         case IE:
		                    
		             driver = new InternetExplorerDriver();
		                    
		         	 break;
		                
		         default:
		                    
		         	throw new IllegalArgumentException("Invalid browser: " + browser);
		            
				 }
		      
		 }
		 
		 
		 return null; 
	 }
	
}

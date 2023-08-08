package com.example.sample;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.example.utilities.Utility;

public class Sample {

   public static void main (String [] args) throws IOException {
	   
	   WebDriver driver;
	    
	    ChromeOptions options = new ChromeOptions();
	    
		options.addArguments("--remote-allow-origins=*");
		
	    options.addArguments("force-device-scale-factor=1.2");
	    
		 driver = new ChromeDriver(options);	 

		   Utility utility = new Utility(driver);

		 driver.manage().window().maximize();
		 
		 String url = "http://4.224.33.212:8080/vedagram/#/login";
		 
		 driver.get(url);
		 
		 utility.sleep(1000);
		 
		 By signUp = By.xpath("//span[contains(text() ,'Sign Up')]");
		 
		 utility.clickVisibilityOfElementLocated(driver, signUp, 20);
		
		 SearchContext shadow = driver.findElement(By.cssSelector(".placeholder1.md.in-item")).getShadowRoot();

		 shadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();
		 
		 utility.sleep(1000);
		 
		 int user = 2;
		 
		 String userId = String.valueOf(user);		
		 
		 System.out.println("User Id : " + userId);
		 
		 int vendor = 3;
		 
		 String vendorId = String.valueOf(vendor);
		 
		 System.out.println("Vendor id : " + vendorId);
		 
		 WebElement users = driver.findElement(By.xpath("//div[contains(text(),'User')]"));
		 
		 String userText = users.getText();
		 
		 System.out.println("Users Text : " + userText);
		 
		 WebElement vendors = driver.findElement(By.xpath("//div[contains(text(),'Vendor')]"));
		 
		 String vendorText = vendors.getText();
		 
		 System.out.println("Vendors Text : " + vendorText);
		 
		   userId = userText;
		   
		   vendorId = vendorText;
		   
		   System.out.println(userId);
		   
		   System.out.println(vendorId);
		   
		   if(userId.contains("2") || userText.contains("User")) {
			   
			   if(vendorId.contains("3") || vendorText.contains("Vendor")) {
				   
				   vendors.click();
				   
				   By clickOk = By.xpath("//span[contains(text(), 'OK')]");
				   
				   utility.clickVisibilityOfElementLocated(driver, clickOk, 20);
				   
				   By firstName = By.xpath("(//input[@type = 'text'])[1]");
				   
				   utility.sendKeysWithExplicitWait(driver, firstName, "Sekar Selvam", 20);
				   
				   By phoneNum = By.xpath("(//input[@type = 'tel'])");
				   
				   utility.sendKeysWithExplicitWait(driver, phoneNum, "1234509876", 20);
				   
				   By emailId = By.xpath("(//input[@type = 'text'])[2]");
				   
				   utility.sendKeysWithExplicitWait(driver, emailId, "ss@gmail.com", 20);
				   
				   By passKey = By.xpath("(//input[@type = 'password'])[1]");
				   
				   utility.sendKeysWithExplicitWait(driver, passKey, "abc", 20);
				   
				   By confirmPasskey = By.xpath("(//input[@type = 'password'])[2]");
				   
				   utility.sendKeysWithExplicitWait(driver, confirmPasskey, "abc", 20);
				   
				   By clickSignup = By.xpath("//ion-button[@type = 'submit']");
				   
				   utility.clickVisibilityOfElementLocated(driver, clickSignup, 20);
		
				   
				   ///////////// vendor id //////////////
				   
      try {
    	  
 		 String apiUrl = "/user/register";
		   
 		 HttpClient client = HttpClientBuilder.create().build();
 		 
 		 HttpGet request = new HttpGet(apiUrl);
 		 
 		 HttpResponse response = client.execute(request);		 
 		 
 		 String userResponseBody = EntityUtils.toString(response.getEntity());
 		 
 		 String userIds = null;
 		 
 		 try {
 			 
 			userIds = String.valueOf(userResponseBody);
 	 		 
 	 		 System.out.println(userIds);
 			 
 		 } catch (NumberFormatException e) {
 			 
 			 e.getStackTrace();
 			 
 			 System.out.println(e.getMessage());
 		 }    	  
    	  
      } catch (Exception e) {
    	  
    	  e.getStackTrace();
    	  
    	  System.out.println(e.getMessage());
      }
		 
		 

       	  }		 
	   }	   
   }






   }

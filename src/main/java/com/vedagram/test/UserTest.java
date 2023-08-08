package com.vedagram.test;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.vedagram.templeadmin.TempleAdminLogin;
import com.vedagram.user.PoojaOfferings;
import com.vedagram.user.UserLogin;

public class UserTest {

	WebDriver driver;
	
	@Test(priority = 1)
    public void browserLaunch() {
    	
    	 try {
   		  
   		  Properties properties = new Properties();
   			
   			InputStream input = new FileInputStream("config.properties");
   			
   			properties.load(input);
   			
   			String browser = properties.getProperty("browser");
   			
   			System.out.println("The browser is : " + browser);
   			
   			String url = properties.getProperty("url");
   			
   			System.out.println("The url is : " + url);
   			
   			 if(browser.equalsIgnoreCase("chrome")) {
   				 
   				 ChromeOptions options = new ChromeOptions();

   		    		options.addArguments("--remote-allow-origins=*");
   		    		
   		    	    options.addArguments("force-device-scale-factor=1.2");
   		    	    
   					 driver = new ChromeDriver(options);

   					 driver.manage().window().maximize();
   				 
   				if(url.equalsIgnoreCase("http://4.224.33.212:8080/vedagram/#/")) {
   					
   					 driver.get(url);
   					
   				}
   				 
   			 }
   		   
   	  } catch(Exception e) {
   		  
   		  System.out.println(e.getMessage());
   	  }

    }
    
    
     @Test(priority = 2)
     public void userLogin() {
    	
    	 try {
     		
     		if(driver.getCurrentUrl().equals("http://4.224.33.212:8080/vedagram/#/")) {
     			
     			UserLogin userLogin = new UserLogin(driver);
     			
     			 FileInputStream inputStream = new FileInputStream
     					 
     		("D:\\Vedagram-workspace\\Vedagram\\src\\main\\resources\\UserLogin.xlsx");
 			 
     			 Workbook workbook = new XSSFWorkbook(inputStream);
     			 
     			 System.out.println(workbook);
     				 
     				Sheet sheet = workbook.getSheet("Sheet1");
     				
     				System.out.println(sheet);
     				
     	for(int i=1; i<sheet.getLastRowNum(); i++) {
     			 
     		String userName = sheet.getRow(i).getCell(0).toString();
     			 
     		 System.out.println("Temple Admin Username is : " + userName);
     			 
     		String password = sheet.getRow(i).getCell(1).toString();
     			 
     		 System.out.println("The Temple Admin Password is : " + password);
     			 
     		userLogin.loginAction(userName, password);
     		 
     		userLogin.submitLogin();
     		 
     		userLogin.loginValidations();
     			 
     	 }  			
     			
     		}
     		
     	} catch (Exception e) {
     		
     		System.out.println(e.getMessage());
     	}
    	
    }
    	
    
     @Test(priority = 3)
     public void testPoojaOfferings() {
    	  
    	 try {
    		 
    		 PoojaOfferings poojaOfferings = new PoojaOfferings(driver);
    		 
    		 poojaOfferings.addPoojaOfferings();   		 
    		 
    	 } catch (Exception e) {
    		 
    		 e.getStackTrace();
    		 
    		 System.out.println(e.getMessage());
    	 }
    	 
     }
     
     
     
    }



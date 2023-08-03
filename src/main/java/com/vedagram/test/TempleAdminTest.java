package com.vedagram.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vedagram.templeadmin.Facilities;
import com.vedagram.templeadmin.OfferingsandFestival;
import com.vedagram.templeadmin.OrderManagement;
import com.vedagram.templeadmin.Poojalist;
import com.vedagram.templeadmin.ScheduleTimingAndGallery;
import com.vedagram.templeadmin.TempleAdminLogin;
import com.vedagram.templeadmin.TempleManagement;

public class TempleAdminTest {
	
	WebDriver driver;


   @BeforeTest
   public void browserLaunch() throws IOException {
	   
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
				 
				if(url.equalsIgnoreCase("http://4.224.33.212:8080/vedagram/#/login")) {
					
					 driver.get(url);
					
				}
				 
			 }
		   
	  } catch(Exception e) {
		  
		  System.out.println(e.getMessage());
	  }
   }

    @Test(priority = 1)
    public void testLoginTempleAdmin() {
	   
    	try {
    		
    		if(driver.getCurrentUrl().equals("http://4.224.33.212:8080/vedagram/#/login")) {
    			
    			TempleAdminLogin templeAdminLogin = new TempleAdminLogin(driver);
    			
    			 FileInputStream inputStream = new FileInputStream
    					 
    					 ("D:\\Vedagram-workspace\\Vedagram\\src\\main\\resources\\TempleAdminLogin.xlsx");
			 
    			 Workbook workbook = new XSSFWorkbook(inputStream);
    			 
    			 System.out.println(workbook);
    				 
    				Sheet sheet = workbook.getSheet("Sheet1");
    				
    				System.out.println(sheet);
    				
    	      for(int i=1; i<sheet.getLastRowNum(); i++) {
    			 
    		String userName = sheet.getRow(i).getCell(0).toString();
    			 
    		 System.out.println("Temple Admin Username is : " + userName);
    			 
    		String password = sheet.getRow(i).getCell(1).toString();
    			 
    		 System.out.println("The Temple Admin Password is : " + password);
    			 
    		 templeAdminLogin.loginAction(userName, password);
    		 
    		 templeAdminLogin.submitLogin();
    		 
    		 templeAdminLogin.loginValidations();
    			 
    	 }  			
    			
    		}
    		
    	} catch (Exception e) {
    		
    		System.out.println(e.getMessage());
    	}
	   
	   
    }

    
     @Test(priority = 2)
     public void testTempleManagement() {
    	 
    	 try {
    		 
    		 if(driver.getCurrentUrl().equals("http://4.224.33.212:8080/vedagram/#/home")) {
    			 
    	TempleManagement templeManagement = new TempleManagement(driver); 
    	
    	FileInputStream inputStream = new FileInputStream
				 
				 ("D:\\Vedagram-workspace\\Vedagram\\src\\main\\resources\\TempleManagement1.xlsx");
	 
		 Workbook workbook = new XSSFWorkbook(inputStream);
		 
			Sheet sheet = workbook.getSheet("Sheet1");
			
			for(int i=1; i<sheet.getLastRowNum(); i++) {
				
		   String aboutAndHistory = sheet.getRow(i).getCell(0).toString();
		   
		   System.out.println("The Temple About and History : " + aboutAndHistory);
		   
		   String templeName = sheet.getRow(i).getCell(1).toString();
		   
		   System.out.println("The Temple Name is : " + templeName);
		   
		   String villageOrTown = sheet.getRow(i).getCell(2).toString();
		   
		   String shippingAddress = sheet.getRow(i).getCell(3).toString();
		   
		 //  long pincodes = Long.parseLong(sheet.getRow(i).getCell(4).toString());
		 
		   String pinCode = sheet.getRow(i).getCell(4).toString();
		   
		   System.out.println(pinCode);
		   
		   String pincode = null;
		   
		   if(pinCode.length() == 6) {
			   
			   pincode = pinCode;
			   
			   System.out.println(pincode);
		   
		   } else if (pinCode.length() == 7 || pinCode.endsWith(".0")) {
			   
			 pincode =  pinCode.replace(".0", "").toString();
			    
			    System.out.println("The Pincode is : " + pincode);
		   }
		   
		   templeManagement.addTempleManagement(aboutAndHistory, templeName, villageOrTown, 
				   
				   shippingAddress, pincode);		
				
			}
			
    		 }
  	 
    	 } catch (Exception e) {
    		 
    		 e.getStackTrace();
    		 
    		 System.out.println(e.getMessage());
    	 }
		
     }
    
    @Test(priority = 3)
    public void testFacilities() {
    	
    	 try {
    		 
    		 if(driver.getCurrentUrl() != null) {
    			 
    			 Facilities facilities = new Facilities(driver);
    			 
    			 facilities.addFacilities();			 
    			 
    		 }
   	 
    	 } catch (Exception e) {
    		 
    		 System.out.println(e.getMessage());
    	 }
    	
    }
    
      @Test(priority = 4) 
      public void testOfferingsAndSignificanceAndFestivals() {
    	   
    	   try {
    		 
    		 if(driver.getCurrentUrl() != null) {
    			   
    		   OfferingsandFestival offeringsFestival = new OfferingsandFestival(driver);
    			
    		   FileInputStream inputStream = new FileInputStream
    					 
    					 ("D:\\Vedagram-workspace\\Vedagram\\src\\main\\resources\\OfferingsAndFestival.xlsx");
    		 
    			 Workbook workbook = new XSSFWorkbook(inputStream);
    			 
    				Sheet sheet = workbook.getSheet("Sheet1");
    				
    			for(int i=1; i<sheet.getLastRowNum(); i++) {
    				
    			String offeringName = sheet.getRow(i).getCell(0).toString();
    			
    			System.out.println("The Offering Name is : " + offeringName);
    			
    			String offeringSignificance = sheet.getRow(i).getCell(1).toString();
    			
    			System.out.println("The Offering Significance is : " + offeringSignificance);
    			
    			String festivalName = sheet.getRow(i).getCell(2).toString();
    			
    			System.out.println("The Festival Name is : " + festivalName);
    			
    			String festivalSignificance = sheet.getRow(i).getCell(3).toString();
    			
    			System.out.println("The Festival Significance is : " + festivalSignificance);
    				
    			 	offeringsFestival.addOfferingsAndFestivals(offeringName, offeringSignificance, 
    			 			
    			 			festivalName, festivalSignificance);
    			 	  			
    			}
    			   
    			   
    			   
    		   }
    		   
    		       		   
    	   } catch (Exception e) {
    		   
    		   e.getStackTrace();
    		   
    		   System.out.println(e.getMessage());
    	   }
    	   
       }

     @Test(priority = 5)
     public void testPoojaAndLists() {
    	 
    	 try {
    		 
    	 if(driver.getCurrentUrl() != null) {
    			 
    		 Poojalist poojaList = new Poojalist(driver);
    
    		  FileInputStream inputStream = new FileInputStream
 					 
 					 ("D:\\Vedagram-workspace\\Vedagram\\src\\main\\resources\\Poojalist.xlsx");
 		 
 			 Workbook workbook = new XSSFWorkbook(inputStream);
 			 
 				Sheet sheet = workbook.getSheet("Sheet1");
 				
 			 for(int i=1; i<sheet.getLastRowNum(); i++) {
 				 
 				 String poojaName = sheet.getRow(i).getCell(0).toString();
 				 
 				 System.out.println("The Pooja Name is : " + poojaName);

 				 String poojaPrice = sheet.getRow(i).getCell(1).toString();
 				 
 				 System.out.println("The Pooja price is : " + poojaPrice);
 				 
 				 String poojaDescription = sheet.getRow(i).getCell(2).toString();
 				 
 				 System.out.println("The Pooja Desciption is : " + poojaDescription);
 				 
 				 String poojaTimings = sheet.getRow(i).getCell(3).toString();
 				 
 				 System.out.println("The Pooja Timings is : " + poojaTimings);
 				 
 				poojaList.addPoojalist(poojaName, poojaPrice, 
 						
 						poojaDescription, poojaTimings);
 				 
 			 }
    			 
    			 
    		 }
    		 
    		 
    	 } catch (Exception e) {
    		 
    		 e.getStackTrace();
    		 
    		 System.out.println(e.getMessage());
    	 }
    	 
     }
     
     @Test(priority = 6)
     public void testScheduleTimingsAndGallery() {
    	 
    	 try {
    		 
    		 if(driver.getCurrentUrl() != null) {
    			 
    			 ScheduleTimingAndGallery scheduleTiming = new ScheduleTimingAndGallery(driver);

       		  FileInputStream inputStream = new FileInputStream
    					 
    					 ("D:\\Vedagram-workspace\\Vedagram\\src\\main\\resources\\ScheduleAndTimings.xlsx");
    		 
    			 Workbook workbook = new XSSFWorkbook(inputStream);
    			 
    				Sheet sheet = workbook.getSheet("Sheet1");
    				
    		 for(int i=1; i<sheet.getLastRowNum(); i++) {
    			 
    			 String morningDarshan = sheet.getRow(i).getCell(0).toString();
    			 
    			 System.out.println("The Morning Darshan is : " + morningDarshan);
    			 
    			 String eveningDarshan = sheet.getRow(i).getCell(1).toString();
    			 
    			 System.out.println("The Evening Darshan is : " + eveningDarshan);
    			 
    			 String timeRequired = sheet.getRow(i).getCell(2).toString();
    			 
    			 System.out.println("The Required Time is : " + timeRequired);

    			 String templeCloseingTime = sheet.getRow(i).getCell(3).toString();
    			 
    			 System.out.println("The Temple Closing Time is : " + templeCloseingTime);
    			 
    			 String dressMen = sheet.getRow(i).getCell(4).toString();
    			 
    			 System.out.println("The Dress code for men : " + dressMen);
    			 
    			 String dressWomen = sheet.getRow(i).getCell(5).toString();
    			 
    			 System.out.println("The Dress code for women : " + dressWomen);
    			 
    			 scheduleTiming.addScheduleAndTimings(morningDarshan, eveningDarshan, timeRequired, 
    					 
    					 templeCloseingTime, dressMen, dressWomen);
    			 
    		 }
 			 
   		 }
    		 
    		 
    	 } catch (Exception e) {
    		 
    		 e.getStackTrace();
    		 
    		 System.out.println(e.getMessage());
    	 }
    	 
     }
     
      @Test(priority = 7)
      public void testOrderManagement() {
    	  
    	  try {
    		  
    		  OrderManagement orderManagement = new OrderManagement(driver);
    		  
    		  orderManagement.addOrderManagement();   		  
    		  
    	  } catch (Exception e) {
    		  
    		  e.getStackTrace();
    		  
    		  System.out.println(e.getMessage());
    	  }
    	  
      }
      
      
  }

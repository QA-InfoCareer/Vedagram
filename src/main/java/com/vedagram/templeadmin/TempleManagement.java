package com.vedagram.templeadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.utilities.Utility;

public class TempleManagement {

	 public static WebDriver driver;
	 
   // it clicks in Temple Management
   By Templemanagement = By.xpath("//span[@class='inactive-tab'][normalize-space()='Temple Management']");

   // it clicks add temple btn
   By Addtemple = By.xpath("//ion-button[@class='addDeityBtnCls md button button-solid ion-activatable ion-focusable']");

   // enter about and history of temple
   By Aboutandhistory = By.xpath("//textarea[@name = 'ion-textarea-0']");
 
   // enter temple name
   By Templename = By.xpath("//textarea[@name='ion-textarea-1']");

   // enter village or town
   By VillageorTown = By.xpath("(//input[@type = 'text'])[1]"); //
  
   By State = By.xpath("(//input[@type = 'text'])[2]");
   
   // district dropdown
   By District = By.xpath("(//input[@type = 'text'])[3]");
   
   // enter shipping address is temple adress 
   By Shippingaddress = By.xpath("(//textarea[@name='ion-textarea-2'])[1]");
   
   // enter pincode
   By Pincode = By.xpath("//input[@type = 'number']");
   
   By Submit = By.xpath("//ion-button[text() = 'Submit']");
   
  
   public TempleManagement(WebDriver driver) {
   	
   	this.driver = driver;
   	
   	PageFactory.initElements(driver, this);
   	
   } 
   
    public String addTempleManagement(String aboutHistory, String templeName, String villageTown
    		
    		, String shippingAddress, String pinCode) throws InterruptedException {
	   
	   Utility utility = new Utility(driver);
	   
	   utility.clickVisibilityOfElementLocated(driver, Templemanagement, 20);
	   
	   utility.clickVisibilityOfElementLocated(driver, Addtemple, 20);
	   
	   utility.sleep(1000);
	   
	   utility.sendKeysWithExplicitWait(driver, Aboutandhistory, aboutHistory, 20);
	   
	   utility.sleep(1000);
	   
	   utility.sendKeysWithExplicitWait(driver, Templename, templeName, 20);
	   
	   utility.sendKeysWithExplicitWait(driver, VillageorTown, villageTown, 20);
	   
	   utility.clickVisibilityOfElementLocated(driver, State, 20);
	  
	   utility.sendKeysWithExplicitWait(driver, State, "Tamil", 20);
	  
	  List<WebElement> states = driver.findElements(By.tagName("div"));
	  
	  Actions actions = new Actions(driver);
  	
	   	 if(states.size() > 0) {
	   		 
	   		 for(WebElement element : states) {
	   			 
	   			 String texts = element.getText();
	   			 
	   			 if(texts.equals("TAMIL NADU")) {
	   		   	
	   		         actions.sendKeys(Keys.TAB).build().perform();
	   		         
	   				 break;
	   			 }
	   		 }
	   	 }
	   	 
	  utility.clickVisibilityOfElementLocated(driver, District, 10);
	
	  utility.sendKeysWithExplicitWait(driver, District, "Chenn", 20);
			 
      List<WebElement> district = driver.findElements(By.tagName("div"));
		   
	      if(district.size() > 0) {
		     	 
		     	 for(WebElement element : district) {
		     		 
		     		 String text = element.getText();
		     		 
		     		 if(text.equals("CHENNAI")) {
		     			 
		     			 utility.sleep(1500);
		     			 
		     			 actions.sendKeys(Keys.TAB).build().perform();
		     		
		     			 break;
		     	    } 
		     	 } 
		      }	   
	
	  actions.sendKeys(Keys.PAGE_DOWN).build().perform();    
	      
     utility.sendKeysWithExplicitWait(driver, Shippingaddress, shippingAddress, 20);
   
     utility.sendKeysWithExplicitWait(driver, Pincode, pinCode, 20);
     
     actions.sendKeys(Keys.PAGE_UP).build().perform();
     
	   return "Success";
    }
   
  }

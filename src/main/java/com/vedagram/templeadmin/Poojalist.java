package com.vedagram.templeadmin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.example.utilities.Utility;

public class Poojalist {

	WebDriver driver;
	
	 By Templemanagement = By.xpath("//span[@class='inactive-tab'][normalize-space()='Temple Management']");

	 // it clicks add temple btn
	 By Addtemple = By.xpath("//ion-button[@class='addDeityBtnCls md button button-solid ion-activatable ion-focusable']");
	
	// it clicks on poojalist
	By ClickPoojalist = By.xpath("//ion-button[@id='4']");
	
	// enter pooja name
	By PoojaName = By.xpath("//input[@placeholder='Pooja Name']");
	
	// enter price
	By PoojaPrice = By.xpath("//input[@placeholder='Price']");
	
	// enter description
	By PoojaDescription = By.xpath("//input[@placeholder='Description']");
	
	// enter timings
	By PoojaTimings = By.xpath("//input[@placeholder='Timings']");
	
	// Deity dropdown
	By Deity = By.cssSelector("#ion-sel-2-lbl");
	
	// it clicks on Aerial view
	By ClickAerialview = By.xpath("//ion-button[@id='5']");
	
	// enter temple address map link here
	By TempleAddresslink = By.xpath("//textarea[@placeholder='Please enter temple address map link here']");
	
	public Poojalist(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	  public String addPoojalist(String poojaName, String poojaPrice, String poojaDescription, 
			  
			  String poojaTimings) {
		
		try {
			
			Utility utility = new Utility(driver);
			
			String addressLink = "https://www.google.com/maps/place/Perumal+Temple/@9.9137576,78.1110043,17z/data=!3m1!4b1!4m6!3m5!1s0x3b00c5803366e22b:0xe9901b668e7b5f11!8m2!3d9.9137523!4d78.1135792!16s%2Fg%2F11b6gf_95l?entry=ttu";
	  		
			utility.sleep(1000);
			
			utility.clickVisibilityOfElementLocated(driver, ClickPoojalist, 20);
			
			utility.sendKeysWithExplicitWait(driver, PoojaName, poojaName, 20);
			
			utility.sendKeysWithExplicitWait(driver, PoojaPrice, poojaPrice, 20);
			
			utility.sendKeysWithExplicitWait(driver, PoojaDescription, poojaDescription, 20);
			
			utility.sendKeysWithExplicitWait(driver, PoojaTimings, poojaTimings, 20);
		 
		////////// Deity
		
		 String cssSelectorForHost61 = "ion-select[placeholder='Select Deity']";

		 SearchContext deityShadow = driver.findElement(By.cssSelector("ion-select[placeholder='Select Deity']")).getShadowRoot();
		 
		 deityShadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();
	
		 utility.sleep(500);
		 
		 /// click dropDown values 
		 
		 String cssSelectorForHost1 = "body > div:nth-child(1) > ion-app:nth-child(2) > ion-popover:nth-child(5) > ion-select-popover:nth-child(1) > ion-list:nth-child(1) > ion-radio-group:nth-child(1) > ion-item:nth-child(7) > ion-radio:nth-child(2)";

		 SearchContext shadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > ion-popover:nth-child(5) > ion-select-popover:nth-child(1) > ion-list:nth-child(1) > ion-radio-group:nth-child(1) > ion-item:nth-child(7) > ion-radio:nth-child(2)")).getShadowRoot();

	List<WebElement> tags = driver.findElements(By.tagName("ion-label"));
	
	List<String> list = new ArrayList<String>();
	
	  if(tags.size() > 0) {
		  
		  for(WebElement element : tags) {
			  
			  String text = element.getText();
			  
			  System.out.println(text);
			  
			  list.add(text);
			  
			   if(text.equals("Hanuman")) {
				  
				   Actions actions = new Actions(driver);
				   
				   utility.sleep(500);
				   
				   actions.click(element).build().perform();
				   
				   break;
			   }
			 
		  }		  
	  }
	  
	  ////////////////// Aerial View
	  
	    utility.sleep(1000);
		 
	    utility.clickVisibilityOfElementLocated(driver, ClickAerialview, 20);
			
		utility.sendKeysWithExplicitWait(driver, TempleAddresslink, addressLink, 20);
			
		} catch (Exception e) {
			
			e.getStackTrace();
			
			System.out.println(e.getMessage());
		}
	
		return null;
	 }
	
	
	
}

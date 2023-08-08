package com.vedagram.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.utilities.Utility;

public class PoojaOfferings {

	WebDriver driver;
	
  // it clicks on Pooja Offerings
  By PoojaOfferings = By.xpath("(//span[contains (text(), 'Pooja Offerings')])[2]");
	
  // it clicks on search btn
  By SearchtBtn = By.xpath("//ion-button[@type = 'submit']");
	
  // it clicks on Perumal Temple
  By SelectTemple = By.xpath("//td[contains(text() ,'Perumal Temple')]");
  
  // it clicks on Book now btn
  By BookNowBtn = By.xpath("//ion-button[contains(.,'Book Now')]");
	
  // enter your name
  By Name = By.xpath("(//input[@type = 'text'])[1]");
  
  // enter your star
  By Star = By.xpath("(//input[@type = 'text'])[2]");
  
  // enter no of months in digits
  By NoOfMonths = By.xpath("(//input[@type = 'number'])[2]");
  
  // enter dakshnina amount
  By DakshinaAmount = By.xpath("(//input[@type = 'number'])[3]");
  
  // it clicks on proceed
  By ProceedBtn = By.xpath("//ion-button[contains (text(), 'Proceed')]");
  
  // it clicks on proceed to payment btn
  By PaymentProceesBtn = By.xpath("//ion-button[normalize-space()='Proceed to Payment']");
  
   public PoojaOfferings(WebDriver driver) {
	   
	   this.driver = driver;
	   
	   PageFactory.initElements(driver, this);
   }


    public String addPoojaOfferings() {
    	
    	try {
    		
    		Utility utility = new Utility(driver);
    		
    		utility.clickVisibilityOfElementLocated(driver, PoojaOfferings, 20);
    		
    		// Click hanuman
    		String cssSelectorForHost1 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(2) > ion-row:nth-child(2) > ion-col:nth-child(7) > ion-img:nth-child(1)";
    		
    		utility.sleep(1000);
    		
    		SearchContext hanumanShadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(2) > ion-row:nth-child(2) > ion-col:nth-child(7) > ion-img:nth-child(1)")).getShadowRoot();

    		utility.sleep(1000);
    		
    		hanumanShadow.findElement(By.cssSelector("img[decoding='async']")).click();
    		
    		utility.sleep(1000);
    		
    		utility.clickVisibilityOfElementLocated(driver, SearchtBtn, 20);
    		
    		utility.clickVisibilityOfElementLocated(driver, SelectTemple, 20);
    		
    		utility.clickVisibilityOfElementLocated(driver, BookNowBtn, 20);
    		
    		utility.sendKeysWithExplicitWait(driver, Name, "Siva", 20);
    		
    		utility.sendKeysWithExplicitWait(driver, Star, "Settai", 20);
    		
    	// Prasadam Delivery Radio btn it clicks on "Yes"
    		
    	String cssSelectorForHost01 = "ion-radio[value='true']";

    	SearchContext prasadamShadow = driver.findElement(By.cssSelector("ion-radio[value='true']")).getShadowRoot();

    	utility.sleep(700);
    	
    	prasadamShadow.findElement(By.cssSelector("label[for*='ion-rb-']")).click();    	
    	
    	// Same as profile checkbox
    	
    	String cssSelectorForHost41 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(3) > ion-col:nth-child(1) > div:nth-child(5) > ion-row:nth-child(3) > ion-col:nth-child(1) > ion-checkbox:nth-child(1)";

    	SearchContext sameAsProfileShadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(3) > ion-col:nth-child(1) > div:nth-child(5) > ion-row:nth-child(3) > ion-col:nth-child(1) > ion-checkbox:nth-child(1)")).getShadowRoot();

    	utility.sleep(700);

    	sameAsProfileShadow.findElement(By.cssSelector("label[for*='ion-cb-']")).click();
    	
    	////// Monthly Radio btn
    	
    	String cssSelectorForHost61 = "ion-radio[value='2']";

    	SearchContext monthlyShadow = driver.findElement(By.cssSelector("ion-radio[value='2']")).getShadowRoot();

    	utility.sleep(700);
    	
    	monthlyShadow.findElement(By.cssSelector("label[for*='ion-rb-']")).click();
    	
    	driver.findElement(NoOfMonths).clear();
    	
    	utility.sendKeysWithExplicitWait(driver, NoOfMonths, "1", 20);
    	
    	//Pay Dakshina Directly to the priest
    	
    	String cssSelectorForHost11 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(3) > ion-col:nth-child(2) > ion-row:nth-child(3) > ion-col:nth-child(1) > ion-checkbox:nth-child(1)";

    	SearchContext payDakshinaShadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(3) > ion-col:nth-child(2) > ion-row:nth-child(3) > ion-col:nth-child(1) > ion-checkbox:nth-child(1)")).getShadowRoot();

    	payDakshinaShadow.findElement(By.cssSelector("label[for*='ion-cb-']")).click();
    	
    	utility.sendKeysWithExplicitWait(driver, DakshinaAmount, "150", 20);
    	
    	utility.clickVisibilityOfElementLocated(driver, ProceedBtn, 20);
    	
    	utility.sleep(1000);
    	
        /////// Proceed to Payment
		
        utility.clickVisibilityOfElementLocated(driver, PaymentProceesBtn, 20);
        
        utility.sleep(4000);
 	
        String currentTitle = driver.getTitle();
        
        if(currentTitle.equals("Vedagram")) {
        	
        	Utility.navigateBack();
        	
        	utility.sleep(1000);
        	
        	Utility.navigateBack();
        	
        	utility.sleep(1000);
        	
        	Alert alert = driver.switchTo().alert();
        	  
        	String msg = alert.getText();
        	
        	if(msg.equals("Payment Failed")) {
        		
        		alert.accept();
        		
        		System.out.println();
        		
        		System.out.println("The message is : " + msg);
        	}       	        	  
          }
        
    	} catch(Exception e) {
    		
    		e.getStackTrace();
    		
    		System.out.println(e.getMessage());
    	}   	
    	
    	return null;
    }






   }

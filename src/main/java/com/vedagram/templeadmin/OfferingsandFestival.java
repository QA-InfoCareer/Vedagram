package com.vedagram.templeadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.example.utilities.Utility;

public class OfferingsandFestival {

	WebDriver driver;
	
	By Templemanagement = By.xpath("//span[@class='inactive-tab'][normalize-space()='Temple Management']");

	// it clicks add temple btn
	By Addtemple = By.xpath("//ion-button[@class='addDeityBtnCls md button button-solid ion-activatable ion-focusable']");
	
	// it clicks on offering and significance
	By Offering = By.xpath("//ion-button[@id='2']");
	
	// enter offering name
	By OfferingName = By.xpath("//textarea[@name='ion-textarea-3']");
	
	// enter offering significance
	By OfferingSignificance = By.xpath("//textarea[@name='ion-textarea-4']");
	
	// it clicks on festivals
	By ClickFestival = By.xpath("//ion-button[@id='3']");
	
	// enter festival name
	By FestivalName = By.xpath("//textarea[@name='ion-textarea-5']");
	
	// enter festival significance
	By FestivalSignificance = By.xpath("//textarea[@name='ion-textarea-6']");
	
	
	public OfferingsandFestival(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String addOfferingsAndFestivals(String offeringName, String offeringSignificance, String festivalName, 
			
			String festivalSignificance) {
		
		try {
			
			    /////////// Offerings and Significance ///////////
			
			Utility utility = new Utility(driver);
			
			utility.sleep(1000);
			
			utility.clickVisibilityOfElementLocated(driver, Offering, 20);
			
			utility.sendKeysWithExplicitWait(driver, OfferingName, offeringName, 20);
			
			utility.sendKeysWithExplicitWait(driver, OfferingSignificance, offeringSignificance, 20);
			
			     /////////////// Festivals /////////////
			
			utility.sleep(1000);
			
			utility.clickVisibilityOfElementLocated(driver, ClickFestival, 20);
			
			utility.sendKeysWithExplicitWait(driver, FestivalName, festivalName, 20);
			
			utility.sendKeysWithExplicitWait(driver, FestivalSignificance, festivalSignificance, 20);
		
		} catch (Exception e) {
			
			e.getStackTrace();
			
			System.out.println(e.getMessage());
		}
		
		return null;
	
	}
	
	
	
	
	
	
	
	
	
	





  }

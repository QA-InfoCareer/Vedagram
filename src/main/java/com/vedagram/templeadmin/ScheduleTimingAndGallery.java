package com.vedagram.templeadmin;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.example.utility.Utility;

public class ScheduleTimingAndGallery {

	WebDriver driver;
	
	 By Templemanagement = By.xpath("//span[@class='inactive-tab'][normalize-space()='Temple Management']");

	 // it clicks add temple btn
	 By Addtemple = By.xpath("//ion-button[@class='addDeityBtnCls md button button-solid ion-activatable ion-focusable']");
	
	// it clicks on Schedule Timing
	By ScheduleTiming = By.xpath("(//ion-button[@id='6'])[1]");
	
	// enter morning darshan
	By MorningDarshan = By.xpath("(//input[@type = 'text'])[1]");
	
	// enter evening darshan
	By EveningDarshan = By.xpath("(//input[@type = 'text'])[2]");
	
	// enter time required
	By TimeRequired = By.xpath("(//input[@type = 'text'])[3]");
	
	// enter closing time
	By TempleClosingTime = By.xpath("(//input[@type = 'text'])[4]");
	
	// it clicks on Fee Details Dropdown
	By FeesDetails = By.cssSelector("");
	
	// it selects Fee Details Dropdown value
	By FeeDetailsValue = By.xpath("//div[text() = 'Entry Fee']");
	
	// enter dress code
	By DressCodeMen = By.xpath("//input[@placeholder = 'Men']");
	
	By ClickOk = By.xpath("//span[contains(text(),'OK')]");
	
	// enter dress code women
	By DressCodeWomen = By.xpath("//input[@placeholder = 'Women']");
	
	// it clicks on Gallery
	By clickGallery = By.xpath("//ion-button[@id='7']");
	
	// uploadimage
	By ChooseFile = By.xpath("//input[@type = 'file']");
	
	// enter video name
	By VideoName = By.xpath("(//input[@type = 'text'])[1]");
	
	// enter video link
	By VideoLink = By.xpath("(//input[@type = 'text'])[2]");
	
	// Global save btn
	By GlobalSaveBtn = By.xpath("//ion-button[contains (text(), 'Submit')]");
	
	public ScheduleTimingAndGallery(WebDriver driver) {
		
		 this.driver = driver;
		 
		 PageFactory.initElements(driver, this);
	}
	
	
	public String addScheduleAndTimings(String morningDarshan, String eveningDarshan, 
			
			String timeRequired, String templeClosingTime, String men, String women) {
		
		try {

			Actions actions = new Actions(driver);
			
			Utility utility = new Utility(driver);
			
			utility.clickVisibilityOfElementLocated(driver, ScheduleTiming, 20);
			
			utility.sendKeysWithExplicitWait(driver, MorningDarshan, morningDarshan, 10);
			
			utility.sendKeysWithExplicitWait(driver, EveningDarshan, eveningDarshan, 10);

			utility.sendKeysWithExplicitWait(driver, TimeRequired, timeRequired, 10);
			
			utility.sendKeysWithExplicitWait(driver, TempleClosingTime, templeClosingTime, 10);
			
			String cssSelectorForHost1 = "ion-select[placeholder='Select Fee']";

			SearchContext shadow = driver.findElement(By.cssSelector("ion-select[placeholder='Select Fee']")).getShadowRoot();

			utility.delay(1000);

			shadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();
			
			utility.clickVisibilityOfElementLocated(driver, FeeDetailsValue, 20);
			
			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20);
			
			utility.sendKeysWithExplicitWait(driver, DressCodeMen, men, 10);
			
			utility.sendKeysWithExplicitWait(driver, DressCodeWomen, women, 0);
			
	    /////////////// Gallery /////////////// 
			
	    String chooseFile = "C:\\Users\\DELL\\Downloads\\Perumal.jpg";
	
	    String videoName = "ஆதிஜெகன்னாத பெருமாள் கோவில் திருப்புல்லாணி | Thiruppullani Adi Jagannatha Perumal Temple";
	    
	    String videoLink = "https://youtu.be/0FBQiqVway4";
	    
	    utility.sleep(1000);
	    
		utility.clickVisibilityOfElementLocated(driver, clickGallery, 10);
		
		utility.sendKeysWithExplicitWait(driver, ChooseFile, chooseFile, 10);
		
		utility.sendKeysWithExplicitWait(driver, VideoName, videoName, 10);
		
		utility.sendKeysWithExplicitWait(driver, VideoLink, videoLink, 10);
		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		// Global save btn
		
		utility.clickVisibilityOfElementLocated(driver, GlobalSaveBtn, 20);
	         
		} catch (Exception e) {
			
			e.getStackTrace();
			
			System.out.println(e.getMessage());
		}
	
		return null;
	}
	
	
	
}

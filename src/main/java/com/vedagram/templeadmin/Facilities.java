package com.vedagram.templeadmin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.utilities.Utility;

public class Facilities {

	WebDriver driver;

	By Templemanagement = By.xpath("//span[@class='inactive-tab'][normalize-space()='Temple Management']");

	// it clicks add temple btn
	By Addtemple = By
			.xpath("//ion-button[@class='addDeityBtnCls md button button-solid ion-activatable ion-focusable']");

	// it clicks on Facilities
	By Facilities = By.xpath("//ion-button[contains (text(), 'Facilities')]");

	// enter parking lot
	By ParkingLot = By.xpath("//input[@type = 'number']");

	// it clicks Security dropdown
	By Security = By.cssSelector("#ion-sel-11-lbl");

	// it selects Yes
	By ClickYes = By.xpath("//div[contains(text(),'Yes')]");

	// it selects No
	By ClikNo = By.xpath("(//div[contains(text(),'No')])");

	// it clicks Ok for AFTER selecting dropdown value
	By ClickOk = By.xpath("//span[contains(text(),'OK')]");

	// it clicks Restrooms dropdown
	By Restrooms = By.cssSelector("#ion-sel-2-lbl");

	// it clicks Cloak counter dropdown
	By Cloakcounters = By.cssSelector(" #ion-sel-3-lbl");

	// it clicks Pooja Provision dropdown
	By PoojaProvisions = By.cssSelector("#ion-sel-4-lbl");

	// it clicks Cab or Auto Availability dropdown
	By CabOrAutoAvailability = By.cssSelector("#ion-sel-5-lbl");

	// enter auditorium name
	By Auditorium = By.xpath("(//input[@type = 'text'])[1]");

	// enter shop
	By Shop = By.xpath("//input[@name='ion-input-4']");

	// it clicks Car dropdown
	By Car = By.cssSelector("#ion-sel-6-lbl");

	// it clicks Bus dropdown
	By Bus = By.cssSelector("#ion-sel-7-lbl");

	// it clciks Train dropdown
	By Train = By.cssSelector("#ion-sel-8-lbl");

	// it clicks Flight dropdown
	By Flight = By.cssSelector("#ion-sel-9-lbl");

	By Submit1 = By.xpath("(//ion-button[normalize-space()='Submit'])[1]");

	public Facilities(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public String addFacilities() {

		try {

			Utility utility = new Utility(driver);
			
			utility.sleep(1000);

			utility.clickVisibilityOfElementLocated(driver, Facilities, 20);

			utility.sendKeysWithExplicitWait(driver, ParkingLot, "1", 20);

			
			/////////// Security //////////
			
			// This Element is inside single shadow DOM.
			String cssSelectorForHost91 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(2) > ion-select:nth-child(1)";

			SearchContext securityShadow = driver.findElement(By.cssSelector(
					"body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(2) > ion-select:nth-child(1)"))
					.getShadowRoot();

			utility.delay(1000);

			WebElement securityClick = securityShadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']"));

			securityClick.click();

			utility.clickVisibilityOfElementLocated(driver, ClickYes, 20);

			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20);

			/////////// Restroom ///////////
			
			//This Element is inside single shadow DOM.
			String cssSelectorForHost11 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(3) > ion-col:nth-child(2) > ion-select:nth-child(1)";
			
			SearchContext restroomShadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(3) > ion-col:nth-child(2) > ion-select:nth-child(1)")).getShadowRoot();
			
			utility.delay(1000);
			
			restroomShadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();

			utility.delay(1000);
			
			utility.clickVisibilityOfElementLocated(driver, ClickYes, 20);

			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20);
			
			////////// Cloak Counters

			//This Element is inside single shadow DOM.
			String cssSelectorForHost3 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(4) > ion-col:nth-child(2) > ion-select:nth-child(1)";

			SearchContext cloakCountersshadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(4) > ion-col:nth-child(2) > ion-select:nth-child(1)")).getShadowRoot();

			utility.delay(1000);

			cloakCountersshadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();

			utility.delay(1000);
			
			utility.clickVisibilityOfElementLocated(driver, ClikNo, 20);

			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20);

			//////// PoojaProvisions
			
			//This Element is inside single shadow DOM.
			String cssSelectorForHost4 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(5) > ion-col:nth-child(2) > ion-select:nth-child(1)";

			SearchContext poojaProvisionsshadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(5) > ion-col:nth-child(2) > ion-select:nth-child(1)")).getShadowRoot();

			utility.delay(1000);

			poojaProvisionsshadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();

			utility.delay(1000);
			
			utility.clickVisibilityOfElementLocated(driver, ClickYes, 20);

			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20);
			
			////////// Cab or Auto Availability

			//This Element is inside single shadow DOM.
			String cssSelectorForHost5 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(6) > ion-col:nth-child(2) > ion-select:nth-child(1)";
			
			SearchContext cabShadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(6) > ion-col:nth-child(2) > ion-select:nth-child(1)")).getShadowRoot();
			
			utility.delay(1000);
			
			cabShadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();

			utility.delay(1000);
			
			utility.clickVisibilityOfElementLocated(driver, ClickYes, 20);

			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20) ;
			
	        utility.sendKeysWithExplicitWait(driver, Auditorium, "1", 20);

			utility.sendKeysWithExplicitWait(driver, Shop, "1", 20);

			//////////// Car
			
			//This Element is inside single shadow DOM.
			String cssSelectorForHost6 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(3) > ion-col:nth-child(2) > ion-select:nth-child(1)";
			
			SearchContext carShadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(3) > ion-col:nth-child(2) > ion-select:nth-child(1)")).getShadowRoot();
			
			utility.delay(1000);
			
			carShadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();
			
			utility.delay(1000);

			utility.clickVisibilityOfElementLocated(driver, ClickYes, 20);

			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20);
			
			/////////// Bus
			
			//This Element is inside single shadow DOM.
			String cssSelectorForHost111 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(4) > ion-col:nth-child(2) > ion-select:nth-child(1)";

			SearchContext busShadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(4) > ion-col:nth-child(2) > ion-select:nth-child(1)")).getShadowRoot();

			utility.delay(1000);

			busShadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();

			utility.clickVisibilityOfElementLocated(driver, ClickYes, 20);

			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20);

			//////// Train
			
			//This Element is inside single shadow DOM.
			String cssSelectorForHost21 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(5) > ion-col:nth-child(2) > ion-select:nth-child(1)";

			SearchContext trainShadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(5) > ion-col:nth-child(2) > ion-select:nth-child(1)")).getShadowRoot();

			utility.delay(1000);

			trainShadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();

			utility.clickVisibilityOfElementLocated(driver, ClikNo, 20);

			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20);

			///////// Flight
			
			//This Element is inside single shadow DOM.
			String cssSelectorForHost15 = "body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(6) > ion-col:nth-child(2) > ion-select:nth-child(1)";
			
			SearchContext flightShadow = driver.findElement(By.cssSelector("body > div:nth-child(1) > ion-app:nth-child(2) > div:nth-child(4) > ion-content:nth-child(1) > div:nth-child(1) > ion-content:nth-child(1) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(2) > ion-col:nth-child(3) > div:nth-child(1) > ion-grid:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(2) > ion-grid:nth-child(1) > ion-row:nth-child(6) > ion-col:nth-child(2) > ion-select:nth-child(1)")).getShadowRoot();
			
			utility.delay(1000);
			
			flightShadow.findElement(By.cssSelector("[id^='ion-sel-'][id$='-lbl']")).click();

			utility.clickVisibilityOfElementLocated(driver, ClikNo, 20);

			utility.clickVisibilityOfElementLocated(driver, ClickOk, 20);
			
			System.out.println("Shadow element success");

		} catch (Exception e) {

			e.getStackTrace();

			System.out.println(e);
		}

		return "Success";

	}

}

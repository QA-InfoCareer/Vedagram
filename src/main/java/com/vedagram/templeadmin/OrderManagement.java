package com.vedagram.templeadmin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.utilities.Utility;

public class OrderManagement {

	WebDriver driver;
	
	// it clicks on Order Management
	By OrderManagement = By.xpath("(//span[ contains(text(), 'Order Management') ])[2]");
	
	// it clicks on Manage Order 1st
	By ManageOrders = By.xpath("(//ion-text[@class='manageorderbtn md'][normalize-space()='Manage Orders'])[1]");
	
	// it clicks on manage 1st
	By Manage = By.xpath("(//ion-button[@size='small'][normalize-space()='Manage'])[2]");
	
	// enter shipment date
	By shipmentDate = By.xpath("(//input[@type = 'date'])[1]");
	
	// enter shipment time
	By ShipmentTime = By.xpath("(//input[@type = 'time'])[1]");
	
	// it clicks on initiate payment
	By InitiateShipment = By.xpath("//ion-button[text()='Initiate Shipment']");
	
	// it clicks on choose file
	By ChooseFile = By.xpath("(//input[@type='file'])[1]");
	
	// it uploads you chosen file
	By Upload = By.xpath("(//ion-button[text()='Upload'])[1]");
	
      public OrderManagement(WebDriver driver) {
		
		  this.driver = driver;
		
		  PageFactory.initElements(driver, this);
	  }
	
	
	  public String addOrderManagement() {
		
		try {
			
			Utility utility = new Utility(driver);
			
			utility.clickVisibilityOfElementLocated(driver, OrderManagement, 20);
			
			utility.clickVisibilityOfElementLocated(driver, ManageOrders, 20);
			
			utility.clickVisibilityOfElementLocated(driver, Manage, 20);
			
			utility.clickVisibilityOfElementLocated(driver, shipmentDate, 20);
			
			String dateScript = "var dateInput = document.querySelector('input[type=\"date\"]'); " + "dateInput.value = '2023-07-29';";
	        
			((JavascriptExecutor) driver).executeScript(dateScript);
			
			utility.sleep(1000);
			
			WebElement shipmentTime = driver.findElement(By.xpath("(//input[@type = 'time'])[1]"));
			
			String timeValue = "04:20 PM";
			
			  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		       
			  jsExecutor.executeScript("arguments[0].removeAttribute('readonly');", shipmentTime);
		      
			  jsExecutor.executeScript("arguments[0].setAttribute('value', arguments[1]);", shipmentTime, timeValue);
		      
			  jsExecutor.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", shipmentTime);
			
			  String actualValue = shipmentTime.getAttribute("value");
			  
			  System.out.println("Time value : " + actualValue);
			
			String timeScript = "var timeInput = document.querySelector('input[type=\"time\"]'); " + "timeInput.value = '04:01 PM';";
			
			((JavascriptExecutor) driver).executeScript(timeScript);
			
		}  catch (Exception e) {
			
			e.getStackTrace();
			
			System.out.println(e.getMessage());
		}
		
		
		  return null;
	  }
	
	
	
	
	
	
	
}

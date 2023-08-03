package com.vedagram.templeadmin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TempleAdminLogin {

 public static WebDriver driver;
 
    @FindBy(xpath = "//input[@type = 'text']")
    private WebElement username;
 
    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement password;
 
    @FindBy(xpath = "//ion-button[@type='submit']")
    private WebElement submitBtn;
 
    public TempleAdminLogin(WebDriver driver) {
    	
    	TempleAdminLogin.driver = driver;
    	
    	PageFactory.initElements(driver, this);
    	
    } 

    public void loginAction(String userName, String passKey) {
    	
    	username.sendKeys(userName);
    	
    	password.sendKeys(passKey);
   	
    }
    
    public void submitLogin() {
    	
    	submitBtn.click();
    }


    public boolean loginValidations() {
    	
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    	
    WebElement logIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Welcome')]"))); // Replace with appropriate locator and condition
    	
     Dimension isLoggedIn = logIn.getSize();  
    	
    	if(isLoggedIn.getHeight() > 0 && isLoggedIn.getWidth() > 0) {
    		
    		System.out.println("Login Success - The Temple Admin is in Home Page");
    	
    	} else {
    		
    		System.out.println("Login Failed - The Temple Admin is in Login Page");
    	}
    		
    	return true;
    }

 
}

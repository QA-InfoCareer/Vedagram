package com.example.utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

    private static WebDriver driver;
	
	private static final int TIMEOUT_SECONDS = 15;
	
	private static WebDriverWait wait;
	
	
	public Utility(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public static void closeDriver() {
       
		if (driver != null) {
        
			driver.quit();
            
			driver = null;
        }
    }

   public static void navigateToURL(String url) {
  
	  driver.get(url);
   }

  public static WebElement findElement(By locator) {
   
	 return driver.findElement(locator);
  }

  public static List<WebElement> findElements(By locator) {
    
	 return driver.findElements(locator);
  }

  public static void sendKeys(By locator, String text) {
   
	 findElement(locator).sendKeys(text);
  }

  public static void clear(By locator) {
    
	 findElement(locator).clear();
  }

  public static String getText(By locator) {
    
	return findElement(locator).getText();
  }

  public static boolean isDisplayed(By locator) {
    
	return findElement(locator).isDisplayed();
  }

  public static boolean isEnabled(By locator) {
   
	return findElement(locator).isEnabled();
  }

  public static boolean isSelected(By locator) {
   
	return findElement(locator).isSelected();
  
  }
  
  public static void navigateBack() {
      
	  driver.navigate().back();
  }
  
  public void clickElementWithActions(WebDriver driver, By element2) {
      
	  WebElement element = driver.findElement(element2);
      
	  Actions actions = new Actions(driver);
      
	  actions.click(element).perform();
  }


  public void delay(int milliseconds) {
 
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(milliseconds));
     
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    
  }   


    public void clickElement(WebDriver driver, By locator) {
   
	  WebElement element = driver.findElement(locator);
    
	  element.click();
   } 



    public void setImplicitWait(int seconds) {
       
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_SECONDS));
   
    }


  public void clickVisibilityOfElementLocated(WebDriver driver, By locator, int i) {
	
	WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
	
	WebElement element2 = driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
	element2.click();
  }


 public void sendKeysWithExplicitWait(WebDriver driver, By locator, String text, int timeoutInSeconds) {
       
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
     
	 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
     
	 element.sendKeys(text);
    
  }


  public void clickElementIfPresent(WebDriver driver, String valueToMatch) {
        
	 List<WebElement> elements = driver.findElements(By.tagName("li"));

        for (WebElement element : elements) {
            
        	String elementText = element.getText();

            if (elementText.equalsIgnoreCase(valueToMatch)) {

            	element.click();
                
            	break;
            }
        }
    }
  
  
  public void clickRandomElementByTagName(WebDriver driver, String tagName) {
      
		 List<WebElement> elements = driver.findElements(By.tagName(tagName));

	        if (elements.size() > 0) {

	        	List<String> values = new ArrayList<>();

	            for (WebElement element : elements) {

	            	String text = element.getText();
	                
	            	System.out.println(text);
	             
	            	values.add(text);
	            }

	            Random random = new Random();

	            int randomIndex = random.nextInt(values.size());
	            
	            System.out.println(randomIndex);

	            WebElement webElement = elements.get(randomIndex);

	            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	            
	            jsExecutor.executeScript("arguments[0].click();", webElement);
	        }
	    }

  public static void waitForElementToBeClickable(By locator, Duration timeoutInSeconds) {
      
  	WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
      
  	wait.until(ExpectedConditions.elementToBeClickable(locator));
  }
  
  public WebElement waitForElementClickable(WebElement locator, Duration second) {
	
	  WebDriverWait wait = new WebDriverWait(driver, second);
	  
	  return wait.until(ExpectedConditions.elementToBeClickable(locator));
	  
  }
  
  public WebElement waitForVisibilityOfWebElement(WebDriver driver, WebElement element) {
     
  	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
      
  	return wait.until(ExpectedConditions.visibilityOf(element));
  	
  }  
  
  public void sleep(long milliseconds) {
      
	  try {
      
		  Thread.sleep(milliseconds);
      
	  } catch (InterruptedException e) {
         
          e.printStackTrace();
      }
  
   }
  
  public void highlightElement(WebDriver driver, WebElement element) {
      // Execute JavaScript to apply the highlight style to the element
      ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');",
              element);

      // Wait for a short time to make the highlight visible (optional)
      try {
          Thread.sleep(500);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      // Reset the element's style to its original state after a short delay (optional)
      ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', '');",
              element);
  }
  
  
  
  
  
  
  
  
  }
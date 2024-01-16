package com.mobileframework.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {
	
	
	//***********
		AppiumDriver driver;//This is a global variable which will be initialize on constructor
		
		//Create constructor of the class sent IOSDriver as parameter 
		//to initialize driver when class is instaciated
		public AppiumUtils(AppiumDriver driver){
			this.driver = driver;//This refer to class variable 'driver'  
		}
	
	public Double getFormattedAmount(String amount){
		Double price = Double.parseDouble(amount.substring(1));
		System.out.println(price);
		return price;
	}
	
	public void waitForElement(WebElement element){	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
	//Wait until element is present as maximum 10 second and stored as a WebElement
		
	
	
}

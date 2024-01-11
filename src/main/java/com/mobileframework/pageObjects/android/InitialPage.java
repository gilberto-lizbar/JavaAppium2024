package com.mobileframework.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobileframework.utils.AndroidActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//public class InitialPage {
public class InitialPage extends AndroidActions {	//extends android actions to includes gestures methods
	
	//***********
	AppiumDriver driver;//This is a global variable which will be initialize on constructor
	
	//Create constructor of the class sent AndroidDriver as parameter 
	//to initialize driver when class is instaciated
	public InitialPage(AppiumDriver driver){
		super(driver);// user driver from android actions
		this.driver = driver;//This refer to class variable 'driver'  
		//Page Factory class to make use of page objects
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//Initialize
		
	}
	
	//***********
	
	

	/* WebElement preferences =
	 driver.findElement(AppiumBy.accessibilityId("Preference"));*/

	// ******Locators***********
	// Declare a WebElement using Page Factory

	@AndroidFindBy(accessibility = "Preference")
	private WebElement preferenceButton;

	@AndroidFindBy(xpath = "//*[@text='Views']")
	private WebElement viewButton;

	// ******Action Methods***********
	public void clickPreferenceButton() {
		preferenceButton.click();
	}

	public void clickViewButton() {
		viewButton.click();
	}

}

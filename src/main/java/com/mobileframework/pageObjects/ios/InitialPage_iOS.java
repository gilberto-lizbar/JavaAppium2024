package com.mobileframework.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobileframework.utils.IOSActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

//public class InitialPage {
public class InitialPage_iOS extends IOSActions {	//extends ios actions to includes gestures methods
	
	//***********
	AppiumDriver driver;//This is a global variable which will be initialize on constructor
	
	//Create constructor of the class sent IOSDriver as parameter 
	//to initialize driver when class is instaciated
	public InitialPage_iOS(AppiumDriver driver){
		super(driver);// user driver from android actions
		this.driver = driver;//This refer to class variable 'driver'  
		//Page Factory class to make use of page objects
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//Initialize
		
	}
	
	/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//Wait until element is present as maximum 10 second and stored as a WebElement
	WebElement alertViewsButton = wait.until(ExpectedConditions
			.presenceOfElementLocated(AppiumBy.accessibilityId("Alert Views")));
	alertViewsButton.click();*/

	// ******Locators***********
		// Declare a WebElement using Page Factory
	@iOSXCUITFindBy(accessibility = "Alert Views")
	private WebElement alertViewsButton;

	// ******Action Methods***********
	public void clickAlertViewButton() {
		alertViewsButton.click();
	}

}

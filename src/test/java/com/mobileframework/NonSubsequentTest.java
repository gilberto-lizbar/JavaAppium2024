package com.mobileframework;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobileframework.TestUtils.BaseClass1;
import com.mobileframework.pageObjects.android.InitialPage;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

public class NonSubsequentTest extends BaseClass1 {
	
	//InitialPage initialPage = new InitialPage(driver);
		InitialPage initialPage;
		
		
		@BeforeMethod
		public void presetup(){
			Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.ApiDemos");
			//driver.startActivity(activity);
			((StartsActivity) driver).startActivity(activity);
			initialPage = new InitialPage(driver);
		}
		
		@Test

		public void initialTest() {

			//InitialPage initialPage = new InitialPage(driver);
			initialPage.clickViewButton();
			initialPage.scrollDownToVisibleElement("Picker");
		}
		
		@Test
		public void secondTest() {
			//InitialPage initialPage = new InitialPage(driver);
			initialPage.clickViewButton();
			initialPage.scrollDownToVisibleElement("Picker");
			driver.findElement(By.xpath("//android.widget.Button[2]")).click();
		}
		
		@Test

		public void thirdTest() {
			//InitialPage initialPage = new InitialPage(driver);
			initialPage.clickViewButton();
			initialPage.scrollDownToVisibleElement("Picker");
		}
		
	

}

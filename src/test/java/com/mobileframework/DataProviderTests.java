package com.mobileframework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.mobileframework.TestUtils.BaseClass1;
import com.mobileframework.pageObjects.android.InitialPage;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

public class DataProviderTests extends BaseClass1 {
	
		InitialPage initialPage;
		
		
		
		@BeforeMethod
		public void presetup(){
			Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.ApiDemos");
			((StartsActivity) driver).startActivity(activity);
			initialPage = new InitialPage(driver);
		}
		
		@Test

		public void nodataProviderTest() {

			initialPage.clickViewButton();
			initialPage.scrollDownToVisibleElement("TextFields");
			initialPage.typeTextFields(0, "Gilberto");
			initialPage.typeTextFields(1, "Tests");
			initialPage.typeTextFields(2, "Other Test");
		}
		
		@Test(dataProvider="getData")//Indicate test method will use data Provider

		public void dataProviderTest(String field1, String field2, String field3) {

			initialPage.clickViewButton();
			initialPage.scrollDownToVisibleElement("TextFields");
			initialPage.typeTextFields(0, field1);
			initialPage.typeTextFields(1, field2);
			initialPage.typeTextFields(2, field3);
		}
		
		/*Add Data Provider annotation and create a bidimensional array
		to store values*/
		@DataProvider()
		public Object getData(){
			return new Object[][] {{"DataProvider1","DataProvider2","DataProvider3"}};
		}
		
		
}

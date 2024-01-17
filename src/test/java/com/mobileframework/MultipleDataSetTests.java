package com.mobileframework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.mobileframework.TestUtils.BaseClass1;
import com.mobileframework.pageObjects.android.InitialPage;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

public class MultipleDataSetTests extends BaseClass1 {
	
		InitialPage initialPage;
		
		
		
		@BeforeMethod
		public void presetup(){
			initialPage = new InitialPage(driver);
			initialPage.setActivity();
		}
		
		@Test(dataProvider="getData")//Indicate test method will use data Provider
	
		public void dataProviderTest(String field1, String field2, String field3) {
			initialPage.clickViewButton();
			initialPage.scrollDownToVisibleElement("TextFields");
			initialPage.typeTextFields(0, "test");
			initialPage.typeTextFields(1, "ddas");
			initialPage.typeTextFields(2, "dfds");
		}
		
		/*Add Data Provider annotation and create a bidimensional array
		to store values*/
		@DataProvider()
		public Object getData(){
			return new Object[][] {{"Gilberto","Test","Another"},
				{"DataProvider1","DataProvider2","DataProvider3"}};
		}
				
}

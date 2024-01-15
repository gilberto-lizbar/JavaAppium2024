package com.mobileframework;

import org.testng.annotations.Test;

import com.mobileframework.TestUtils.BaseClass1;
import com.mobileframework.pageObjects.android.InitialPage;

//public class InitialTests{
public class InitialTests extends BaseClass1{
	
	@Test

	public void initialTest1() {

		InitialPage initialPage = new InitialPage(driver);
		initialPage.clickViewButton();
		initialPage.scrollDownToVisibleElement("Picker");
	}
	
}

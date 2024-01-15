package com.mobileframework;

import org.testng.annotations.Test;

import com.mobileframework.TestUtils.BaseClass1;
import com.mobileframework.pageObjects.ios.InitialPage_iOS;

public class InitialTests_iOS extends BaseClass1 {
	
	@Test
	public void firstTest_iOS(){
		InitialPage_iOS firstPage = new InitialPage_iOS(driver);
		firstPage.clickAlertViewButton();
	}
	
	@Test
	public void secondTest_iOS(){
		InitialPage_iOS firstPage = new InitialPage_iOS(driver);
		firstPage.clickAlertViewButton();
	}
	

}

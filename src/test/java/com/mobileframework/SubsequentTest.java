package com.mobileframework;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mobileframework.TestUtils.BaseClass1;
import com.mobileframework.pageObjects.android.InitialPage;

public class SubsequentTest extends BaseClass1{
	
	/* *******To run subsequent test cases by initializing the Object only 1 time from BaseClass
	   add this variable: 'public InitialPage initialPage;' and initialize
	'initialPage = new InitialPage(driver);' and remove the instances of the object from each test */
	
	
	@Test

	public void initialTest() {
		InitialPage initialPage = new InitialPage(driver);//comment if you want to initialize this on BaseClass
		initialPage.clickViewButton();
	}
	
	@Test
	public void secondTest() {
		InitialPage initialPage = new InitialPage(driver);//comment if you want to initialize this on BaseClass
		initialPage.scrollDownToVisibleElement("Picker");
		
	}
	
	@Test

	public void thirdTest() {
		driver.findElement(By.xpath("//android.widget.Button[2]")).click();
	}

}

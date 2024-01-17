package com.mobileframework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {

	// ***********
	// AppiumDriver driver;//This is a global variable which will be initialize on
	// constructor

	// Create constructor of the class sent IOSDriver as parameter
	// to initialize driver when class is instaciated
	/*
	 * public AppiumUtils(AppiumDriver driver){ this.driver = driver;//This refer to
	 * class variable 'driver' }
	 */

	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		System.out.println(price);
		return price;
	}

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		// System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//testData//eCommerce.json"
		// conver json file content to json string

		/*
		 * String jsonContent = FileUtils.readFileToString(new
		 * File(System.getProperty("user.dir")
		 * +"/src/test/java/com/mobileframework/TestData/sample.json"));
		 */

		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

	public void waitForElement(WebElement element, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait until element is present as maximum 10 second and stored as a WebElement

}

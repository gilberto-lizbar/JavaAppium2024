package com.mobileframework.TestUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AndroidBase {

		private static final String APP = "/Users/gilberto.barraza/Desktop/MobileAutomation/MobileProject/"
				+ "JavaAppium2024/AppiumFramework/src/test/java/com/mobileframework/Resources/ApiDemos-debug.apk";
	private static final int PORT = 4723;
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass // Appium is started before Tests class

	// Start Appium Server and driver
	public void configureAppium() throws MalformedURLException {
		// code to start the server
		// Android driver, iOS Driver
		// Appium Code>Appium Server>Mobile

		AppiumDriverLocalService service =  new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
				.usingPort(PORT).build();
		service.start();
		
		DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_5_API_29");
		 caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		 caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		 caps.setCapability("app", APP);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	}

	@AfterClass // Appium server is stopped after Tests class
	public void tearDown() {
		// stop server
		if (driver != null) {
			driver.quit();
		}
		if (service != null) {
			service.stop();
		}
	}
	
	
}


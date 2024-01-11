package com.mobileframework.TestUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClass1 {

	private String APP;
	private static final int portNumber = 4725;
	// String portNumber = 4725;
	private static final int sysport = 8101;

	public AppiumDriver driver;
	public AppiumDriverLocalService service;

	String platformName = "Android";// ("Android, IOS")
	
	/* //****For Future XML
		String platformName= "Android";
		String deviceName= "pixel_5_API_29";
		String platformVersion = "10";
		String portNumber = "4725";
		String sysport = "8201";
	*/ //******************
	
	DesiredCapabilities caps = new DesiredCapabilities();

	@BeforeClass(alwaysRun = true) // Appium is started before Tests class

	// Start Appium Server and driver
	public void configureAppium() throws MalformedURLException {
		// code to start the server
		// Android driver, iOS Driver
		// Appium Code>Appium Server>Mobile

		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/").usingPort(portNumber)
				.build();
		service.start();
		switch (platformName) {
		case "Android":
			
			APP = "/Users/gilberto.barraza/Desktop/MobileAutomation/MobileProject/"
					+ "JavaAppium2024/AppiumFramework/src/test/java/com/mobileframework/Resources/ApiDemos-debug.apk";
			
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_5_API_29");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			caps.setCapability("app", APP);
			caps.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
			//caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, (sysport));
			//caps.setCapability(AndroidMobileCapabilityType.ADB_EXEC_TIMEOUT, 120000);
			//caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);

			driver = new AndroidDriver(new URL("http://localhost:" + portNumber + "/wd/hub"), caps);
			break;
		case "IOS":
			
			APP = "/Users/gilberto.barraza/Library/Developer/Xcode/DerivedData/"
					+ "UIKitCatalog-deznigzoptzaldacjdmocohwiigl/Build/Products/"
					+ "Debug-iphonesimulator/UIKitCatalog.app";
			
			caps.setCapability("appium:platformName", MobilePlatform.IOS);
			caps.setCapability("deviceName", "iPhone 14 Pro");
			caps.setCapability("platformVersion", "16.0");
			caps.setCapability("automationName", "XCUITest");
			caps.setCapability("app", APP);
			// caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
			// Appium--WebDriver Agent>iOS apps
			caps.setCapability("wdaLocalPort", sysport);
			caps.setCapability("wdaLaunchTimeout", "30000");

			driver = new IOSDriver(new URL("http://localhost:" + portNumber + "/wd/hub"), caps);
			break;
		default:
			System.out.println(platformName + " Platform is not valid");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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

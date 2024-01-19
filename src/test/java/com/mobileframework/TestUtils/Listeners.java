package com.mobileframework.TestUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mobileframework.utils.AppiumUtils;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumUtils implements ITestListener {

	/*
	 * ExtentReporterNG reporterng = new ExtentReporterNG(); ExtentReports extent =
	 * reporterng.getReporterObject();
	 */

	// ExtentReportNG as static and do not need to create an object to be called
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	ExtentTest test;
	AppiumDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		// Create the entries from your test case getting the name from test method
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// get the error message on the log if test fails
		test.fail(result.getThrowable());
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
			//test.addScreenCaptureFromPath(takeScreenshotAndReturnPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
			test.addScreenCaptureFromBase64String(takeScreenshotBase64("test64", driver));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}

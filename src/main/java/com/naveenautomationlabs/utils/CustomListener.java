package com.naveenautomationlabs.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomationlabs.base.TestBase;

public class CustomListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
logger.info("******************Test case started :"+ result.getMethod().getMethodName()+"********************");
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("##################Test Case Passed: " + result.getMethod().getMethodName()
				+ "####################");

	}

	public void onTestFailure(ITestResult result) {
		logger.info("!!!!!!!!!!!!!!Test Case Fail: " + result.getMethod().getMethodName() + " Taking Screenshot!!!!!!!!!!!!!!!!!!!!");
		Utils.failedTestScreenShot(result.getMethod().getMethodName());

	}

	public void onTestSkipped(ITestResult result) {
		logger.info("??????????????????Test Case skipped: " + result.getMethod().getMethodName() + "????????????????");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}

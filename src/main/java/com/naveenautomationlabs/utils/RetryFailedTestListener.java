package com.naveenautomationlabs.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomationlabs.base.TestBase;

public class RetryFailedTestListener extends TestBase implements IRetryAnalyzer {

	int counter = 1, maxCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed test : " + result.getMethod().getMethodName() + "for " + counter);
		if (counter < maxCount) {
			counter++;
			return true;

		}
		return false;
	}

}

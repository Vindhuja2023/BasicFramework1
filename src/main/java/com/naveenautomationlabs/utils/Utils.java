package com.naveenautomationlabs.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomationlabs.base.TestBase;

public class Utils extends TestBase{
	
	public static void failedTestScreenShot(String testMethodName) {

		String timeStamp = getCurrentDateTimeStamp();

		File screenShotFfile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFfile,
					new File("./FailedTestCasesScreenShot\\" + "_" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}

	}
	public static void sleep(long millseconds) {
		try {
			Thread.sleep(millseconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static String generateRandomString(int chCnt) {
		return RandomStringUtils.randomAlphabetic(chCnt);
	}

	public static String generateRandomAlphaNumeric(int chCnt) {
		return RandomStringUtils.randomAlphanumeric(chCnt);
	}

	public static String generateRandomNumber(int cnt) {
		return RandomStringUtils.randomNumeric(cnt);
	}

	public static String getCurrentDateTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	}
}

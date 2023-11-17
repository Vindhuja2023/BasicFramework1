package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.pages.ForgottenPasswordPage;
import com.naveenautomationlabs.pages.LoginPage;

public class ForgottenPasswordPageTest extends TestBase {

	private LoginPage loginPage;
	private ForgottenPasswordPage forgottenPasswordPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserGetsWarringMsgWithInvalidMailWhileClickingForgottenPassword() {
		forgottenPasswordPage = loginPage.clickForgottenPassword();
		forgottenPasswordPage.clickSubmitBtn("jane");
		Assert.assertEquals(forgottenPasswordPage.getWarningMsg(),
				"Warning: The E-Mail Address was not found in our records, please try again!",
				"Sending Mail for resetting password works with invalid email input");

	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}
}

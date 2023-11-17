package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.LoginPage;
import com.naveenautomationlabs.pages.ReturnsPage;

public class ReturnsPageTest extends TestBase {

	private LoginPage loginPage;
	private	AccountPage accountPage;
	private	ReturnsPage returnPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserGetsReturnMsg() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		returnPage = accountPage.clickReturns(SideNavMenu.RETURNS);

		Assert.assertEquals(returnPage.getAlertMsgDisplayed(), "You have not made any previous returns!",
				"Return page does not displayed an alert.");

	}

	@Test
	private void validateUserCanClickSubmitButton() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");

		returnPage = accountPage.clickReturns(SideNavMenu.RETURNS);
		accountPage = returnPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account",
				"Submit Button not returning to my account page");
	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

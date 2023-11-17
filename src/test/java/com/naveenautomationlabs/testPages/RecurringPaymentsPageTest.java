package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.LoginPage;
import com.naveenautomationlabs.pages.RecurringPaymentsPage;

public class RecurringPaymentsPageTest extends TestBase{
	private LoginPage loginPage;
	private AccountPage accountPage;
	private RecurringPaymentsPage recurringPaymentsPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserGetsNoRecurringPaymentAlertMsgWhenNoPaymentDone() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		recurringPaymentsPage = accountPage.clickRecurringPayments(SideNavMenu.RECURRING_PAYMENTS);

		Assert.assertEquals(recurringPaymentsPage.getAlertMsgDisplayed(), "No recurring payments found!",
				"Recurring payments page does not displayed expected message.");

	}

	@Test
	private void validateUserCanClickSubmitButton() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		recurringPaymentsPage = accountPage.clickRecurringPayments(SideNavMenu.RECURRING_PAYMENTS);

		accountPage = recurringPaymentsPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account",
				"Submit Button not returning to my account page");
	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}


}

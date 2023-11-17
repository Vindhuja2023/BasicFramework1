package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.LoginPage;
import com.naveenautomationlabs.pages.TransactionsPage;

public class TransactionsPageTest extends TestBase {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private TransactionsPage transactionsPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserGetsNoTransactionAlertMsgWhenNoTransactionDone() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		transactionsPage = accountPage.clickTransactions(SideNavMenu.TRANSACTIONS);

		Assert.assertEquals(transactionsPage.getAlertMsgDisplayed(), "You do not have any transactions!",
				"Transaction page does not displayed expected message when no transaction is done");

	}

	@Test
	private void validateUserCanClickSubmitButton() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		transactionsPage = accountPage.clickTransactions(SideNavMenu.TRANSACTIONS);

		accountPage = transactionsPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account",
				"Submit Button not returning to my account page");
	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.LoginPage;
import com.naveenautomationlabs.pages.OrderHistoryPage;

public class OrderHistoryPageTest extends TestBase{

	private LoginPage loginPage;
	private AccountPage accountPage;
	private OrderHistoryPage orderHistoryPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserGetsOrderHistoryAlertMsgWhenNoPurchaseDone() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		orderHistoryPage = accountPage.clickOrderHistory(SideNavMenu.ORDER_HISTORY);

		Assert.assertEquals(orderHistoryPage.getAlertMsgDisplayed(), "You have not made any previous orders!",
				"Order history page does not displayed expected message when no purchase done.");

	}

	@Test
	private void validateUserCanClickSubmitButton() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		orderHistoryPage = accountPage.clickOrderHistory(SideNavMenu.ORDER_HISTORY);

		accountPage = orderHistoryPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account",
				"Submit Button not returning to my account page");
	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

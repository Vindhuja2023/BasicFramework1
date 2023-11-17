package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.LoginPage;
import com.naveenautomationlabs.pages.RewardPointsPage;

public class RewardPointsPageTest extends TestBase {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private RewardPointsPage rewardPointsPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserGetsNoRewardPointAlertMsgWhenNoRewardPointAvailable() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		rewardPointsPage = accountPage.clickRewardPoints(SideNavMenu.REWARD_POINTS);

		Assert.assertEquals(rewardPointsPage.getAlertMsgDisplayed(), "You do not have any reward points!",
				"Reward page does not displayed expected message when no reward point is available.");

	}

	@Test
	private void validateUserCanClickSubmitButton() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		rewardPointsPage = accountPage.clickRewardPoints(SideNavMenu.REWARD_POINTS);

		accountPage = rewardPointsPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account",
				"Submit Button not returning to my account page");
	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.DownloadsPage;
import com.naveenautomationlabs.pages.LoginPage;

public class DownloadsPageTest extends TestBase {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private DownloadsPage downloadsPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserGetsNoDownloadsAlertMsgWhenNoDownloadsDone() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		downloadsPage = accountPage.clickDownloads(SideNavMenu.DOWNLOADS);

		Assert.assertEquals(downloadsPage.getAlertMsgDisplayed(), "You have not made any previous downloadable orders!",
				"Downloads page does not displayed expected message on items.");

	}

	@Test
	private void validateUserCanClickSubmitButton() {
		accountPage = loginPage.submitLogin("zara123@email.com", "zara@123");

		downloadsPage = accountPage.clickDownloads(SideNavMenu.DOWNLOADS);

		accountPage = downloadsPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account",
				"Submit Button not returning to my account page");
	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

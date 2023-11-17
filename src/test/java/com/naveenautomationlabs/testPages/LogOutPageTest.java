package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.HomePage;
import com.naveenautomationlabs.pages.LogOutPage;
import com.naveenautomationlabs.pages.LoginPage;

public class LogOutPageTest extends TestBase {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private LogOutPage logOutPage;
	private HomePage homePage;

	@BeforeMethod
	public void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserLogoutSuccessfully() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		logOutPage = accountPage.clickLogout(SideNavMenu.LOGOUT);

		Assert.assertEquals(logOutPage.getAlertMsgDisplayed(), "Account Logout", "Logout failed.");

	}

	@Test
	private void validateUserCanClickSubmitButton() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		logOutPage = accountPage.clickLogout(SideNavMenu.LOGOUT);

		homePage = logOutPage.clickSubmitBtn();
		Assert.assertTrue(homePage.validateIfLogoOfPageDisplayed(),"Page logo is not displayed.");
	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

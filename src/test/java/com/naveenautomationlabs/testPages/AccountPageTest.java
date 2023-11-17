package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.ChangePasswordPage;
import com.naveenautomationlabs.pages.EditUserInfoPage;
import com.naveenautomationlabs.pages.LoginPage;
import com.naveenautomationlabs.pages.NewsletterPage;

public class AccountPageTest extends TestBase {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private EditUserInfoPage editPage;
	private ChangePasswordPage passwordPage;
	private NewsletterPage newsLetterPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserCanUpdatePersonalInfo() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		editPage = accountPage.clickEditUserInfo(SideNavMenu.EDIT_ACCOUNT);
		editPage.enterLName("U");
		accountPage = editPage.clickSubmitBtn();

		Assert.assertEquals(accountPage.getInfoUpdateMsg(), "Success: Your account has been successfully updated.",
				"Updating personal info failed");

	}

	@Test
	private void validateUserCanChangePassword() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		passwordPage = accountPage.clickChangePassword(SideNavMenu.PASSWORD);
		passwordPage.enterPassword("jane@123");
		passwordPage.confirmPassword("jane@123");
		accountPage = passwordPage.clickSubmitBtn();

		Assert.assertEquals(accountPage.getPasswordChangeMsg(), "Success: Your password has been successfully updated.",
				"Password not changed");

	}

	@Test
	private void validateUserCanUpdateNewsLetterSubscription() {

		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		newsLetterPage = accountPage.clickNewsletter(SideNavMenu.NEWSLETTER);
		newsLetterPage.clickNoBtn();
		accountPage = newsLetterPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getNewsLetterSubscriptionSucessMsg(),
				"Success: Your newsletter subscription has been successfully updated!",
				"Newsletter subscription status updation failed.");

	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

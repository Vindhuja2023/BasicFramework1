package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.EditUserInfoPage;
import com.naveenautomationlabs.pages.LoginPage;

public class EditUserInfoPageTest extends TestBase {

	private LoginPage loginPage;
	private	AccountPage accountPage;
	private EditUserInfoPage editPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();
	}

	@Test
	private void validateUserGetsWaringMsgWhileNameFieldIsMoreThanSpecifiedLimit() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		editPage = accountPage.clickEditUserInfo(SideNavMenu.EDIT_ACCOUNT);
		editPage.enterFName("Abcdefghijklmnopqrstuvwxyzaabbccddeeff");
		accountPage = editPage.clickSubmitBtn();
		Assert.assertEquals(editPage.getFieldWarningMsg(), "First Name must be between 1 and 32 characters!",
				"Character exceeded does not shows warning message.");
	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}
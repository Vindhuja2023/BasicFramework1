package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.ForgottenPasswordPage;
import com.naveenautomationlabs.pages.LoginPage;
import com.naveenautomationlabs.utils.ExcelUtil;

public class LoginPageTest extends TestBase {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private ForgottenPasswordPage forgottenPasswordPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserCanLoginWithValidCredentials() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "Login Failed.");

	}

	@Test
	private void validateUserCanNotLoginWithInvalidCredentials() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane12334");
		Assert.assertEquals(loginPage.getAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"Login is success.");

	}

	@Test(dataProvider = "User Credentials")
	private void validateLoginWithMultipleValidCredentials(String userName, String password) {
		accountPage = loginPage.submitLogin(userName, password);
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "Login Failed.");

	}

	@DataProvider(name = "User Credentials")
	private Object[][] getDataFromExcelSheel() throws Exception {
		String fileName = "C:\\Users\\rajeev\\Desktop\\userCredentials.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtil.getRowCount(fileName, sheetName);
		int coloumnCount = ExcelUtil.getColoumnCount(fileName, sheetName, rowCount);

		String[][] virtualSheet = new String[rowCount][coloumnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < coloumnCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtil.getCellData(fileName, sheetName, i, j);

			}

		}
		return virtualSheet;

	}

	@Test
	private void validateUserGetsEmailWithConfirmationLinkWhileClickingForgottenPassword() {
		forgottenPasswordPage = loginPage.clickForgottenPassword();
		loginPage = forgottenPasswordPage.clickSubmitBtn("jane123@email.com");
		Assert.assertEquals(loginPage.getEmailLinkSuccessMsgText(),
				"An email with a confirmation link has been sent your email address.",
				"Mail for resetting password not send to registered email.");

	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

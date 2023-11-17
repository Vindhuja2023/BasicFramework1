package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.AddAddressPage;
import com.naveenautomationlabs.pages.AddressBookPage;
import com.naveenautomationlabs.pages.LoginPage;
import com.naveenautomationlabs.utils.ExcelUtil;

public class AddressBookPageTest extends TestBase {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private AddressBookPage addressBookPage;
	private AddAddressPage addAddressPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test
	private void validateUserGetsAddressUpdatingPage() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");

		addressBookPage = accountPage.clickAddressBook(SideNavMenu.ADDRESS_BOOK);

		Assert.assertEquals(addressBookPage.getTitleDisplayed(), "Address Book Entries",
				"Address book page title is not as expected.");

	}

	@Test
	private void validateUserCanAddNewAddress() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");

		addressBookPage = accountPage.clickAddressBook(SideNavMenu.ADDRESS_BOOK);
		addAddressPage = addressBookPage.clickSubmitBtn();

		addAddressPage.enterFieldInputs("Deva", "Laxmi", "Jiotec", "AS201", "Grand Avenue", "Barrie", "Q2A W3S",
				"Canada", "Ontario");
		addressBookPage = addAddressPage.clickSubmitBtn();
		Assert.assertEquals(addressBookPage.getAddressUpdationSuccessMsg(), "Your address has been successfully added",
				"Address updation failed.");
	}

	@Test(dataProvider = "User Address")
	private void validateUserCanUpdateMultipleAddress(String fName, String lName, String company, String address1,
			String address2, String city, String postCode, String country, String region) {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");

		addressBookPage = accountPage.clickAddressBook(SideNavMenu.ADDRESS_BOOK);
		addAddressPage = addressBookPage.clickSubmitBtn();
		addAddressPage.enterFieldInputs(fName, lName, company, address1, address2, city, postCode, country, region);
		addressBookPage = addAddressPage.clickSubmitBtn();

		Assert.assertEquals(addressBookPage.getAddressUpdationSuccessMsg(), "Your address has been successfully added",
				"Address updation failed.");

	}

	@DataProvider(name = "User Address")
	private Object[][] getDataFromExcelSheel() throws Exception {
		String fileName = "C:\\Users\\rajeev\\Desktop\\Addres Book.xlsx";
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

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

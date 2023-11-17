package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.LoginPage;
import com.naveenautomationlabs.pages.WishListPage;

public class WishListPageTest extends TestBase {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private WishListPage wishListPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}

	@Test(enabled = false)
	private void validateUserGetsEmptyWishListAlertMsgWhenWishlistIsEmpty() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");

		wishListPage = accountPage.clickWishList(SideNavMenu.WISH_LIST);

		Assert.assertEquals(wishListPage.getAlertMsgDisplayed(), "Your wish list is empty.",
				"Wishlist page does not displayed expected message on wish list items.");

	}

	@Test
	private void validateWishListWebTable() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");

		wishListPage = accountPage.clickWishList(SideNavMenu.WISH_LIST);

		Assert.assertEquals(wishListPage.getSelectedItemFromWishListTable(), "iPhone",
				"Element found from table is not as expected");

	}

	@Test
	private void validateUserCanClickSubmitButton() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		wishListPage = accountPage.clickWishList(SideNavMenu.WISH_LIST);
		accountPage = wishListPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account",
				"Submit Button not returning to my account page");
	}

	@AfterMethod
	private void closeBrowser() {
		tearDown();
	}

}

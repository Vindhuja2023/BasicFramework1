package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;

public class AccountPage extends TestBase {

	public AccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;

	@FindBy(css = "div.alert-success")
	WebElement accountInfoUpdateSucessMsg;

	@FindBy(css = "div.alert-success")
	WebElement passwordChangeSuccessMsg;

	@FindBy(css = "div.alert-success")
	WebElement newsLetterSubsciptionSuccessMsg;

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public EditUserInfoPage clickEditUserInfo(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);
		return new EditUserInfoPage();
	}

	public String getInfoUpdateMsg() {
		return accountInfoUpdateSucessMsg.getText();
	}

	public ChangePasswordPage clickChangePassword(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);
		return new ChangePasswordPage();
	}

	public String getPasswordChangeMsg() {
		return passwordChangeSuccessMsg.getText();
	}

	public NewsletterPage clickNewsletter(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);
		return new NewsletterPage();
	}

	public String getNewsLetterSubscriptionSucessMsg() {

		return newsLetterSubsciptionSuccessMsg.getText();
	}

	public ReturnsPage clickReturns(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);
		return new ReturnsPage();
	}

	public WishListPage clickWishList(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);
		return new WishListPage();
	}

	public AddressBookPage clickAddressBook(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);
		return new AddressBookPage();
	}

	public DownloadsPage clickDownloads(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);
		return new DownloadsPage();
	}

	public LogOutPage clickLogout(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);

		return new LogOutPage();

	}

	public RecurringPaymentsPage clickRecurringPayments(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);

		return new RecurringPaymentsPage();

	}

	public OrderHistoryPage clickOrderHistory(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);

		return new OrderHistoryPage();

	}

	public TransactionsPage clickTransactions(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);

		return new TransactionsPage();

	}

	public RewardPointsPage clickRewardPoints(SideNavMenu menuSelected) {
		selectingSideNavMenu(menuSelected);

		return new RewardPointsPage();

	}

}

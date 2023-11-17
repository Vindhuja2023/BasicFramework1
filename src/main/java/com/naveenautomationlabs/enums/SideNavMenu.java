package com.naveenautomationlabs.enums;

public enum SideNavMenu {

	ACCOUNT_PAGE("My Account"), EDIT_ACCOUNT("Edit Account"), PASSWORD("Password"), ADDRESS_BOOK("Address Book"),
	WISH_LIST("Wish List"), ORDER_HISTORY("Order History"), DOWNLOADS("Downloads"),
	RECURRING_PAYMENTS("Recurring payments"), REWARD_POINTS("Reward Points"), RETURNS("Returns"),
	TRANSACTIONS("Transactions"), NEWSLETTER("Newsletter"), LOGOUT("Logout");

	public String sideNavMenu;

	SideNavMenu(String sideNavMenu) {
		this.sideNavMenu = sideNavMenu;
	}

	public String getSideNavMenu() {
		return sideNavMenu;
	}

}

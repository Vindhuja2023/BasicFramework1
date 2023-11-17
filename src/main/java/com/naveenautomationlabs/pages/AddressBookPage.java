package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class AddressBookPage extends TestBase {

	public AddressBookPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.pull-right>a")
	WebElement newAddressBtn;

	@FindBy(css = "div#content>h2")
	WebElement titleOfTHePage;

	@FindBy(css = "div.alert-success")
	WebElement addressUpdationSuccessMsg;

	public String getTitleDisplayed() {
		return titleOfTHePage.getText();

	}

	public AddAddressPage clickSubmitBtn() {
		newAddressBtn.click();
		return new AddAddressPage();
	}

	public String getAddressUpdationSuccessMsg() {
		return addressUpdationSuccessMsg.getText();
	}
	
	
}

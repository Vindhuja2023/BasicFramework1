package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class DownloadsPage extends TestBase{
	
	public DownloadsPage() {
	PageFactory.initElements(wd, this);
	}
	@FindBy(css = "div.pull-right>a")
	WebElement submitBtn;

	@FindBy(css = "div#content>p")
	WebElement alertBanner;

	public String getAlertMsgDisplayed() {
		return alertBanner.getText();

	}

	public AccountPage clickSubmitBtn() {
		submitBtn.click();
		return new AccountPage();
	}


}

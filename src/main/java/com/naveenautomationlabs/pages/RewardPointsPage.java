package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class RewardPointsPage extends TestBase{
	

	public RewardPointsPage() {
	PageFactory.initElements(wd, this);
	}
	@FindBy(css = "div.pull-right>a")
	WebElement submitBtn;

	@FindBy(css = "div#content>div>table>tbody")
	WebElement alertBanner;

	public String getAlertMsgDisplayed() {
		return alertBanner.getText();

	}

	public AccountPage clickSubmitBtn() {
		submitBtn.click();
		return new AccountPage();
	}

}

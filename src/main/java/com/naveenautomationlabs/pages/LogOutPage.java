package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class LogOutPage extends TestBase {

	public LogOutPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div#content>h1")
	WebElement logOutMsg;

	@FindBy(css = "div.pull-right>a")
	WebElement submitBtn;

	public String getAlertMsgDisplayed() {
		return logOutMsg.getText();

	}

	public HomePage clickSubmitBtn() {
		submitBtn.click();
		return new HomePage();
	}

}

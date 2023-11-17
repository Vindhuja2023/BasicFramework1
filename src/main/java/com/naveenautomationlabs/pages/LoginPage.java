package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-password")
	WebElement pwdInput;

	@FindBy(css = "input[type='submit']")
	WebElement loginBtn;

	@FindBy(css = "div.alert")
	WebElement alertBanner;

	@FindBy(css = "div.form-group>a")
	WebElement forgottenPasswordLink;

	@FindBy(css = "div.alert-success")
	WebElement emailLinkSuccessMsg;

	private void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	private void enterPassword(String password) {
		pwdInput.sendKeys(password);
	}

	public AccountPage submitLogin(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		loginBtn.click();
		return new AccountPage();
	}

	public String getAlertText() {
		return alertBanner.getText();
	}

	public ForgottenPasswordPage clickForgottenPassword() {
		forgottenPasswordLink.click();
		return new ForgottenPasswordPage();
	}

	public String getEmailLinkSuccessMsgText() {
		return emailLinkSuccessMsg.getText();
	}
}

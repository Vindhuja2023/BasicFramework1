package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class ForgottenPasswordPage extends TestBase {

	public ForgottenPasswordPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[name='email']")
	WebElement emailInput;

	@FindBy(css = "input[type='submit']")
	WebElement submitBtn;

	@FindBy(css = "div.alert")
	WebElement warningMsg;

	private void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public LoginPage clickSubmitBtn(String email) {
		enterEmail(email);
		submitBtn.click();
		return new LoginPage();
	}

	public String getWarningMsg() {

		return warningMsg.getText();

	}

}

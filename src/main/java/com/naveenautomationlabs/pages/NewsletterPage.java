package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class NewsletterPage extends TestBase {

	public NewsletterPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[value='1']")
	WebElement yesBtn;

	@FindBy(css = "input[value='0']")
	WebElement noBtn;

	@FindBy(css = "input[type='submit']")
	WebElement submitBtn;

	public void clickYesBtn() {
		yesBtn.click();
	}

	public void clickNoBtn() {
		noBtn.click();
	}

	public AccountPage clickSubmitBtn() {
		submitBtn.click();
		return new AccountPage();
	}

}

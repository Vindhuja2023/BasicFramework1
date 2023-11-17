package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class EditUserInfoPage extends TestBase {

	public EditUserInfoPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[name='firstname']")
	WebElement firstNameInput;

	@FindBy(css = "input[name='lastname']")
	WebElement lastNameInput;

	@FindBy(css = "input[name='email']")
	WebElement emailInput;

	@FindBy(css="input[name='telephone']")
	WebElement telephoneInput;

	@FindBy(css = "input[type='submit']")
	WebElement submitBtn;
	
	@FindBy(css = "div.text-danger")
	WebElement fieldWarningMsg;
	

	public void enterFName(String name) {
		firstNameInput.sendKeys(name);

	}

	public void enterLName(String name) {
		lastNameInput.sendKeys(name);

	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);

	}

	public void enterTelephoneNum(String phoneNum) {
		telephoneInput.sendKeys(phoneNum);

	}

	public AccountPage clickSubmitBtn() {
		submitBtn.click();
		return new AccountPage();
	}
	
	public String getFieldWarningMsg() {
		return fieldWarningMsg.getText();
	}

}

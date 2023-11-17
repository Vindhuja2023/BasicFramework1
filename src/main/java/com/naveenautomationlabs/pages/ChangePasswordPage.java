package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class ChangePasswordPage extends TestBase{
	
	public ChangePasswordPage() {
		PageFactory.initElements(wd, this);
	}
	
	
	
	@FindBy(css = "input[name='password']")
	WebElement passwordInput;
	

	@FindBy(css = "input[name='confirm']")
	WebElement confirmPasswordInput;
	

	@FindBy(css = "input[type='submit']")
	WebElement submitBtn;

	

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);

	}
	

	public void confirmPassword(String password) {
		confirmPasswordInput.sendKeys(password);

	}
	
	public AccountPage clickSubmitBtn() {
		submitBtn.click();
		return new AccountPage();
	}
}

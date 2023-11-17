package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomationlabs.base.TestBase;

public class AddAddressPage extends TestBase {

	public AddAddressPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "")
	WebElement titleOfAddAddress;

	@FindBy(css = "input#input-firstname")
	WebElement firstNameInput;

	@FindBy(css = "input#input-lastname")
	WebElement lastNameInput;

	@FindBy(css = "input#input-company")
	WebElement companyInput;

	@FindBy(css = "input#input-address-1")
	WebElement address1Input;

	@FindBy(css = "input#input-address-2")
	WebElement address2Input;

	@FindBy(css = "input#input-city")
	WebElement cityInput;

	@FindBy(css = "input#input-postcode")
	WebElement postCodeInput;

	@FindBy(css = "select#input-country")
	WebElement country;

	@FindBy(css = "select#input-zone")
	WebElement region;

	@FindBy(css = "input[type='submit']")
	WebElement submitBtn;

	private void enterFName(String name) {
		firstNameInput.sendKeys(name);

	}

	private void enterLName(String name) {
		lastNameInput.sendKeys(name);

	}

	private void enterCompany(String company) {
		companyInput.sendKeys(company);

	}

	private void enterAddress1(String address1) {
		address1Input.sendKeys(address1);

	}

	private void enterAddress2(String address2) {
		address2Input.sendKeys(address2);

	}

	private void enterCity(String city) {
		cityInput.sendKeys(city);

	}

	private void enterPostcode(String postCode) {
		postCodeInput.sendKeys(postCode);

	}

	private void selectCountry(String visibleText) {
		selectFromDropDown(country, visibleText);
	}

	private void selectRegion(String visibleText) {
		selectFromDropDown(region, visibleText);
	}

	public void enterFieldInputs(String fName, String lName, String company, String address1, String address2,
			String city, String postCode, String country, String region) {
		enterFName(fName);
		enterLName(lName);
		enterCompany(company);
		enterAddress1(address1);
		enterAddress2(address2);
		enterCity(city);
		enterPostcode(postCode);
		selectCountry(country);
		selectRegion(region);

	}

	public AddressBookPage clickSubmitBtn() {
		submitBtn.click();
		return new AddressBookPage();
	}

}

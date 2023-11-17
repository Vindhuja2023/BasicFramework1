package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div#logo>a>img")
	WebElement pageLogo;
	
	public boolean validateIfLogoOfPageDisplayed() {
		return pageLogo.isDisplayed();
	}


}

package com.naveenautomationlabs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class WishListPage extends TestBase {

	public WishListPage() {
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

	public String getSelectedItemFromWishListTable() {
		List<WebElement> rows = wd
				.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
		List<WebElement> coloumns = wd
				.findElements(By.xpath("//table[@class='table table-bordered table-hover']//thead//td"));
		System.out.println("Number of rows : " + rows.size());
		System.out.println("Number of rows : " + coloumns.size());

		String beforeXpath = "//table[@class='table table-bordered table-hover']//tbody//tr[";
		String afterXpath = "]/td[";
		String tableData = "";
		for (int i = 2; i <= rows.size(); i++) {
			for (int j = 1; j <= coloumns.size(); j++) {
				tableData = wd.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]")).getText();
				if (tableData.equals("iPhone")) {
					return tableData;
				}

			}

		}
		return null;

	}

}

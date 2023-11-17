package com.naveenautomationlabs.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.browserUtils.Browser;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.environment.Environment;
import com.naveenautomationlabs.utils.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;

	private final Browser DEFAULT_BROWSER = Browser.CHROME;
	private final Environment URL = Environment.PROD;
	private static final boolean RUN_ON_GRID = false;

	public static Logger logger;
	public WebDriverEvents events;
	public EventFiringWebDriver e_driver;

	@BeforeClass
	public void loggerSetup() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public void setup() {
		if(RUN_ON_GRID) {
			try {
				wd = new RemoteWebDriver(new URL("http://192.168.2.11:4444"),getOption());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		else {
		switch (DEFAULT_BROWSER) {
		case CHROME:
			wd = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			wd = WebDriverManager.edgedriver().create();
			break;
		case FIREFOX:
			wd = WebDriverManager.firefoxdriver().create();
			break;
		default:
			throw new IllegalArgumentException();
		}}

		// Wrap the instance
		e_driver = new EventFiringWebDriver(wd);

		// Events which need to be captured
		events = new WebDriverEvents();
		e_driver.register(events);

		// Assigning back the value to Web driver
		wd = e_driver;

		/* Loading the Page */
		wd.get(URL.getUrl());

		wd.manage().window().maximize();
		wd.manage().deleteAllCookies();

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void selectingSideNavMenu(SideNavMenu menuSelected) {
		List<WebElement> sideNavMenu = wd.findElements(By.cssSelector("div.list-group>a"));
		for (int i = 0; i < sideNavMenu.size(); i++) {
			if (sideNavMenu.get(i).getText().toString().equals(menuSelected.getSideNavMenu())) {
				sideNavMenu.get(i).click();
				break;

			}
		}

	}
	

	public void selectFromDropDown(WebElement element, String visibleText) {

		Select sc = new Select(element);
		sc.selectByVisibleText(visibleText);

	}
	public MutableCapabilities getOption() {
		return new ManageOptions().getOption(DEFAULT_BROWSER);
	}


	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}

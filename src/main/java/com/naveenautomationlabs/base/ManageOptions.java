package com.naveenautomationlabs.base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.naveenautomationlabs.browserUtils.Browser;

public class ManageOptions {

	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("headless");
		return options;

	}

	private EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.setCapability("InPrivate", true);
		return options;

	}

	private FirefoxOptions getFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("-private");
		return options;

	}

	public MutableCapabilities getOption(Browser browser) {

		switch (browser) {
		case CHROME:

			return this.getChromeOptions();
		case EDGE:
			return this.getEdgeOptions();
		case FIREFOX:
			return this.getFireFoxOptions();

		default:
			throw new IllegalArgumentException();

		}

	}
}

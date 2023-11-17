package com.naveenautomationlabs.browserUtils;

public enum Browser {

	CHROME("CHROME"), EDGE("EDGE"), FIREFOX("FIREFOX"),SAFARI("SAFARI");

	public String browser;

	Browser(String browser) {
		this.browser = browser;
	}

	public String getBrowser() {
		return browser;
	}
}

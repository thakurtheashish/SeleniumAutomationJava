package com.naveenautomationslabs.browsers;

public enum Browsers {
	
	//Providing value to CHROME, EDGE, FIREFOX
	
	CHROME("Google Chrome"),
	EDGE("Microsoft Edge"),
	FIREFOX("Mozilla Firefox"),
	SAFARAI("Mac Safari");

	private String browserNameWithCompanies;
	
	Browsers(String string) {
		this.browserNameWithCompanies = string;
	
	}

	public String getBrowserNameWithCompanies() {
		return browserNameWithCompanies;
	}
	
	
	
	




}

package com.naveenautomationslabs.browsers;

public enum JustAnExample {
	
	BOSTON("abc"),
	DAKOTA("def"),
	TEXAS("ghi");

	String capitalOfStates;
	
	JustAnExample(String string) {
		this.capitalOfStates = string;
	}

	public String getCapitalOfStates() {
		return capitalOfStates;
	}
	
	
	

}

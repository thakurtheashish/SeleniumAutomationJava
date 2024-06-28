package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.TestBasePackage.TestBase;

public class AccountLogoutPage extends TestBase{
	
	public AccountLogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="div.col-sm-9 h1")
	WebElement logoutText;
	
	public String getAccountLogoutText() {
		return logoutText.getText().trim();
	}
	
	

}

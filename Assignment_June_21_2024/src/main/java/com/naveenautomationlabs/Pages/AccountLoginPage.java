package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomations.TestBasePackage.TestBase;

public class AccountLoginPage extends TestBase{
	
	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="input-email")
	WebElement emailField;
	
	@FindBy (id="input-password")
	WebElement pwsdField;
	
	@FindBy (xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	private void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	private void enterPassword(String password) {
		pwsdField.sendKeys(password);
	}
	
	private void clickLoginBtn() {
		loginBtn.submit();
	}
	
	public MyAccountPage loginToAccount(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLoginBtn();
		return new MyAccountPage();
	}

}

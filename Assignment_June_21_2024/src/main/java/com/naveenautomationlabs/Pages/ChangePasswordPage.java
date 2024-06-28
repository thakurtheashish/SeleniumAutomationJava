package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.TestBasePackage.TestBase;

public class ChangePasswordPage extends TestBase{
	
	public ChangePasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="input-password")
	WebElement passwordField;
	
	@FindBy (id="input-confirm")
	WebElement confirmPasswordField;
	
	@FindBy (css="div.clearfix div.pull-right")
	WebElement continueBtn;
	
	@FindBy (css="div.text-danger")
	WebElement invalidPwsAlert;
	
	private void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	private void enterConfPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}
	
	public void clickContBtn() {
		continueBtn.click();
	}
	
	public String getInvalidPwsText() {
		 return invalidPwsAlert.getText().trim();
	}
	
	public MyAccountPage updatePassword(String password, String confPassword) {
		enterPassword(password);
		enterConfPassword(confPassword);
		clickContBtn();
		return new MyAccountPage();
	}

}

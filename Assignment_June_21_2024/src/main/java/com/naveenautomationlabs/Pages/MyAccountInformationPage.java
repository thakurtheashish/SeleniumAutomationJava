package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.TestBasePackage.TestBase;

public class MyAccountInformationPage extends TestBase{
	
	public MyAccountInformationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="input-firstname")
	WebElement firstName;
	
	@FindBy (id="input-lastname")
	WebElement lastName;
	
	@FindBy (id="input-email")
	WebElement email;
	
	@FindBy (id="input-telephone")
	WebElement phoneNo;
	
	@FindBy (css="div.clearfix div.pull-right")
	WebElement contBtn;
	
	private void enterFirstName(String firstN) {
		firstName.clear();
		firstName.sendKeys(firstN);
	}
	
	private void enterLastName(String lastN) {
		lastName.clear();
		lastName.sendKeys(lastN);
	}
	
	private void enterEmail(String emailAddr) {
		email.clear();
		email.sendKeys(emailAddr);
	}
	
	private void enterPhoneNo(String telephoneNo) {
		phoneNo.clear();
		phoneNo.sendKeys(telephoneNo);
	}
	
	private void clickContBtn() {
		contBtn.click();
	}
	
	public MyAccountPage updatePersonalDetails(String firstN, String lastN, String emailAddr, String telephoneNo ) {
		enterFirstName(firstN);
		enterLastName(lastN);
		enterEmail(emailAddr);
		enterPhoneNo(telephoneNo);
		clickContBtn();
		return new MyAccountPage();
	}
	
	


}

package com.naveenautomationlabs.PageTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomations.TestBasePackage.TestBase;

import junit.framework.Assert;

public class ChangePasswordPageTest extends TestBase{
	
	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	ChangePasswordPage changePasswordPage;
	
	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}
	
	@Test
	public void validateChangePswWithInvalidPsw() {
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		changePasswordPage = myAccountPage.clickPasswordBtn();
		changePasswordPage.updatePassword("123", "123");
		String getInvalidPwsText = changePasswordPage.getInvalidPwsText();
		Assert.assertEquals("Password must be between 4 and 20 characters!", getInvalidPwsText);
		
	}
	
	@Test
	public void validateChangePswWithMismatchPsw() {
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		changePasswordPage = myAccountPage.clickPasswordBtn();
		changePasswordPage.updatePassword("abc123","123a");
		String getInvalidPwsText = changePasswordPage.getInvalidPwsText();
		Assert.assertEquals("Password confirmation does not match password!", getInvalidPwsText);
		
	}
	
	

}

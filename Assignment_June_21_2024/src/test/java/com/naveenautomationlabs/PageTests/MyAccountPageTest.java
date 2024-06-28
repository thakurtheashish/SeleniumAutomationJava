package com.naveenautomationlabs.PageTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AccountLogoutPage;
import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.MyAccountInformationPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.Pages.YourAffiliateInformationPage;
import com.naveenautomations.TestBasePackage.TestBase;

import junit.framework.Assert;

public class MyAccountPageTest extends TestBase{
	
	MyAccountPage myAccountPage;
	AccountLoginPage loginPage;
	AccountLogoutPage logoutPage;
	NewsletterSubscriptionPage newsletterPage;
	ChangePasswordPage changePassword;
	MyAccountInformationPage myAccInfoPage;
	YourAffiliateInformationPage affiliateInfoPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}
	
	@Test
	public void validateLoginFunctionality() {
		MyAccountPage myAccountPage = loginPage.loginToAccount("example1@email.com" ,"abc123");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText);
	}
	
	@Test
	public void validateLogoutFunctionality() {
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		logoutPage = myAccountPage.clickLogoutBtn();
		String getLogoutText = logoutPage.getAccountLogoutText();
		Assert.assertEquals("Account Logout", getLogoutText);
	}
	
	@Test
	public void validateNewsletterSubscription() {
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		newsletterPage = myAccountPage.clickNewsLetterBtn();
		String getSubscriptionText = newsletterPage.getSubscriptiontext();
		Assert.assertEquals("Newsletter Subscription", getSubscriptionText);
		newsletterPage.updateSubscription("No");
		String updatedNewsletterText = myAccountPage.getUpdateText();
		Assert.assertEquals("Success: Your newsletter subscription has been successfully updated!", updatedNewsletterText);
	}
	
	@Test
	public void validateUpdatePassword() {
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		changePassword = myAccountPage.clickPasswordBtn();
		myAccountPage = changePassword.updatePassword("abc123", "abc123");
		String updatePasswordText = myAccountPage.getUpdateText();
		Assert.assertEquals("Success: Your password has been successfully updated.", updatePasswordText);
	}
	
	@Test
	public void validateUpdateAccountInfo() {
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		myAccInfoPage = myAccountPage.clickEditAcctBtn();
		myAccountPage = myAccInfoPage.updatePersonalDetails("Ashish", "Thakur", "example1@email.com", "987987987");
		String updateAccInfoText = myAccountPage.getUpdateText();
		Assert.assertEquals("Success: Your account has been successfully updated.", updateAccInfoText);
	}
	
	@Test
	public void validateUpdateAffiliateInfo() {
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		affiliateInfoPage = myAccountPage.clickEditAffiliateInfo();
		 myAccountPage = affiliateInfoPage.updateAffiliateInfo(
			        "XYZ LTD", 
			        "xyz@email.com", 
			        "789AAA", 
			        "BankTransfer", 
			        "Ashish Thakur", 
			        "abcd@ymail.com", 
			        "TD Bank", 
			        "90779", 
			        "TDB0123", 
			        "ABC Corp", 
			        "7897996546"
			    );
		String updateAccInfoText = myAccountPage.getUpdateText();
		Assert.assertEquals("Success: Your account has been successfully updated.", updateAccInfoText);
	}

	
	
	
	
	
	

}

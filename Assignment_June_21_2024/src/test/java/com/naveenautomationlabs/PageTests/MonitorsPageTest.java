package com.naveenautomationlabs.PageTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.MonitorsPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomations.TestBasePackage.TestBase;

import junit.framework.Assert;

public class MonitorsPageTest extends TestBase{
	
	MyAccountPage myAccountPage;
	AccountLoginPage loginPage;
	MonitorsPage monitorsPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}
	
	@Test(groups = "addItemToWishlist")
	public void validateAddItem1ToWishlist(){
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		monitorsPage = myAccountPage.clickComponents();
		monitorsPage.clickAddToWishList();
		String wishlistUpdateText = monitorsPage.getAlertText();
		Assert.assertEquals("Success: You have added Apple Cinema 30\" to your wish list!", wishlistUpdateText.trim());
	}
	
	@Test(groups = "addItemToWishlist")
	public void validateAddItem2ToWishlist(){
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		monitorsPage = myAccountPage.clickComponents();
		monitorsPage.clickAddToWishList2();
		String wishlistUpdateText2 = monitorsPage.getAlertText();
		Assert.assertEquals("Success: You have added Samsung SyncMaster 941BW to your wish list!", wishlistUpdateText2.trim());
	}

}

package com.naveenautomationlabs.PageTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.MyWishListPage;
import com.naveenautomations.TestBasePackage.TestBase;

import junit.framework.Assert;

public class MyWishListPageTest  extends TestBase{
	
	MyAccountPage myAccountPage;
	AccountLoginPage loginPage;
	MyWishListPage myWishlistPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}
	
	@Test(dependsOnGroups = {"addItemToWishlist"})
	public void validateRemoveItem1FromWishlist(){
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		myWishlistPage = myAccountPage.clickWishlistBtn();
		String itemToRemove = "Samsung";
		//String itemToRemove = "Apple";
		myWishlistPage.removeItemFromWishlist(itemToRemove);
		String updatedWishListText = myWishlistPage.getAlertText();
		
		Assert.assertEquals("Success: You have modified your wish list!", updatedWishListText.trim());
	}

}

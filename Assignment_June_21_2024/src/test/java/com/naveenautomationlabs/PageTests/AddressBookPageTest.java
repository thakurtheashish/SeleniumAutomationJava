package com.naveenautomationlabs.PageTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AddAddressBookPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomations.TestBasePackage.TestBase;

import junit.framework.Assert;

public class AddressBookPageTest extends TestBase{
	
	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	AddressBookPage addressBookPage;
	AddAddressBookPage addAddressPage;
	
	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}
	
	@Test(priority = 1)
	public void validateDeletingDefaultAddress() {
		
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		addressBookPage = myAccountPage.clickAddressBookbtn();
		addressBookPage.deleteDefaultAddress();
		driver.switchTo().alert().accept();
		String getUpdateText = addressBookPage.getUpdateText();
		Assert.assertEquals("Warning: You can not delete your default address!", getUpdateText);
		
	}
	
	@Test(priority = 2)
	public void validateAddNewAddress() {
		
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		addressBookPage = myAccountPage.clickAddressBookbtn();
		addAddressPage = addressBookPage.clickNewAddress();
		addressBookPage = addAddressPage.addAddressDetails("Assh", "Thar", "125Way NW", "Edmon", "A1C3", "38", "Canada", "602", "Alberta");
		String getUpdateText = addressBookPage.getUpdateText();
		Assert.assertEquals("Your address has been successfully added", getUpdateText);
	
	}
	
	@Test(dependsOnMethods = "validateAddNewAddress")
	public void validateDeleteExistingAddress() {
		
		myAccountPage = loginPage.loginToAccount("example1@email.com", "abc123");
		addressBookPage = myAccountPage.clickAddressBookbtn();
		addressBookPage.deleteAddress("125Way NW");
		String getUpdateText = addressBookPage.getUpdateText();
		Assert.assertEquals("Your address has been successfully deleted", getUpdateText);
	
	}
	
	
	
	

}

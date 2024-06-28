package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.TestBasePackage.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.col-sm-9 h2:first-of-type")
	WebElement myAccountText;

	@FindBy(css = "div.list-group a:last-of-type")
	WebElement logoutBtn;

	@FindBy(css = "div.list-group a:nth-of-type(12)")
	WebElement newsLetterBtn;

	@FindBy(css = "div.alert-dismissible")
	WebElement updateText;

	@FindBy(css = "div.list-group a:nth-of-type(3)")
	WebElement passwordBtn;

	@FindBy(css = "div.list-group a:nth-of-type(2)")
	WebElement editAccountBtn;

	@FindBy(css = "div.list-group a:nth-of-type(4)")
	WebElement adressBookBtn;

	@FindBy(xpath = "//a[text()='Edit your affiliate information']")
	WebElement editAffiliateInfo;
	
	@FindBy(xpath="//a[text()='Components']")
	WebElement componentsBtn;
	
	@FindBy(xpath="//a[text()='Monitors (2)']")
	WebElement monitorsBtn;
	
	@FindBy(css = "div.list-group a:nth-of-type(5)")
	WebElement wishlistBtn;
	
	public String getMyAccountText() {
		return myAccountText.getText().trim();
	}

	public AccountLogoutPage clickLogoutBtn() {
		logoutBtn.click();
		return new AccountLogoutPage();
	}

	public NewsletterSubscriptionPage clickNewsLetterBtn() {
		newsLetterBtn.click();
		return new NewsletterSubscriptionPage();
	}

	public ChangePasswordPage clickPasswordBtn() {
		passwordBtn.click();
		return new ChangePasswordPage();
	}

	public MyAccountInformationPage clickEditAcctBtn() {
		editAccountBtn.click();
		return new MyAccountInformationPage();
	}

	public String getUpdateText() {
		return updateText.getText().trim();
	}

	public YourAffiliateInformationPage clickEditAffiliateInfo() {
		editAffiliateInfo.click();
		return new YourAffiliateInformationPage();
	}

	public AddressBookPage clickAddressBookbtn() {
		adressBookBtn.click();
		return new AddressBookPage();
	}
	
	public MonitorsPage clickComponents() {
		componentsBtn.click();
		monitorsBtn.click();
		return new MonitorsPage();
	}
	
	public MyWishListPage clickWishlistBtn() {
		wishlistBtn.click();
		return new MyWishListPage();
	}

}

package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.TestBasePackage.TestBase;

public class MonitorsPage extends TestBase {
	
	public MonitorsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="div.product-layout:first-of-type button:nth-of-type(2)")
	WebElement wishlistBtn1;
	
	@FindBy (css="div.product-layout:last-of-type button:nth-of-type(2)")
	WebElement wishlistBtn2;
	
	@FindBy (css="div.alert")
	WebElement alertText;
	
	public void clickAddToWishList() {
		wishlistBtn1.click();
	}
	
	public void clickAddToWishList2() {
		wishlistBtn2.click();
	}
	
	public String getAlertText() {
		 return alertText.getText().replace("×", "");
	}

}

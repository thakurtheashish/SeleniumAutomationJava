package com.naveenautomationlabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.TestBasePackage.TestBase;

public class AddressBookPage extends TestBase{
	
	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="tbody tr:nth-of-type(1) a.btn-info")
	WebElement editDefaultAdrs;
	
	@FindBy (css="tbody tr:nth-of-type(1) a.btn-danger")
	WebElement deleteDefaultAdrs;
	
	@FindBy (css="div.clearfix div.pull-right")
	WebElement addNewAddress;
	
	@FindBy (css="tbody tr:nth-of-type(2) a.btn-info")
	WebElement editAddress;
	
	@FindBy (css="tbody tr:nth-of-type(2) a.btn-danger")
	WebElement deleteAddress;	
	
	@FindBy (css="div.alert")
	WebElement updateText;
	
	@FindBy (xpath="//a[contains(text(),'Delete')]")
	List<WebElement> deleteButtons; 
	
	public void deleteDefaultAddress() {
		deleteDefaultAdrs.click();
	}
	
	public void deleteExistinAddress() {
		deleteAddress.click();
	}
	
	public String getUpdateText() {
		return updateText.getText().trim();
	}
	
	public AddAddressBookPage clickNewAddress() {
		addNewAddress.click();
		return new AddAddressBookPage();
	}
	
	public void deleteAddress(String addressIdentifier){
    for (WebElement deleteButton : deleteButtons) {
        WebElement addressElement = deleteButton.findElement(By.xpath("./ancestor::tr"));
        String a = addressElement.getText().replace("\n", " ");
        if (a.contains(addressIdentifier)) {
            deleteButton.click();
            driver.switchTo().alert().accept();
            break;
        }
    }
}
}

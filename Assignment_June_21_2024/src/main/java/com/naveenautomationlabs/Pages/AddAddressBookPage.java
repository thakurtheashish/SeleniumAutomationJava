package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.TestBasePackage.TestBase;

public class AddAddressBookPage extends TestBase{
	
	public AddAddressBookPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="input[name='firstname']")
	WebElement firstName;
	
	@FindBy (css="input[name='lastname']")
	WebElement lastName;
	
	@FindBy (css="input[name='address_1']")
	WebElement address1;
	
	@FindBy (css="input[name='city']")
	WebElement city;
	
	@FindBy (css="input[name='postcode']")
	WebElement postalCode;
	
	@FindBy (id="input-country")
	WebElement country;
	
	@FindBy (id="input-zone")
	WebElement region;
	
	@FindBy (css="input[value='Continue']")
	WebElement continueBtn;
	
	private void enterFirstName(String firstNameText) {
        firstName.sendKeys(firstNameText);
    }
    
    private void enterLastName(String lastNameText) {
        lastName.sendKeys(lastNameText);
    }
    
    private void enterAddress(String address) {
        address1.sendKeys(address);
    }
    
    private void enterCity(String cityName) {
        city.sendKeys(cityName);
    }
    
    private void enterPostalCode(String postalCodeText) {
        postalCode.sendKeys(postalCodeText);
    }
    
  
    
    private void clickContinueButton() {
        continueBtn.click();
    }
    
    public AddressBookPage addAddressDetails(String firstNameText, String lastNameText, String address, String cityName, String postalCodeText, String countryValue, String countryText, String regionValue, String regionText) {
        enterFirstName(firstNameText);
        enterLastName(lastNameText);
        enterAddress(address);
        enterCity(cityName);
        enterPostalCode(postalCodeText);
        selectDropdownByValueOrText(country, countryValue, countryText);
        selectDropdownByValueOrText(region, regionValue, regionText);
        clickContinueButton();
        return new AddressBookPage();
    }          
	
}

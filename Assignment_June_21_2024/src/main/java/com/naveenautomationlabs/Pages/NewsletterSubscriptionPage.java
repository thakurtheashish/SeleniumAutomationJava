package com.naveenautomationlabs.Pages;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.TestBasePackage.TestBase;

public class NewsletterSubscriptionPage extends TestBase{
	
	public NewsletterSubscriptionPage () {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="div.col-sm-9 h1")
	WebElement newsLetterSubText;
	
	@FindBy (css="input[value='1']")
	WebElement yesBtn;
	
	@FindBy (css="input[value='0']")
	WebElement noBtn;
	
	@FindBy (css="input[value='Continue']")
	WebElement continueBtn;
	
	public String getSubscriptiontext() {
		return newsLetterSubText.getText().trim();
	}
	
	public void updateSubscription(String subscribing) {
		switch (subscribing) {
		case "Yes":
			yesBtn.click();
			break;
		
		case "No":
			noBtn.click();
			break;

		default:
			throw new InvalidArgumentException("Select Correct Option");
			
		}
		continueBtn.click();
	}

}

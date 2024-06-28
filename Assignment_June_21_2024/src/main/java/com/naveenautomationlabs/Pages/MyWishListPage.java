package com.naveenautomationlabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.TestBasePackage.TestBase;

public class MyWishListPage extends TestBase{

	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="div.alert")
	WebElement alerttext;
	
	@FindBy (css="tbody tr")
	List<WebElement> wishlistItems; 

	public void removeItemFromWishlist(String itemName) {
        for (WebElement item : wishlistItems) {
            String itemText = item.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
            if(itemText.contains(itemName)){
                WebElement removeButton = item.findElement(By.cssSelector("td.text-right a"));
                removeButton.click();
                break;
            }
        }
    }
	
	public String getAlertText() {
		return alerttext.getText().replace("×", "");
	}
}

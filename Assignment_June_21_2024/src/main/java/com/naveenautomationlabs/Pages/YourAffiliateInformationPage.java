package com.naveenautomationlabs.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomations.TestBasePackage.TestBase;

public class YourAffiliateInformationPage extends TestBase {

	private WebDriverWait wait;

	public YourAffiliateInformationPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@FindBy(id = "input-company")
	WebElement company;

	@FindBy(id = "input-website")
	WebElement website;

	@FindBy(id = "input-tax")
	WebElement taxId;

	@FindBy(xpath = "//input[@value='cheque']")
	WebElement cheque;

	@FindBy(xpath = "//input[@value='paypal']")
	WebElement paypal;

	@FindBy(xpath = "//input[@value='bank']")
	WebElement bankTransfer;

	@FindBy(css = "div.clearfix div.pull-right")
	WebElement contBtn;

	@FindBy(id = "input-cheque")
	WebElement chequePayeename;

	@FindBy(id = "input-paypal")
	WebElement paypalEmail;

	@FindBy(id = "input-bank-name")
	WebElement bankName;

	@FindBy(id = "input-bank-branch-number")
	WebElement branchNo;

	@FindBy(id = "input-bank-swift-code")
	WebElement swiftCode;

	@FindBy(id = "input-bank-account-name")
	WebElement accountName;

	@FindBy(id = "input-bank-account-number")
	WebElement accountNumber;

	private void enterCompanyName(String companyName) {
		company.clear();
		company.sendKeys(companyName);
	}

	private void enterWebsite(String websiteName) {
		website.clear();
		website.sendKeys(websiteName);
	}

	private void enterTaxId(String taxIdValue) {
		taxId.clear();
		taxId.sendKeys(taxIdValue);
	}

	private void clickContinueButton() {
		contBtn.click();
	}

	private void selectPaymentMethod(String paymentMethod, String chequePayeeName, String paypalEmailValue,
			String bankNameValue, String branchNumber, String swiftCodeValue, String accountNameValue,
			String accountNumberValue) {
		switch (paymentMethod) {
		case "Cheque":
			cheque.click();
			chequePayeename.clear();
			chequePayeename.sendKeys(chequePayeeName);
			break;
		case "Paypal":
			paypal.click();
			wait.until(ExpectedConditions.visibilityOf(paypalEmail));
			paypalEmail.clear();
			paypalEmail.sendKeys(paypalEmailValue);
			break;
		case "BankTransfer":
			bankTransfer.click();
			wait.until(ExpectedConditions.visibilityOf(bankName));
			fillBankTransferForm(bankName, bankNameValue);
			fillBankTransferForm(branchNo, branchNumber);
			fillBankTransferForm(swiftCode, swiftCodeValue);
			fillBankTransferForm(accountName, accountNameValue);
			fillBankTransferForm(accountNumber, accountNumberValue);
			break;
		default:
			throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
		}
	}

	private void fillBankTransferForm(WebElement element, String text) {
		element.clear();
		System.out.println("Entering " + text + " into field");
		element.sendKeys(text);
	}


	public MyAccountPage updateAffiliateInfo(String companyName, String websiteName, String taxIdValue,
			String paymentMethod, String chequePayeeName, String paypalEmailValue, String bankNameValue,
			String branchNumber, String swiftCodeValue, String accountNameValue, String accountNumberValue) {
		enterCompanyName(companyName);
		enterWebsite(websiteName);
		enterTaxId(taxIdValue);
		selectPaymentMethod(paymentMethod, chequePayeeName, paypalEmailValue, bankNameValue, branchNumber,
				swiftCodeValue, accountNameValue, accountNumberValue);
		clickContinueButton();
		return new MyAccountPage();
	}
}

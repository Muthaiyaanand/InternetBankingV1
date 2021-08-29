package com.internetbanking.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	public RemoteWebDriver driver;
	
	public AddCustomerPage(RemoteWebDriver driver) {
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='New Customer']")
	@CacheLookup
	WebElement clickNewCustomer;
	
	@FindBy(name = "name")
	@CacheLookup
	WebElement enterCustomerName;
	
	@FindBy(xpath = "//input[@name='rad1']")
	@CacheLookup
	WebElement selectGender;
	
	@FindBy(name = "dob")
	@CacheLookup
	WebElement enterDOB;
	
	@FindBy(name = "addr")
	@CacheLookup
	WebElement enterAddress;

	@FindBy(name = "city")
	@CacheLookup
	WebElement enterCity;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement enterState;
	
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement enterPINNo;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement enterTelephoneno;
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement enterEmailId;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement clickSubmit;
	
	@FindBy(name = "res")
	@CacheLookup
	WebElement clickReset;
	
	public void clickNewCustomer() {
		clickNewCustomer.click();
	}
	
	public void enterCustomerName(String CustomerName) {
		enterCustomerName.sendKeys(CustomerName);
	}
	
	public void selectGender() {
		selectGender.click();
	}
	
	public void enterDOB1(int DD, int MM, int YYYY) {
		enterDOB.sendKeys(String.valueOf(DD));
		enterDOB.sendKeys(String.valueOf(MM));
		enterDOB.sendKeys(String.valueOf(YYYY));
	}
	
	public void enterDOB(String DD, String MM, String YYYY) {
		enterDOB.sendKeys(DD);
		enterDOB.sendKeys(MM);
		enterDOB.sendKeys(YYYY);
	}
	
	
	public void enterAddress(String Address) {
		enterAddress.sendKeys(Address);
	}
	
	public void enterCity(String City) {
		enterCity.sendKeys(City);
	}
	
	public void enterState(String State) {
		enterState.sendKeys(State);
	}
	
	public void enterPINNo(String PIN) {
		enterPINNo.sendKeys(PIN);
	}
	
	public void enterTelephoneno(String TelephoneNo) {
		enterTelephoneno.sendKeys(TelephoneNo);
	}
	
	public void enterEmailId(String EmailID) {
		enterEmailId.sendKeys(EmailID);
	}
	
	
	public void clickSubmit() {
		clickSubmit.click();
	}
	
	
	public void clickReset() {
		clickReset.click();
	}
}

package com.internetbanking.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public RemoteWebDriver driver;
	
	public LoginPage(RemoteWebDriver driver) {
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserID;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement buttonLogin;
	
	@FindBy(xpath = "//a[text()='Log out']")
	@CacheLookup
	WebElement logOutbtn;
	
	public void setUserID(String UserID) {
		txtUserID.sendKeys(UserID);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void buttonLogin() {
		buttonLogin.click();
	}
	
	public void buttonLogOut() {
		logOutbtn.click();
	}
	
	
}

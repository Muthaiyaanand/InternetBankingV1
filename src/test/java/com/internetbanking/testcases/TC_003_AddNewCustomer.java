package com.internetbanking.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;

import com.internetbanking.pageobjects.AddCustomerPage;
import com.internetbanking.pageobjects.LoginPage;

import junit.framework.Assert;

public class TC_003_AddNewCustomer extends BaseClass {
	
	@Test
	public void AddNewCustomerTest() throws IOException {
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage LP = new LoginPage(driver);
		LP.setUserID(UserID);
		LP.setPassword(password);
		LP.buttonLogin();
		
		AddCustomerPage AddCustomer = new AddCustomerPage(driver);
		AddCustomer.clickNewCustomer();
		AddCustomer.enterCustomerName("Muthaiya");
		AddCustomer.selectGender();
		AddCustomer.enterDOB1(21, 06, 1990);
		AddCustomer.enterAddress("Address Line 1");
		AddCustomer.enterCity("Bingley");
		AddCustomer.enterState("Bradford");
		AddCustomer.enterPINNo("605011");
		AddCustomer.enterTelephoneno("9600431928");
		String email = randomString() + "@gmail.com";
		AddCustomer.enterEmailId(email);
		AddCustomer.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res == true) {
			Assert.assertTrue(true);
		}else {
			getScreenShot(driver, "AddCustomer");
			Assert.assertTrue(false);
		}
	}
	


}

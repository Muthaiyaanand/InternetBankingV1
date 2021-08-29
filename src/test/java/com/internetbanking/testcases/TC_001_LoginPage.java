package com.internetbanking.testcases;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetbanking.pageobjects.LoginPage;

public class TC_001_LoginPage extends BaseClass {
	
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL launched successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage LP = new LoginPage(driver);
		LP.setUserID(UserID);
		logger.info(UserID  +  "entered successfully");
		LP.setPassword(password);
		logger.info(password  +  "entered successfully");
		LP.buttonLogin();
		logger.info("clicked on login button successfully");
		
		String PageTitle = driver.getTitle();
		
		if(PageTitle.equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			getScreenShot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
			
		}
	}
}
	
	
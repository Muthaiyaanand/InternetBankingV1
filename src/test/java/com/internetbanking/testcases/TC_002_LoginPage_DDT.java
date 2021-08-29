package com.internetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetbanking.pageobjects.LoginPage;
import com.internetbanking.utilities.XLUtils;




public class TC_002_LoginPage_DDT extends BaseClass {

	@Test(dataProvider = "LoginTest")
	public void LoginPage_DDT(String UserID, String Password) throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserID(UserID);
		logger.info(UserID  +  "entered successfully");
		lp.setPassword(Password);
		logger.info(Password  +  "entered successfully");
		lp.buttonLogin();
		
		if(isAlertPresent()==true) {
			
			
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		} else 
		{
			getScreenShot(driver, "TC_002_LoginPage_DDT");
			Assert.assertTrue(true);
			lp.buttonLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		}

	public boolean isAlertPresent() {//To check alert present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch(NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginTest")
	public static  String [][] getData() throws IOException{
		String data[][]= testData();
		return data;
	}
	
	
	public static String[][] testData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/internetbanking/testdata/LoginDetails.xlsx";
		XLUtils excel = new XLUtils(path, "Sheet1");
		int rowCount = XLUtils.getRowCount();
		System.out.println(rowCount);
		int ColCount = XLUtils.getColumnCount();
		System.out.println(ColCount);
		String loginData[][] =new String[rowCount-1][ColCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<ColCount;j++) {
				String cellData = XLUtils.getCellDataString(i, j);
				loginData[i-1][j] = cellData;
				System.out.println();
				System.out.println(loginData);
			}
		}
		return loginData;

	}

}

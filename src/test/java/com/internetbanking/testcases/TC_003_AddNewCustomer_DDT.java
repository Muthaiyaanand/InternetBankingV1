package com.internetbanking.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetbanking.pageobjects.AddCustomerPage;
import com.internetbanking.pageobjects.LoginPage;
import com.internetbanking.utilities.ReadConfig;
import com.internetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_003_AddNewCustomer_DDT extends BaseClass {

	@Test(dataProvider ="CustomerData")
	public void addNewCustomer_DDT(String CustomerName, String DOBDate, String DOBMonth, String DOBYear, String Address, String City, String State, String PINNo, String Telephone, String Email ) throws IOException {
		ReadConfig ReadConfig = new ReadConfig();
		
		String UserID = ReadConfig.getUserID();
		String password = ReadConfig.getpassword();
		
		LoginPage LP = new LoginPage(driver);
		LP.setUserID(UserID);
		LP.setPassword(password);
		LP.buttonLogin();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AddCustomerPage AddCustomer = new AddCustomerPage(driver);
		AddCustomer.clickNewCustomer();
		AddCustomer.enterCustomerName(CustomerName);
		AddCustomer.selectGender();
		AddCustomer.enterDOB(DOBDate, DOBMonth, DOBYear);
		AddCustomer.enterAddress(Address);
		AddCustomer.enterCity(City);
		AddCustomer.enterState(State);
		AddCustomer.enterPINNo(PINNo);
		AddCustomer.enterTelephoneno(Telephone);
		AddCustomer.enterEmailId(Email);
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
	

	@DataProvider(name = "CustomerData")
	public  static Object[][] getData(){
		Object data[][] = testData();
		return data;
	}

	public  static Object[][] testData(){

		String path = System.getProperty("user.dir") + "/src/test/java/com/internetbanking/testdata/AddNewCustomer.xlsx";
		XLUtils excel = new XLUtils(path, "Sheet1");
		int rowCount = XLUtils.getRowCount();
		System.out.println(rowCount);
		int ColCount = XLUtils.getColumnCount();
		System.out.println(ColCount);
		Object loginData[][] =new Object[rowCount-1][ColCount];

		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<ColCount;j++) {
				Object cellData = XLUtils.getCellDataString(i, j);
				loginData[i-1][j] = cellData;
				System.out.println();
				System.out.println(loginData);
			}
		}
		return loginData;

	}
}


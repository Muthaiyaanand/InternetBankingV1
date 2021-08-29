package com.internetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	public Properties prop;
	
	public ReadConfig() {
		
		try {
			FileInputStream FIS = new FileInputStream("./Configuration\\config.properties");
			prop = new Properties();
			prop.load(FIS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception message is " + e.getMessage());
		}
		
	}
	
	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	
	public String getUserID() {
		String UserID = prop.getProperty("UserID");
		return UserID;
	}

	public String getpassword() {
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getchromedriver() {
		String chromedriver = prop.getProperty("chromedriver");
		return chromedriver;
	}
	
	public String getgeckodriver() {
		String geckodriver = prop.getProperty("geckodriver");
		return geckodriver;
	}
	
	public String getinternetexplorerdriver() {
		String internetexplorerdriver = prop.getProperty("internetexplorerdriver");
		return internetexplorerdriver;
	}
}

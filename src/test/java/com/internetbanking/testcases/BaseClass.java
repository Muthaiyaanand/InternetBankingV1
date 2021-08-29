package com.internetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.internetbanking.utilities.*;

public class BaseClass {
	
	ReadConfig ReadConfig = new ReadConfig();
	
	public String url = ReadConfig.getUrl();
	public String UserID = ReadConfig.getUserID();
	public String password = ReadConfig.getpassword();
	public RemoteWebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		
		logger = Logger.getLogger("InternetBankingV1");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", ReadConfig.getchromedriver());
		driver = new ChromeDriver();
	} else if (browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", ReadConfig.getgeckodriver());
		driver = new FirefoxDriver();
	} else if (browser.equalsIgnoreCase("internetexplorer")) {
		System.setProperty("webdriver.ie.driver", ReadConfig.getinternetexplorerdriver());
		driver = new InternetExplorerDriver();
	}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void getScreenShot(RemoteWebDriver driver, String testcasename) throws IOException {
	TakesScreenshot snapshot = (TakesScreenshot)driver;
	File source = snapshot.getScreenshotAs(OutputType.FILE);
	File  destination = new File(System.getProperty("user.dir")  + "/Screenshots/" + testcasename+  ".png");
	FileUtils.copyFile(source, destination);
	System.out.println("Screenshot secured");
}
	
	public String randomString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
}

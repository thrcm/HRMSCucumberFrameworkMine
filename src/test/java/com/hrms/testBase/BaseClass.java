package com.hrms.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrms.utils.ConfigReader;
import com.hrms.utils.Constants;

public class BaseClass {

		public static WebDriver driver;
		
		public static void setUp() {
			
			ConfigReader.readProperties(Constants.FILE_PATH);
			
			//previously, it was switch(Constants.BROWSER.toLowerCase()). Code get enhanced -->
			//deleted BROWSER constant and start using Properties file
			switch (ConfigReader.getProperty("browser").toLowerCase()) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
					driver = new ChromeDriver();
					break;
				case "firefox":
					System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
					driver = new FirefoxDriver();
					break;
				default:
					System.err.println("Browser is not supported");
			}
			
			driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			//it was previously driver.get(Constants.HRMS_URL);
			driver.get(ConfigReader.getProperty("url"));
		}

		public static void tearDown() {
			if (driver != null) {
				driver.quit();
			}
		}
	}

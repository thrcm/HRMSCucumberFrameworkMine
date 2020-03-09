package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	//to read different Properties file
	public static Properties readProperties(String filePath) {
		//String filePath = Constants.FILE_PATH; -->do not hard-code. Pass a parameter instead in order to read any property file
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	//To get any value on prop object
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}

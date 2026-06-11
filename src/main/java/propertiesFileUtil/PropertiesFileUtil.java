package propertiesFileUtil;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtil {
	
	public static String getLocators(String key) {
		FileInputStream fis = null;
		
		String baseDirectory = System.getProperty("user.dir");
		try {
			fis = new FileInputStream(baseDirectory+"\\src\\test\\resources\\config\\Locators.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
	
	public static String getTestData(String key) {
		FileInputStream fis = null;
		
		String baseDirectory = System.getProperty("user.dir");
		try {
			fis = new FileInputStream(baseDirectory+"\\src\\test\\resources\\config\\TestData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}



}

package com.app.readProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadProperties {
	final static Logger logger = Logger.getLogger(ReadProperties.class);

	protected Properties prop = null;
	protected InputStream input = ReadProperties.class.getClassLoader()
			.getResourceAsStream("log4j.properties");

	public ReadProperties() {

		try {
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			logger.error("log4j.properties file is not found");
			e.printStackTrace();
		}
	}

	public String url() {
		return prop.getProperty("url");
	}

	public String browserType() {
		return prop.getProperty("browserType");
	}

	public String username() {
		return prop.getProperty("username");
	}

	public String password() {
		return prop.getProperty("password");
	}
	
	public String searchItem() {
		return prop.getProperty("searchItem");
	}
	
	public String address(int i) {
		String[] s = prop.getProperty("address").split(";");
		return s[i];
	}
	
	public String customerInfo(int i) {
		String[] s = prop.getProperty("customerInfo").split(";");
		return s[i];
	}

}

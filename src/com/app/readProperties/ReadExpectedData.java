package com.app.readProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadExpectedData {
	final static Logger logger = Logger.getLogger(ReadExpectedData.class);

	protected Properties prop = null;
	protected InputStream input = ReadProperties.class.getClassLoader()
			.getResourceAsStream("expectedData.properties");

	public ReadExpectedData() {

		try {
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			logger.error("expectedData.properties file is not found");
			e.printStackTrace();
		}
	}

	public String WelcomeMsg() {
		return prop.getProperty("WelcomeMsg");
	}

}

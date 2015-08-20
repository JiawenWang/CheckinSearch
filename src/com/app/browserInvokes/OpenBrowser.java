package com.app.browserInvokes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.app.readProperties.ReadProperties;

public class OpenBrowser {

	final static Logger logger = Logger.getLogger(OpenBrowser.class);

	public static WebDriver launchBrowser(WebDriver d) {


		ReadProperties data = new ReadProperties();

		try {
			switch (data.browserType()) {
			case "InternetExplorer":

				// open internetExplorer driver
				d = new InternetExplorerDriver();
				d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				logger.info("IE will be used for testing according to the configuration");
				break;

			case "firefox":

				// open firefox driver
				d = new FirefoxDriver();
				d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				logger.info("firefox will be used for testing according to the configuration");
				break;
			case "chrome":

				// open chrome driver
//				System.setProperty("webdriver.chrome.driver",
//						"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
				d = new ChromeDriver();
				d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				logger.info("Chrome will be used for testing according to the configuration");
				break;
			default:

				// if the configured driver is not one of IE, FF, Chrome , open
				// ie as default one
				d = new InternetExplorerDriver();
				d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				logger.info("Configured browser type is not supported. Open link with IE as default");
			}

			// open the url configured in log4j.properties file
			d.get(data.url());
			logger.info("open the configured web site");
			
			WebElement loginbtn = null;
			try {
				loginbtn = d.findElement(By.cssSelector(".col-md-4 div"));
				logger.info("find the btn successfully");
			} catch (Exception e) {
				logger.error("can't find the btn");
				e.printStackTrace();
			}
			
			loginbtn.click();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
		
	}

}

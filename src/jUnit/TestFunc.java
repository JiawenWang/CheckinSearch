package jUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.app.browserInvokes.OpenBrowser;

public class TestFunc {
	final static Logger logger = Logger.getLogger(TestFunc.class);
	
	public static void main(String[] args) {

		WebDriver d = null;

		try {
			d = OpenBrowser.launchBrowser(d);
			Thread.sleep(3000);
			logger.info("website is opened");

			d.quit();
		} catch (Exception e) {
			e.printStackTrace();
			d.quit();
		}

	}
}

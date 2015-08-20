package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.app.browserInvokes.OpenBrowser;

public class Junit {
	WebDriver d = null;

	@Before
	public void setUp() throws Exception {
		
		//open browser
		d = OpenBrowser.launchBrowser(d);
		Thread.sleep(3000);
		System.out.println("website is opened");
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}

	@Test
	public void testCase001_SignupSuccess() {
		assertEquals(0, 1);
	}
	
	@Test
	public void testCase002_LoginAndBuy() {
		assertEquals(0, 1);
	}

}

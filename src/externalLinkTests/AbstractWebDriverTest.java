package externalLinkTests;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import pageObjects.HomePage;

public class AbstractWebDriverTest {
	protected WebDriver driver;
	protected HomePage home;
	@Before
	public void setUp() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		System.setProperty("webdriver.firefox.marionette", "/home/Ram/Desktop/geckodriver.exe");
		driver = new FirefoxDriver();
		home = new HomePage(driver);
		home = home.navigateToHomePage();
	}

	@After
	public void tearDown() {
		driver.close();
	}
	public static String isLinkBroken(URL url) {
		String response = "";
		try {
			HttpURLConnection h = (HttpURLConnection)url.openConnection();
			h.setRequestMethod("GET");
			h.connect();
			response = h.getResponseMessage();
			h.disconnect();
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}

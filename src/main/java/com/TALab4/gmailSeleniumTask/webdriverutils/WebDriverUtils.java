package com.TALab4.gmailSeleniumTask.webdriverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils {

	private static WebDriver driver;
	
	public static WebDriver getInstance() {


		if (driver == null) {
			driver =  new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.HOURS);
		}

		return driver;
	}
	
	public static void gotoURL(String url) {
		getInstance().navigate().to(url);
	}
}

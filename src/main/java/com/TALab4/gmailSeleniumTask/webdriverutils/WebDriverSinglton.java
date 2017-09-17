package com.TALab4.gmailSeleniumTask.webdriverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created  on 17.09.17.
 */
public class WebDriverSinglton {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverSinglton() {
    }

    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }
        WebDriver instance;
        //  System.setProperty("webdriver.chrome.driver", prop.getChomeDriverPath());
        instance = new ChromeDriver();

        webDriverThreadLocal.set(instance);
        return webDriverThreadLocal.get();
    }
}

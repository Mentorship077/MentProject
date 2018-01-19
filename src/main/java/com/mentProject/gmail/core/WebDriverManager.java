package com.mentProject.gmail.core;

import com.mentProject.gmail.util.EnvProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created  on 17.09.17.
 */
public class WebDriverManager {
    private final static EnvProperties prop = EnvProperties.getInstance();
    private static final int THREAD_COUNT = 3;
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static int counter = 0;


    private WebDriverManager() {
    }

    public static WebDriver getInstance() {
        if (webDriver.get() != null) {
            return webDriver.get();
        }
        System.setProperty("webdriver.chrome.driver", prop.getChomeDriverPath());
        synchronized (webDriver) {
            while (counter == THREAD_COUNT) {
                webDriver.notify();
            }
            counter++;
        }
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        webDriver.set(driver);
        return webDriver.get();
    }

    public static void gotoURL(String url) {
        getInstance().navigate().to(url);
    }

    public static void quitTheBrowser() {
        try {
            webDriver.get().quit();
        } finally {
            counter--;
            webDriver.remove();
        }
    }
}

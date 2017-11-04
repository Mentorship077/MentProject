package com.TALab4.gmailSeleniumTask.webdriverutils;

import com.TALab4.gmailSeleniumTask.util.EnvProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static WebDriver getDriver() {
        if (webDriver.get() != null) {
            return webDriver.get();
        }
//        System.setProperty("webdriver.chrome.driver", prop.getChomeDriverPath());
        System.setProperty("webdriver.ie.driver", prop.getIEDriverPath());

        synchronized (webDriver) {
            while (counter == THREAD_COUNT) {
                webDriver.notify();
            }
            counter++;
        }
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new InternetExplorerDriver();
//        new WebDriverWait(driver, 30).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.set(driver);
        return webDriver.get();
    }

    public static void gotoURL(String url) {
        getDriver().navigate().to(url);
    }


    public static void quitTheBrowser() {
        try {
            webDriver.get().quit();
        } finally {
            counter--;
            webDriver.remove();
        }
    }

    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, args);
    }
}

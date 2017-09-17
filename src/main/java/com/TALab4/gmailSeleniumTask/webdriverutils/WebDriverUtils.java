package com.TALab4.gmailSeleniumTask.webdriverutils;

import com.TALab4.gmailSeleniumTask.util.EnvProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils {
    private final static EnvProperties prop = EnvProperties.getInstance();
    private static WebDriver driver;


    public static WebDriver getInstance() {
//        use it for windows
//        System.setProperty("webdriver.chrome.driver", prop.getChomeDriverPath());

        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.HOURS);
        }

        return driver;
    }

    public static void gotoURL(String url) {
        getInstance().navigate().to(url);
    }
    public static void clickFirstLink(String XPath) {
        driver.findElement(By.xpath(XPath)).click();
    }

    public static void quitTheBrowser() {
        driver.quit();
    }

}

package com.mentProject.gmail.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Used for retrieved info from proprties file
 * Created  on 16.09.17.
 */
public class EnvProperties {
    private static final String UTIL_PROPERTIES_PATH = "src/main/resources/util.properties";
    private static final String CHROME_DRIVER = "Chrome";
    private static final String IE_DRIVER = "IE";
    private static final String REMOTE_WEB_DRIVER = "Remote";
    private static final String REMOTE_URL = "http://ecsf002002eb.epam.com:4444/wd/hub";
    private static EnvProperties instance;
    private Properties properties;


    private EnvProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(
                    new File(UTIL_PROPERTIES_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EnvProperties getInstance() {
        if (instance == null) {
            instance = new EnvProperties();
        }
        return instance;
    }
    public RemoteWebDriver getDriver()  {
        String browserName =  getBrowserName();
        RemoteWebDriver webDriver = null;
        switch (browserName) {
            case IE_DRIVER:
                System.setProperty("webdriver.ie.driver", properties.getProperty("geckoDriverPath"));
                webDriver = new FirefoxDriver();
                break;
            case CHROME_DRIVER:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverPath"));
                webDriver = new ChromeDriver();
                break;
            case REMOTE_WEB_DRIVER:
                try {
                    webDriver = new RemoteWebDriver(new URL(REMOTE_URL), DesiredCapabilities.internetExplorer());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                Reporter.log("The webDriver name is not correct. Try again");
                break;
            default:
                throw new RuntimeException("Incorrect driver type");
        }
        return webDriver;
    }

    public WebDriver getProcessDriver(long time){
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
        return driver;
    }
    public String getBrowserName() {
        return properties.getProperty("browser");
    }

    public String getBaseUrl() {
        return properties.getProperty("FIRST_PAGE");
    }

    public String getChomeDriverPath() {
        return properties.getProperty("CHROME_DRIVER_PATH");
    }
}

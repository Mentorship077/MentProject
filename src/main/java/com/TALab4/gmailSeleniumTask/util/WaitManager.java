package com.TALab4.gmailSeleniumTask.util;

import com.TALab4.gmailSeleniumTask.control.Element;
import com.TALab4.gmailSeleniumTask.webdriverutils.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static com.TALab4.gmailSeleniumTask.webdriverutils.WebDriverManager.getDriver;


public class WaitManager {
    public static final int DEFAULT_TIME_OUT = 60;// Seconds
    private static final long DEFAULT_POLLING = 1L;
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;
    private static final String ELEMENT_NOT_CLICKABLE = "Element wasn't clickable in %s sec";
    private static final String ERROR_WAITING = "Some problem occurs during waiting";
    private static final int COUNT_RETRY = 5;
    private static final int DURATION = 3;
    private static final Logger LOG = Logger.getLogger(WaitManager.class);
    private long timeOut;
    private TimeUnit timeUnitForTimeOut;
    private long polling;
    private TimeUnit timeUnitForPolling;
    private JavascriptExecutor js;
    private String pageLoadStatus;

    public WaitManager(int timeOut, TimeUnit unit) {
        this.timeOut = timeOut;
        this.timeUnitForTimeOut = unit;
        this.polling = DEFAULT_POLLING;
        this.timeUnitForPolling = DEFAULT_TIME_UNIT;
    }

    public WaitManager() {
        this.timeOut = DEFAULT_TIME_OUT;
        this.timeUnitForTimeOut = DEFAULT_TIME_UNIT;
        this.polling = DEFAULT_POLLING;
        this.timeUnitForPolling = DEFAULT_TIME_UNIT;
    }

    //    WaitManager.waitForCondition(() -> isContainerVisible, false);
    public static void waitForCondition(Callable<Boolean> callable, boolean stopWaitIfExceptionOccurred) {
        long beginTime = System.currentTimeMillis();
        boolean continueWaiting = true;
        while (continueWaiting && ((System.currentTimeMillis() - beginTime) < DEFAULT_TIME_OUT * 1000)) {
            try {
                if (callable.call()) {
                    continueWaiting = false;
                }
            } catch (Exception e) {
                if (stopWaitIfExceptionOccurred) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void waitForCondition(ExpectedCondition expectedCondition) {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 60);
        webDriverWait.until(expectedCondition);
    }

    public static void waitTimeOut(int time) {
        getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public <T extends WebElement> void untilClickable(T element) {
        untilClickable(element, COUNT_RETRY);
    }

    public <T extends WebElement> void untilClickable(T element, final int retryCount) {
        int retry = 0;
        while (retry < retryCount) {
            try {
                Sleeper.SYSTEM_SLEEPER.sleep(new Duration(DURATION, DEFAULT_TIME_UNIT));
                if (isClickable(element)) {
                    return;
                }
            } catch (InterruptedException e) {
                error(ERROR_WAITING);
            }
            retry++;
        }
        error(String.format(ELEMENT_NOT_CLICKABLE, retryCount * DURATION));
    }

    //    new WaitManager(5, TimeUnit.SECONDS).waitConstTime();
    public void waitConstTime() {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(new Duration(timeOut, timeUnitForTimeOut));
        } catch (InterruptedException e) {
            error(ERROR_WAITING);
        }
    }

    public <T extends WebElement> boolean isClickable(T webElement) {
        return webElement.isDisplayed() && webElement.isEnabled();
    }

    public void waitElement(Element element) {
        WebDriverWait waitDriver = new WebDriverWait(getDriver(), 30);
        waitDriver.until(
                ExpectedConditions.elementToBeClickable(element.getWebElement()));
    }

    private void error(String message) {
        LOG.error(message);
    }

    private void debug(String message) {
        LOG.debug(message);
    }

    public void waitTillPageLoadedC() {
        do {
            js = (JavascriptExecutor) getDriver();
            pageLoadStatus = (String) js.executeScript("return document.readyState");
        } while (!pageLoadStatus.equals("complete"));
    }
}
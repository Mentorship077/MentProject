package com.mentProject.gmail.util;


import com.mentProject.gmail.core.driver.WebDriverManager;
import com.mentProject.gmail.core.elements.Element;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitManager {
    public static final int DEFAULT_TIME_OUT = 60;// Seconds
    private static final long DEFAULT_POLLING = 1L;
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;
    private static final String ELEMENT_NOT_CLICKABLE = "Element wasn't clickable in %s sec";
    private static final String ERROR_WAITING = "Some problem occurs during waiting";
    private static final int COUNT_RETRY = 5;
    private static final int COUNT_RETRY_INCYCLE = 50;
    private static final int RETRY_CYCLE_SLEEP = 500;
    private static final int DURATION = 3;
    private static final Logger LOG = Logger.getLogger(WaitManager.class);
    private long timeOut;
    private TimeUnit timeUnitForTimeOut;
    private long polling;
    private TimeUnit timeUnitForPolling;

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

    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> {
            if (driver != null) {
                return WebDriverManager.executeScript("return document.readyState").toString().equals("complete");
            }
            throw new NullPointerException("Exception occurred while 'waitForPageLoaded', driver=null");
        };

        WebDriverWait wait = new WebDriverWait(WebDriverManager.getInstance(), 60);
        wait.until(expectation);
    }

    public static void waitForCondition(ExpectedCondition expectedCondition) {
        WebDriverWait webDriverWait = new WebDriverWait(WebDriverManager.getInstance(), 60);
        webDriverWait.until(expectedCondition);
    }

    public static void waitTimeOut(int time) {
        WebDriverManager.getInstance().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public <T extends WebElement> void untilClickable(T element) {
        untilClickable(element, COUNT_RETRY);
    }

    public <T extends WebElement> void untilClickable(T element, final int retryCount) {
        int retry = 0;
        while (retry < retryCount) {
            try {
                if (isClickable(element)) {
                    return;
                } else {
                    Sleeper.SYSTEM_SLEEPER.sleep(new Duration(DURATION, DEFAULT_TIME_UNIT));
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
        WebDriverWait waitDriver = new WebDriverWait(WebDriverManager.getInstance(), 30);
        waitDriver.until(
                ExpectedConditions.elementToBeClickable(element.getWebElement()));
    }

    private void error(String message) {
        LOG.error(message);
    }

    private void debug(String message) {
        LOG.debug(message);
    }

    /*
    Method waiting for 2 conditions to indicate that page is ready for further interactions
    Condition 1 - JS verification than document has ready state
    Condition 2 - Page loading spinner is not displayed
    Notes: best value for sleep after checking elements state is 500, decreasing this value could prevent to instability of tests execution
     */
    public void waitTillPageLoaded() {
        debug("Start of page waiter");
        boolean pageIsReady = false;
        boolean pageIsLoading = true;
        for (int i = 0; i < COUNT_RETRY_INCYCLE; i++) {
            debug("\n waiting for all conditions. Count:" + i);
            for (int j = 0; j < COUNT_RETRY_INCYCLE; j++) {
                debug("\n waiting till pageIsReady state true. Count:" + j);
                JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getInstance();
                if (js.executeScript("return document.readyState").toString().equals("complete")) {
                    pageIsReady = true;
                    break;
                }
                try {
                    Thread.sleep(RETRY_CYCLE_SLEEP);
                } catch (Exception e) {
                    error(e.getLocalizedMessage());
                }
            }
            if (pageIsReady == true) {
                for (int k = 0; k < COUNT_RETRY_INCYCLE; k++) {
                    debug("\n waiting till pageIsLoading state false. Count:" + k);
                    Wait<WebDriver> wait = new FluentWait<WebDriver>(WebDriverManager.getInstance())
                            .withTimeout(DEFAULT_TIME_OUT, DEFAULT_TIME_UNIT)
                            .pollingEvery(DEFAULT_POLLING, DEFAULT_TIME_UNIT)
                            .ignoring(NoSuchElementException.class);
                    WebElement waitSpinner = wait.until(new Function<WebDriver, WebElement>() {
                        public WebElement apply(WebDriver driver) {
                            return driver.findElement(By.id("waitScreen"));
                        }
                    });

                    if (waitSpinner != null) {
                        try {
                            String statusValue = waitSpinner.getAttribute("style");
                            if (statusValue.equalsIgnoreCase("display: none;"))
                                pageIsLoading = false;
                            break;
                        } catch (org.openqa.selenium.StaleElementReferenceException e) {
                            debug("spinner element was refreshed, page was overloaded.");
                            pageIsReady = false;
                            continue;
                        }
                    }
                    try {
                        Thread.sleep(RETRY_CYCLE_SLEEP);
                    } catch (Exception e) {
                        error(e.getLocalizedMessage());
                    }
                }
            }
            if (!pageIsLoading & pageIsReady)
                break;
        }
        if (pageIsLoading || !pageIsReady) {
            error("Page wasn't loaded successfully");
        }
        debug("End of page waiter");
    }
}
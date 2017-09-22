package com.TALab4.gmailSeleniumTask.webdriverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

/**
 * Created  on 11.09.17.
 */
public class PageObject {
    protected WebDriver driver;

    private PageObject(WebDriver driver) {
        WebDriver driverInstance = ParallelWebDriver.getInstance();
        PageFactory.initElements(
                new CustomFieldDecorator(new DefaultElementLocatorFactory(ParallelWebDriver.getInstance())),
                this);
    }

    public PageObject() {
        this(ParallelWebDriver.getInstance());
    }
}

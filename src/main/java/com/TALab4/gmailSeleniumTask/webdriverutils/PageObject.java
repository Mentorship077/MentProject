package com.TALab4.gmailSeleniumTask.webdriverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

/**
 * Created  on 11.09.17.
 */
public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        WebDriver instance = WebDriverUtils.getInstance();
        PageFactory.initElements(new DefaultElementLocatorFactory(instance), this);
    }

    public PageObject() {
        this(WebDriverUtils.getInstance());
    }
}

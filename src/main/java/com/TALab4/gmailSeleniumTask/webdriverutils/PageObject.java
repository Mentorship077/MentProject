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
        WebDriver instance = WebDriverSingleton.getInstance();
        PageFactory.initElements(new DefaultElementLocatorFactory(instance), this);
//        PageFactory.initElements(new MyFieldDecorator(instance),this);
    }

    public PageObject() {
        this(WebDriverSingleton.getInstance());
    }
}

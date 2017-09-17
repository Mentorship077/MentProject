package com.TALab4.gmailSeleniumTask.webdriverutils;

import com.TALab4.gmailSeleniumTask.util.EnvProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Created  on 11.09.17.
 */
public class PageObject {
    protected WebDriver driver;

    private PageObject(WebDriver driver) {
        WebDriver instance = WebDriverUtils.getInstance();
        PageFactory.initElements(new DefaultElementLocatorFactory(instance), this);
//        PageFactory.initElements(new MyFieldDecorator(instance),this);
    }

    public PageObject() {
        this(WebDriverUtils.getInstance());
    }
}

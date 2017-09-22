package com.TALab4.gmailSeleniumTask.webdriverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created  on 11.09.17.
 */
public class PageObject {
    private WebDriver driverInstance;
    private PageObject(WebDriver driver) {
        driverInstance = ParallelWebDriver.getInstance();
        PageFactory.initElements(
                new CustomFieldDecorator(new DefaultElementLocatorFactory(ParallelWebDriver.getInstance())),
                this);
    }

    public PageObject() {
        this(ParallelWebDriver.getInstance());
    }

     protected void waitForVisibilityAndClick(WebElement element) throws Error {
        new WebDriverWait(driverInstance, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }

}

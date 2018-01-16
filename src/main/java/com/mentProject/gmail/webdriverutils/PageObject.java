package com.mentProject.gmail.webdriverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created  on 11.09.17.
 */
public class PageObject {
    private WebDriver driverInstance;
    private PageObject(WebDriver driver) {
        driverInstance = WebDriverManager.getInstance();
        PageFactory.initElements(
                new FieldDecorator(driver),this);
    }

    public PageObject() {
        this(WebDriverManager.getInstance());
    }

     protected void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(driverInstance, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }

}

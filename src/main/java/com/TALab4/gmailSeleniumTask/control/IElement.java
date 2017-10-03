package com.TALab4.gmailSeleniumTask.control;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

import java.util.List;

public interface IElement extends WebElement, WrapsElement, Locatable {
    public String getInfo();

    public void clear();

    public void click();

    public void sendKeys(String text);

    public String getText();

    public WebElement getWebElement();

    public String getTagName();

    public String getAttribute(String attribute);

    public boolean isSelected();

    public boolean isEnabled();

    public void submit();

    public void sendKeys(CharSequence... charSequences);

    public List<WebElement> findElements(By by);

    public WebElement findElement(By by);

    public boolean isDisplayed();

    public Point getLocation();

    public Dimension getSize();

    public Rectangle getRect();

    public String getCssValue(String cssValue);

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException;

    public Coordinates getCoordinates();

    public WebElement getWrappedElement();
}

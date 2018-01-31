package com.mentProject.gmail.core.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import java.util.List;

public class Element implements IElement {
    private WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getInfo() {
        return this.webElement.toString();
    }

    @Override
    public void clear() {
//        Reporter.log("Clearing element " + webElement.toString() + "</br>");
        getWebElement().clear();
    }

    @Override
    public void click() {
        getWebElement().click();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        getWebElement().sendKeys(charSequences);
    }

    @Override
    public void sendKeys(String text) {
//        Reporter.log("Entering text: " + text + " to element " + webElement.toString() + "</br>");
        getWebElement().sendKeys(text);
    }

    @Override
    public String getText() {
        return getWebElement().getText();
    }

    @Override
    public WebElement getWebElement() {
        return webElement;
    }

    @Override
    public String getTagName() {
        return getWebElement().getTagName();
    }

    @Override
    public String getAttribute(String attribute) {
        return getWebElement().getAttribute(attribute);
    }

    @Override
    public boolean isSelected() {
        return getWebElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return getWebElement().isEnabled();
    }

    @Override
    public void submit() {
        getWebElement().submit();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getWebElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getWebElement().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return getWebElement().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return getWebElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        return getWebElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return getWebElement().getRect();
    }

    @Override
    public String getCssValue(String cssValue) {
        return getWebElement().getCssValue(cssValue);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return getWrappedElement().getScreenshotAs(outputType);
    }

    @Override
    public Coordinates getCoordinates() {
        return ((Locatable) getWebElement()).getCoordinates();
    }

    @Override
    public WebElement getWrappedElement() {
        return getWebElement();
    }
}

package com.TALab4.gmailSeleniumTask.webdriverutils.decorator_utils;

import com.TALab4.gmailSeleniumTask.control.IElement;
import org.openqa.selenium.WebElement;

public class WrapperFactory {
    public static IElement createInstance(Class<IElement> clazz,
                                          WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).
                    newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz
            );
        }
    }
}
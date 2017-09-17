package com.TALab4.gmailSeleniumTask.webdriverutils;

import com.TALab4.gmailSeleniumTask.control.WebElementWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

/**
 * Created  on 17.09.17.
 */
public class MyFieldDecorator extends DefaultFieldDecorator {
    public MyFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
//        return super.decorate(loader, field);
        System.out.println();
        if (WebElement.class.isAssignableFrom(field.getType())) {
            return super.decorate(loader, field);
        } else {
            if (WebElementWrapper.class.isAssignableFrom(field.getType())) {
                ElementLocator locator = factory.createLocator(field);

                return new WebElementWrapper(proxyForLocator(loader, locator));
            }
        }
        return null;
    }
}

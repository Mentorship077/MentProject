package com.TALab4.gmailSeleniumTask.pages;

import com.TALab4.gmailSeleniumTask.webdriverutils.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created  on 11.09.17.
 */
public class GmailLoginPage extends PageObject {

    @FindBy(name = "identifier")
    private WebElement email;
    @FindBy(css = "span[class='RveJvd snByac']")
    private WebElement emailSubmit;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(css = "span[class='RveJvd snByac']")
    private WebElement passwordSubmit;

    public GmailLoginPage typeLoginAndSubmit(String emailValue) {
        this.email.sendKeys(emailValue);
        this.emailSubmit.click();
        return this;
    }

    public GmailLoginPage typePasswordAndSubmit(String passwordValue) {
        this.password.sendKeys(passwordValue);
        waitForVisibility(passwordSubmit);
        this.passwordSubmit.click();
        return this;
    }
}

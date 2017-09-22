package com.TALab4.gmailSeleniumTask.pages;

import com.TALab4.gmailSeleniumTask.webdriverutils.PageObject;
import com.TALab4.gmailSeleniumTask.webdriverutils.ParallelWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created  on 11.09.17.
 */
public class GmailLoginPage extends PageObject {

    @FindBy(how = How.NAME, name = "identifier")
    private WebElement email;
    @FindBy(how = How.CSS, css = "span[class='RveJvd snByac']")
    private WebElement emailSubmit;
    @FindBy(how = How.NAME, name = "password")
    private WebElement password;
    @FindBy(how = How.CSS, css = "span[class='RveJvd snByac']")
    private WebElement passwordSubmit;

    public GmailLoginPage typeLoginAndSubmit(String emailValue) {
        this.email.sendKeys(emailValue);
        this.emailSubmit.click();
        return this;
    }

    public GmailLoginPage typePasswordAndSubmit(String passwordValue) {
        this.password.sendKeys(passwordValue);
        waitForVisibilityAndClick(passwordSubmit);
        this.passwordSubmit.click();
        return this;
    }
}

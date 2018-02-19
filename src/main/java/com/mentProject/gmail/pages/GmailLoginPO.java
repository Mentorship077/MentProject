package com.mentProject.gmail.pages;

import com.mentProject.gmail.core.elements.Button;
import com.mentProject.gmail.core.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created  on 11.09.17.
 */
public class GmailLoginPO extends PageObject {

    @FindBy(name = "identifier")
    private WebElement email;
    @FindBy(css = "span[class='RveJvd snByac']")
    private Button emailSubmit;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(css = "span[class='RveJvd snByac']")
    private Button passwordSubmit;

    public GmailLoginPO typeLoginAndSubmit(String emailValue) {
        this.email.sendKeys(emailValue);
        this.emailSubmit.click();
        return this;
    }

    public GmailLoginPO typePasswordAndSubmit(String passwordValue) {
        this.password.sendKeys(passwordValue);
        waitForVisibility(passwordSubmit);
        clickOnLogin();
        return this;
    }

    public GmailLoginPO clickOnLogin(){
        this.passwordSubmit.click();
        return this;
    }
}

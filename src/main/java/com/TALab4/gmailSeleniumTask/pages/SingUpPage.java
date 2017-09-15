package com.TALab4.gmailSeleniumTask.pages;

import com.TALab4.gmailSeleniumTask.util.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created  on 11.09.17.
 */
public class SingUpPage extends PageObject {


    @FindBy(name = "identifier")
    private WebElement email;
    @FindBy(css = "span[class='RveJvd snByac']")
    private WebElement emailSubmit;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "span[class='RveJvd snByac']")
    private WebElement passwordSubmit;

    public SingUpPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void submitEmail() {
        this.emailSubmit.click();
    }

    public void submitPassword() {
        this.passwordSubmit.click();
    }

    public void emailLogin(String emailValue, String passwordValue) {
        this.email.sendKeys(emailValue);
        this.emailSubmit.click();
        this.password.sendKeys(passwordValue);
        this.passwordSubmit.click();
    }
}

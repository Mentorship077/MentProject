package com.TALab4.gmailSeleniumTask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VerificationPages {
    @FindBy(how = How.CSS, name = ".lpb")
    private WebElement gmailLoginLoadBarVerification;

    public void checkGmailLoginLoadBarVerification() {
        gmailLoginLoadBarVerification.isDisplayed();
    }
}

package com.mentProject.gmail.pages;

import com.mentProject.gmail.core.PageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created  on 11.09.17.
 */
public class GmailComposeMessagePO extends PageObject {

    @FindBy(xpath = "//div[@gh=\"cm\"]")
    private WebElement creteMessage;
    @FindBy(name = "to")
    private WebElement to;
    @FindBy(name = "subjectbox")
    private WebElement subjectbox;
    @FindBy(xpath = "//td[@class=\"Ap\"]//div[2]//div[1]")
    private WebElement textMessage;
    @FindBy(xpath = "//td[@class=\"gU Up\"]//div[1]//div[2]")
    private WebElement sentMessage;


    @Then("^click on Compose button$")
    public GmailComposeMessagePO clickComposeButton() {
        this.creteMessage.click();
        return this;
    }

    @And("^fill email for sending$")
    public GmailComposeMessagePO enterEmailTo(String to) {
        this.to.sendKeys(to);
        return this;
    }


    @And("^fill subject content$")
    public GmailComposeMessagePO enterSubject(String subject) {
        this.subjectbox.sendKeys(subject);
        return this;
    }

    @And("^fill text message$")
    public GmailComposeMessagePO enterTextMessage(String textMessage) {
        this.textMessage.sendKeys(textMessage);
        return this;
    }

    @And("^click to Send$")
    public GmailComposeMessagePO clickSendButton() {
        this.sentMessage.click();
        return this;
    }

}

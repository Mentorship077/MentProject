package com.mentProject.gmail.pages;

import com.mentProject.gmail.core.PageObject;
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


    public GmailComposeMessagePO clickComposeButton() {
        this.creteMessage.click();
        return this;
    }

    public GmailComposeMessagePO enterEmailTo(String to) {
        this.to.sendKeys(to);
        return this;
    }


    public GmailComposeMessagePO enterSubject(String subject) {
        this.subjectbox.sendKeys(subject);
        return this;
    }

    public GmailComposeMessagePO enterTextMessage(String textMessage) {
        this.textMessage.sendKeys(textMessage);
        return this;
    }

    public GmailComposeMessagePO clickSendButton() {
        this.sentMessage.click();
        return this;
    }

}

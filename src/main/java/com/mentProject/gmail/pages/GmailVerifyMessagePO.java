package com.mentProject.gmail.pages;

import com.mentProject.gmail.core.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created  on 11.09.17.
 */
public class GmailVerifyMessagePO extends PageObject {

    @FindBy(xpath = "//div[@class=\"TN GLujEb aHS-bnu\"]//a")
    private WebElement sent;
    @FindBy(xpath = "//div[@class=\"BltHke nH oy8Mbf\"]//table[@class=\"F cf zt\"]//tbody[1]//tr[1]//td[2]")
    private WebElement emailCheckbox;
    @FindBy(xpath = "//div[@class=\"D E G-atb aCh\"]//div[@class=\"G-tF\"]//div[2]//div[3] ")
    private WebElement deleteMessage;
    @FindBy(name = "ok")
    private WebElement confirmDeleting;


    public GmailVerifyMessagePO clickOnAllSentMessagesButton() {
        sent.click();
        return this;
    }

    public GmailVerifyMessagePO selectLastSentMessage() {
        emailCheckbox.click();
        return this;
    }

    public GmailVerifyMessagePO deleteMessage() {
        deleteMessage.click();
        return this;
    }

    public GmailVerifyMessagePO confirmMessageDeleting() {
        confirmDeleting.click();
        return this;
    }

}

package com.TALab4.gmailSeleniumTask.pages;

import com.TALab4.gmailSeleniumTask.webdriverutils.PageObject;
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


    public void checkAndSelectSent() {
        sent.click();
        emailCheckbox.click();
    }

    public void deleteMessageAndConfirm() {
        deleteMessage.click();
        confirmDeleting.click();
    }

}

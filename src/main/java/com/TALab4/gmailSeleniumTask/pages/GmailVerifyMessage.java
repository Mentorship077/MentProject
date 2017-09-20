package com.TALab4.gmailSeleniumTask.pages;

import com.TALab4.gmailSeleniumTask.webdriverutils.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created  on 11.09.17.
 */
public class GmailVerifyMessage extends PageObject {

    @FindBy(how = How.XPATH, xpath = "//div[@class=\"TN GLujEb aHS-bnu\"]//a")
    private WebElement sent;
    @FindBy(how = How.XPATH, xpath = "//div[@class=\"BltHke nH oy8Mbf\"]//table[@class=\"F cf zt\"]//tbody[1]//tr[1]//td[2]")
    private WebElement emailCheckbox;
    @FindBy(how = How.XPATH, xpath = "//div[@class=\"D E G-atb aCh\"]//div[@class=\"G-tF\"]//div[2]//div[3] ")
    private WebElement deleteMessage;
    @FindBy(how = How.NAME, name = "ok")
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

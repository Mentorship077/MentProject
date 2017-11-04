package com.TALab4.gmailSeleniumTask.pages;

import com.TALab4.gmailSeleniumTask.webdriverutils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created  on 11.09.17.
 */
public class GmailComposeMessagePO extends PageObject {

    @FindBy(xpath ="//div[@gh=\"cm\"]" )
    private WebElement creteMessage;
    @FindBy(name ="to" )
    private WebElement to;
    @FindBy(name ="subjectbox" )
    private WebElement subjectbox;
    @FindBy(xpath ="//td[@class=\"Ap\"]//div[2]//div[1]" )
    private WebElement textMessage;
    @FindBy(xpath ="//td[@class=\"gU Up\"]//div[1]//div[2]" )
    private WebElement sentMessage;

    public void typeMessageAndSubmit(String to, String subject, String textMessage){
        this.creteMessage.click();
        this.to.sendKeys(to);
        this.subjectbox.sendKeys(subject);
        this.textMessage.sendKeys(textMessage);
        this.sentMessage.click();
    }

}

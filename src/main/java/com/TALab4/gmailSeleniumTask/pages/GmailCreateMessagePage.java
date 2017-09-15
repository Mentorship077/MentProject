package com.TALab4.gmailSeleniumTask.pages;

import com.TALab4.gmailSeleniumTask.webdriverutils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created  on 11.09.17.
 */
public class GmailCreateMessagePage extends PageObject {

    @FindBy(how = How.XPATH , xpath ="//*[@id=\":ha\"]/div/div" )
    private WebElement creteMessage;
    @FindBy(how = How.NAME , name ="to" )
    private WebElement to;
    @FindBy(how = How.NAME , name ="subjectbox" )
    private WebElement subjectbox;
    @FindBy(how = How.CSS , css ="div[aria-label=\"Текст повідомлення\"],[role=\"textbox\"]" )
    private WebElement textMessage;
    @FindBy(how = How.ID , id =":lu" )
    private WebElement sentMessage;

    public void typeMessageAndSubmit(String to, String subject, String textMessage){
        this.creteMessage.click();
        this.to.sendKeys(to);
        this.subjectbox.sendKeys(subject);
        this.textMessage.sendKeys(textMessage);
        this.sentMessage.click();
    }

}

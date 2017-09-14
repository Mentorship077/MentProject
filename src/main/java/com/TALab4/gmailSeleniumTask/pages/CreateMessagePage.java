package com.TALab4.gmailSeleniumTask.pages;

import com.TALab4.gmailSeleniumTask.util.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created  on 11.09.17.
 */
public class CreateMessagePage extends PageObject {

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

    public CreateMessagePage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateMessage(){
        creteMessage.click();
    }
    public void fillTo(String to){
        this.to.sendKeys(to);
    }
    public void fillSubject(String subject){
        subjectbox.sendKeys(subject);
    }
    public void fillTextMessage(String text){
        textMessage.sendKeys("Also selenium is usefull");
    }
    public void sentMessage(){
        sentMessage.click();
    }


    public void generalCreteMessage(String to, String subject, String textMessage){
        this.creteMessage.click();
        this.to.sendKeys(to);
        this.subjectbox.sendKeys(subject);
        this.textMessage.sendKeys(textMessage);
        this.sentMessage.click();
    }

}

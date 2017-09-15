package com.TALab4.gmailSeleniumTask.pages;

import com.TALab4.gmailSeleniumTask.util.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created  on 11.09.17.
 */
public class VerifyMessage extends PageObject {
    private final static String TO_EMAIL = "khimin1719@gmail.com";

    @FindBy(how = How.CSS, css = "a[title=\"Надіслані\"]")
    private WebElement sent;

    @FindBy(how = How.XPATH, xpath = "//span[@email=\"" + TO_EMAIL + "\"]")
    private WebElement messageVerify;

    @FindBy(how = How.CSS, css = "div[role=\"checkbox\"][dir=\"ltr\"]")
    private WebElement emailCheckbox;

    @FindBy(how = How.XPATH, xpath = "//div[@aria-label=\"Видалити\"]")
    private WebElement deleteMessage;


    public VerifyMessage(WebDriver driver) {
        super(driver);
    }

    public void openSent() {
        sent.click();
    }

    public void checkMessage() {
        System.out.println(messageVerify.getText());
        messageVerify.click();
        if(messageVerify.getText().equals("Nazar Khimin")){
            if(!emailCheckbox.isSelected()){
                emailCheckbox.click();
                deleteMessage.click();
            }
        }
    }
    public void deleteMessage(){
        deleteMessage.click();
    }
}

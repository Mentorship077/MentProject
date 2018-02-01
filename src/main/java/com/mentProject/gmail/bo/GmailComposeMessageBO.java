package com.mentProject.gmail.bo;

import com.mentProject.gmail.pages.GmailComposeMessagePO;
import com.mentProject.gmail.fileReader.enterDataGmail.model.Message;

/**
 * Created  on 17.09.17.
 */
public class GmailComposeMessageBO {
    public void composeMessage(Message message) {
        GmailComposeMessagePO composeMessagePage = new GmailComposeMessagePO();
        composeMessagePage
                .clickComposeButton()
                .enterEmailTo(message.getTo())
                .enterSubject(message.getSubject())
                .enterTextMessage(message.getTextMessage())
                .clickSendButton();
    }
}

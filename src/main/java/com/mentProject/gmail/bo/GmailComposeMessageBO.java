package com.mentProject.gmail.bo;

import com.mentProject.gmail.pages.GmailComposeMessagePO;
import com.mentProject.gmail.fileReader.enterDataGmail.model.Message;

/**
 * Created  on 17.09.17.
 */
public class GmailComposeMessageBO {
    public void compose(Message message) {
        GmailComposeMessagePO composeMessagePage = new GmailComposeMessagePO();
        composeMessagePage.typeMessageAndSubmit(message.getTo(),
                message.getSubject(), message.getTextMessage());
    }
}

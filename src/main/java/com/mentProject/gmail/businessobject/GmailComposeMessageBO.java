package com.mentProject.gmail.businessobject;

import com.mentProject.gmail.pages.GmailComposeMessagePO;
import com.mentProject.gmail.parser.model.Message;

/**
 * Created  on 17.09.17.
 */
public class GmailComposeMessageBO {
    public void composeMessage(Message message) {
        GmailComposeMessagePO composeMessagePage = new GmailComposeMessagePO();
        composeMessagePage.typeMessageAndSubmit(message.getTo(),
                message.getSubject(), message.getTextMessage());
    }
}

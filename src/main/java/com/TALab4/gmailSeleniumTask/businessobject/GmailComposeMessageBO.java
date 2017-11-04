package com.TALab4.gmailSeleniumTask.businessobject;

import com.TALab4.gmailSeleniumTask.pages.GmailComposeMessagePO;
import com.TALab4.gmailSeleniumTask.parser.model.Message;

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

package com.TALab4.gmailSeleniumTask.businessobject;

import com.TALab4.gmailSeleniumTask.pages.GmailComposeMessagePage;
import com.TALab4.gmailSeleniumTask.parser.model.Message;

/**
 * Created  on 17.09.17.
 */
public class GmailComposeMessageBO {
    public boolean composeMessage(Message message) {
        GmailComposeMessagePage composeMessagePage = new GmailComposeMessagePage();
        composeMessagePage.typeMessageAndSubmit(message.getTo(),
                message.getSubject(), message.getTextMessage());
        return true;
    }
}

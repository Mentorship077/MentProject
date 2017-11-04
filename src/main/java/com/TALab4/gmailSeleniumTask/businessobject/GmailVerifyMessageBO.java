package com.TALab4.gmailSeleniumTask.businessobject;

import com.TALab4.gmailSeleniumTask.pages.GmailVerifyMessagePO;

/**
 * Created  on 17.09.17.
 */
public class GmailVerifyMessageBO {
    public void selectAndDeleteSentMessage() throws InterruptedException {
        GmailVerifyMessagePO verifyMessage = new GmailVerifyMessagePO();
        verifyMessage.checkAndSelectSent();
        verifyMessage.deleteMessageAndConfirm();
    }
}

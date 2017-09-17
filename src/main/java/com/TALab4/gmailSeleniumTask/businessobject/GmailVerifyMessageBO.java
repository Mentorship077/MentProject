package com.TALab4.gmailSeleniumTask.businessobject;

import com.TALab4.gmailSeleniumTask.pages.GmailVerifyMessage;

/**
 * Created  on 17.09.17.
 */
public class GmailVerifyMessageBO {
    public boolean selectAndDeleteSentMessage() throws InterruptedException {
        GmailVerifyMessage verifyMessage = new GmailVerifyMessage();
        Thread.sleep(1000);
        verifyMessage.checkAndSelectSent();
        Thread.sleep(1000);
        verifyMessage.deleteMessageAndConfirm();
        Thread.sleep(1000);
        return true;
    }
}

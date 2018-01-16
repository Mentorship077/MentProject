package com.mentProject.gmail.businessobject;

import com.mentProject.gmail.pages.GmailVerifyMessagePO;

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

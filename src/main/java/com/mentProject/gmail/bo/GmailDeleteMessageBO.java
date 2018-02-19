package com.mentProject.gmail.bo;

import com.mentProject.gmail.pages.GmailVerifyMessagePO;

/**
 * Created  on 17.09.17.
 */
public class GmailDeleteMessageBO {
    public void delete() {
        GmailVerifyMessagePO verifyMessage = new GmailVerifyMessagePO();
        verifyMessage
                .clickOnAllSentMessagesButton()
                .selectLastSentMessage()
                .deleteMessage()
                .confirmMessageDeleting();
    }
}

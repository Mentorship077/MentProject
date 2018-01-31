package com.mentProject.gmail.bo;

import com.mentProject.gmail.pages.GmailLoginPO;
import com.mentProject.gmail.fileReader.model.User;

public class GmailLoginBO {
    public void login(User user) {
        GmailLoginPO gmailLoginPO = new GmailLoginPO();
        gmailLoginPO.typeLoginAndSubmit(user.getEmail());
        gmailLoginPO.typePasswordAndSubmit(user.getPassword());
    }
}

package com.mentProject.gmail.businessobject;

import com.mentProject.gmail.pages.GmailLoginPO;
import com.mentProject.gmail.parser.model.User;

public class GmailLoginBO {
    public void login(User user) {
        GmailLoginPO gmailLoginPO = new GmailLoginPO();
        gmailLoginPO.typeLoginAndSubmit(user.getEmail());
        gmailLoginPO.typePasswordAndSubmit(user.getPassword());
    }
}

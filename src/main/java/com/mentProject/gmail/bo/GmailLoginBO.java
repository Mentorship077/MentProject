package com.mentProject.gmail.bo;

import com.mentProject.gmail.pages.GmailLoginPO;
import com.mentProject.gmail.fileReader.enterDataGmail.model.User;
import cucumber.api.java.en.Given;

public class GmailLoginBO {

    public void login(User user) {
        GmailLoginPO gmailLoginPO = new GmailLoginPO();
        gmailLoginPO.typeLoginAndSubmit(user.getEmail());
        gmailLoginPO.typePasswordAndSubmit(user.getPassword());
    }
}

package com.TALab4.gmailSeleniumTask.businessobject;

import com.TALab4.gmailSeleniumTask.pages.GmailLoginPO;
import com.TALab4.gmailSeleniumTask.parser.model.User;

public class GmailLoginBO {
    public void login(User user) {
        GmailLoginPO gmailLoginPO = new GmailLoginPO();
        gmailLoginPO.typeLoginAndSubmit(user.getEmail());
        gmailLoginPO.typePasswordAndSubmit(user.getPassword());
    }
}

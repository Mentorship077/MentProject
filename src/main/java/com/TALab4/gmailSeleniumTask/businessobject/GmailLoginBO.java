package com.TALab4.gmailSeleniumTask.businessobject;

import com.TALab4.gmailSeleniumTask.pages.GmailHomePage;
import com.TALab4.gmailSeleniumTask.pages.GmailLoginPage;
import com.TALab4.gmailSeleniumTask.parser.model.User;

public class GmailLoginBO {
    public boolean login(User user) {
        GmailLoginPage gmailLoginPage = new GmailLoginPage();
        gmailLoginPage.typeLoginAndSubmit(user.getEmail());
        GmailHomePage gmailHomePage = gmailLoginPage.typePasswordAndSubmit(user.getPassword());
//        return gmailHomePage.isMyAccountMessageVisible();
        return true;
    }
}

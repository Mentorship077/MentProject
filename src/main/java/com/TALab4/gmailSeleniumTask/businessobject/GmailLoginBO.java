package com.TALab4.gmailSeleniumTask.businessobject;

import com.TALab4.gmailSeleniumTask.model.UserModel;
import com.TALab4.gmailSeleniumTask.pages.GmailHomePage;
import com.TALab4.gmailSeleniumTask.pages.GmailLoginPage;

public class GmailLoginBO {
    public boolean login(UserModel user) {
        GmailLoginPage gmailLoginPage = new GmailLoginPage();
        gmailLoginPage.typeLoginAndSubmit(user.getEmail());
        GmailHomePage gmailHomePage = gmailLoginPage.typePasswordAndSubmit(user.getPassword());
        return gmailHomePage.isMyAccountMessageVisible();
    }
}

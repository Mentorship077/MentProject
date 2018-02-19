package com.mentProject.gmail.fo;

import com.mentProject.gmail.bo.GmailComposeMessageBO;
import com.mentProject.gmail.bo.GmailLoginBO;
import com.mentProject.gmail.bo.GmailDeleteMessageBO;
import com.mentProject.gmail.core.driver.WebDriverManager;
import com.mentProject.gmail.fileReader.enterDataGmail.model.Message;
import com.mentProject.gmail.fileReader.enterDataGmail.model.User;
import com.mentProject.gmail.util.EnvProperties;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationFO {
    private final static EnvProperties prop = EnvProperties.getInstance();
    private GmailComposeMessageBO gmailComposeMessageBO = new GmailComposeMessageBO();
    private GmailLoginBO gmailLoginBO = new GmailLoginBO();
    private GmailDeleteMessageBO gmailDeleteMessageBO = new GmailDeleteMessageBO();


    @Given("^I'm on home page:(.*)$")
    public void gotoURL(String url) {
        WebDriverManager.gotoURL(url);
    }

    @When("^login with credentials:(.*),(.*)$")
    public void login(String email, String password) {
        gmailLoginBO.login(new User(email, password));
    }

    @Then("^Compose email for whom: (.*), subject:(.*), message: (.*)$")
    public void composeMessage(String to, String subject, String textMessage) {
        gmailComposeMessageBO.composeMessage(new Message(to, subject, textMessage));
    }

    @And("^Delete sent message$")
    public void delete() {
        gmailDeleteMessageBO.delete();
    }

}

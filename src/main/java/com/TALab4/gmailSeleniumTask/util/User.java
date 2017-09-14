package com.TALab4.gmailSeleniumTask.util;

import javax.xml.bind.annotation.*;

/**
 * Created  on 14.09.17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
@XmlType(propOrder = {"email","password","to","subject","textMessage"})
public class User {

    private String email;
    private String password;
    private String to;
    private String subject;
    private String textMessage;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getTextMessages() {
        return textMessage;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", textMessages='" + textMessage + '\'' +
                '}';
    }
}

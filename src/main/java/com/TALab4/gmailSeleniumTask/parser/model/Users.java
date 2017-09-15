package com.TALab4.gmailSeleniumTask.parser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Users {
    // the name of field have to be the same
    private List<User> user ;

    @XmlElement
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}

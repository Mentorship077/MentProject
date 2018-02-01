package com.mentProject.gmail.fileReader.enterDataGmail.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Messages {
    // the name of field have to be the same
    private List<Message> message;

    @XmlElement
    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}

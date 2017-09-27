package com.TALab4.gmailSeleniumTask.parser.model;

public class Message {
    private String to;
    private String subject;
    private String textMessage;

    @Override
    public String toString() {
        return "Message{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", textMessage='" + textMessage + '\'' +
                '}';
    }

    public Message() {
    }

    public Message(String to, String subject, String textMessage) {
        this.to = to;
        this.subject = subject;
        this.textMessage = textMessage;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}

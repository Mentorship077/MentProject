package com.TALab4.gmailSeleniumTask.parser;

import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.User;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface AbstractParser {
    List<User> parseUsers() throws IOException, JAXBException;
    List<Message> parseMessages() throws IOException, JAXBException;


    // csv properties
    String USERS_CSV_PATH = "src/test/resources/csv/users.csv";
    String MESSAGES_CSV_PATH = "src/test/resources/csv/messages.csv";
    // xml properties
    String USERS_XML_PATH = "src/test/resources/xml/users.xml";
    String MESSAGES_XML_PATH = "src/test/resources/xml/messages.xml";
    // excel properties
    String USERS_XLSX_PATH = "src/test/resources/xlsx/users.xlsx";
    String MESSAGES_XLSX_PATH = "src/test/resources/xlsx/messages.xlsx";
    int ROW_NUMBER = 5;
    String USER_SHEET = "users";
    String MESSAGE_SHEET = "messages";
}

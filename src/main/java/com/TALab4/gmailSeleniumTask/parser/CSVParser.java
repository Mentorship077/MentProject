package com.TALab4.gmailSeleniumTask.parser;

import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.User;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    private static final String USERS_XML_PATH = "src/test/resources/csv/users.csv";
    private static final String MESSAGES_XML_PATH = "src/test/resources/csv/messages.csv";

    public static List<User> csvUserParser() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(USERS_XML_PATH), ',');
        List<User> users = new ArrayList<>();
        String[] record = null;
        while ((record = reader.readNext()) != null) {
            User emp = new User();
            emp.setEmail(record[0]);
            emp.setPassword(record[1]);
            users.add(emp);
        }
        reader.close();
        return users;
    }

    public static List<Message> csvMessageParser() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(MESSAGES_XML_PATH), ',');
        List<Message> messages = new ArrayList<>();
        String[] record = null;
        while ((record = reader.readNext()) != null) {
            Message message = new Message();
            message.setTo(record[0]);
            message.setSubject(record[1]);
            message.setTextMessage(record[2]);
            messages.add(message);
        }
        reader.close();
        return messages;
    }
}

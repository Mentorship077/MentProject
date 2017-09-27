package com.TALab4.gmailSeleniumTask.parser;

import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.User;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static void main(String[] args) throws IOException {

        csvUserParser();
    }

    private static Object[] csvUserParser() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/users.csv"), ',');
        List<User> emps = new ArrayList<>();
        String[] record = null;
        while ((record = reader.readNext()) != null) {
            User emp = new User();
            emp.setEmail(record[0]);
            emp.setPassword(record[1]);
            emps.add(emp);
        }
        reader.close();
        return emps.toArray();
    }
    private static Object[] csvmESSAGEParser() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/messages.csv"), ',');
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
        return messages.toArray();
    }
}

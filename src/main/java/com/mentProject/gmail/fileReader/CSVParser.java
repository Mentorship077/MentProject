package com.mentProject.gmail.fileReader;

import com.mentProject.gmail.fileReader.model.Message;
import com.mentProject.gmail.fileReader.model.User;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser implements AbstractParser {
    private static final char COMA_SEPERATOR = ',';

    @Override
    public List<User> parseUsers() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(USERS_CSV_PATH), COMA_SEPERATOR);
        List<User> users = new ArrayList<>();
        String[] record = null;
        while ((record = reader.readNext()) != null) {
            users.add(new User(record[0], record[1]));
        }
        reader.close();
        return users;
    }

    @Override
    public List<Message> parseMessages() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(MESSAGES_CSV_PATH), COMA_SEPERATOR);
        List<Message> messages = new ArrayList<>();
        String[] record = null;
        while ((record = reader.readNext()) != null) {
            messages.add(new Message(record[0], record[1], record[2]));
        }
        reader.close();
        return messages;
    }
}

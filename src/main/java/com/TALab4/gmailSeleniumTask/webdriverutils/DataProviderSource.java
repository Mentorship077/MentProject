package com.TALab4.gmailSeleniumTask.webdriverutils;

import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.User;
import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 17.09.17.
 */
public class DataProviderSource {
    @DataProvider(name = "usersAndMessages",parallel = true)
    public static Object[][] getUsersAndMessages() throws JAXBException, IOException {
//        List<User> usersList = XMLParser.parseUsers();
//        List<Message> messageList = XMLParser.parseMessages();
        return generateDemensionArray(csvUserParser(), csvMessageParser());
    }

    private static Object[][] generateDemensionArray(List userList, List messages) {
        Object[][] objArray = new Object[userList.size()][];
        for (int i = 0; i < userList.size(); i++) {
            objArray[i] = new Object[2];
            objArray[i][0] = userList.get(i);
            objArray[i][1] = messages.get(i);
        }
        return objArray;
    }
    private static List<User> csvUserParser() throws IOException {
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
        return emps;
    }
    private static List<Message> csvMessageParser() throws IOException {
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
        return messages;
    }

   /* @Test(dataProvider = "usersAndMessages")
    public void gmailTest(User userList,Message messageList) throws JAXBException, InterruptedException {
        System.out.println(userList);
        System.out.println(messageList);
    }*/

}

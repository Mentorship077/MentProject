package com.TALab4.gmailSeleniumTask.webdriverutils;

import com.TALab4.gmailSeleniumTask.parser.CSVParser;
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
        return generateDemensionArray(CSVParser.csvUserParser(), CSVParser.csvMessageParser());
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


   /* @Test(dataProvider = "usersAndMessages")
    public void gmailTest(User userList,Message messageList) throws JAXBException, InterruptedException {
        System.out.println(userList);
        System.out.println(messageList);
    }*/

}

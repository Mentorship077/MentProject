package com.TALab4.gmailSeleniumTask.util;

import com.TALab4.gmailSeleniumTask.parser.XMLParser;
import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created  on 17.09.17.
 */
public class DataProviderSource {
    @DataProvider(name = "usersAndMessages")
    public static Object[][] getUsersAndMessages() throws JAXBException {
        List<User> usersList = XMLParser.parseUsers();
        List<Message> messageList = XMLParser.parseMessages();
        return generateDemensionArray(usersList, messageList);
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

package com.mentProject.gmail.webdriverutils;

import com.mentProject.gmail.parser.AbstractParser;
import com.mentProject.gmail.parser.XMLParser;
import org.testng.annotations.DataProvider;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * Created  on 17.09.17.
 */
public class DataProviderSource {
    @DataProvider(name = "usersAndMessages", parallel = true)
    public static Object[][] getUsersAndMessages() throws JAXBException, IOException {
        AbstractParser parser = new XMLParser();
        return generateDemensionArray(parser.parseUsers(), parser.parseMessages());
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
}

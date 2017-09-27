package com.TALab4.gmailSeleniumTask.parser;

import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.Messages;
import com.TALab4.gmailSeleniumTask.parser.model.User;
import com.TALab4.gmailSeleniumTask.parser.model.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * This class parse  xml files and return list of objects,
 * after that we can iterate than and retrieve info. (getEmail, ...)
 * <p>
 * For example: <pre>{@code
 *      XMLParser parserJAXB = new XMLParser();
 *      List<User> users = parserJAXB.parseUsers();
 *       for (User user: users) {
 *          user.getEmail();
 *       }
 *      }</pre>
 * Created  on 14.09.17.
 */
public class XMLParser {
    private static final String USERS_XML_PATH = "src/test/resources/xml/users.xml";
    private static final String MESSAGES_XML_PATH = "src/test/resources/xml/messages.xml";

    public static List<Message> parseMessages() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Messages.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Messages messages = (Messages) jaxbUnmarshaller.unmarshal(new File(MESSAGES_XML_PATH));
        return messages.getMessage();
    }

    public static List<User> parseUsers() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Users users = (Users) jaxbUnmarshaller.unmarshal(new File(USERS_XML_PATH));
        return users.getUser();
    }
}

package com.TALab4.gmailSeleniumTask;

import com.TALab4.gmailSeleniumTask.util.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created  on 14.09.17.
 */
public class JAXB {
    private static final String FILE_NAME = "src/main/resources/users.xml";

    public static void main(String[] args) throws JAXBException {
        File file = new File(FILE_NAME);
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        User museums = (User) jaxbUnmarshaller.unmarshal(file);
        System.out.println(museums);
        System.out.println(museums.getEmail());
    }
}

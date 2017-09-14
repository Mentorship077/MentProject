package com.TALab4.gmailSeleniumTask.util;

import org.apache.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

/**
 * Created  on 05.08.17.
 */
public class UserStAX {
    private final static Logger LOG = Logger.getLogger(UserStAX.class);

    public void parseXmlFile(String xmlPath) {
        boolean bEmail = false;
        boolean bPassword = false;
        boolean bTo = false;
        boolean bSubject = false;
        boolean bTextMessage = false;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(
                            new FileReader(xmlPath));

            while ((eventReader.hasNext())) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase(UserDetails.user.name())) {
                            LOG.info("Start Element: user");
                            Iterator<Attribute> attribute = startElement.getAttributes();
                            String userNo = attribute.next().getValue();
                            LOG.info("User_No : " + userNo);
                        } else if (qName.equalsIgnoreCase(UserDetails.email.name())) {
                            bEmail = true;
                        } else if (qName.equalsIgnoreCase(UserDetails.password.name())) {
                            bPassword = true;
                        } else if (qName.equalsIgnoreCase(UserDetails.to.name())) {
                            bTo = true;
                        }else  if(qName.equalsIgnoreCase(UserDetails.subject.name())){
                            bSubject = true;
                        } else  if (qName.equalsIgnoreCase(UserDetails.textMessage.name())){
                            bTextMessage =true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (bEmail) {
                            LOG.info("FirstName: " + characters.getData());
                            bEmail = false;
                        }
                        if (bPassword) {
                            LOG.info("LastName: " + characters.getData());
                            bPassword = false;
                        }
                        if (bTo) {
                            LOG.info("Type : " + characters.getData());
                            bTo = false;
                        }
                        if (bSubject) {
                            LOG.info("Type : " + characters.getData());
                            bSubject = false;
                        }
                        if (bTextMessage) {
                            LOG.info("Type : " + characters.getData());
                            bTextMessage = false;
                        }

                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase(UserDetails.user.name())) {
                            LOG.info("End element :  user");
                            System.out.println();
                        }
                        break;
                }

            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

}

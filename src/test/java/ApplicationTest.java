import com.TALab4.gmailSeleniumTask.businessobject.GmailComposeMessageBO;
import com.TALab4.gmailSeleniumTask.businessobject.GmailLoginBO;
import com.TALab4.gmailSeleniumTask.businessobject.GmailVerifyMessageBO;
import com.TALab4.gmailSeleniumTask.parser.XMLParser;
import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.User;
import com.TALab4.gmailSeleniumTask.util.EnvProperties;
import com.TALab4.gmailSeleniumTask.webdriverutils.WebDriverSingleton;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created  on 10.09.17.
 */
public class ApplicationTest extends Assert {
    private final static EnvProperties prop = EnvProperties.getInstance();
    private final static Logger LOG = Logger.getLogger(ApplicationTest.class);

    // Business objects
    private final GmailLoginBO loginBO = new GmailLoginBO();
    private final GmailComposeMessageBO composeMessageBO = new GmailComposeMessageBO();
    private final GmailVerifyMessageBO verifyMessageBO = new GmailVerifyMessageBO();

    @AfterTest
    public void quitTheBrowser() {
        WebDriverSingleton.quitTheBrowser();
    }

    @Test
    public void gmailTest() throws JAXBException, InterruptedException {
        WebDriverSingleton.gotoURL(prop.getBaseUrl());
        WebDriverSingleton.clickFirstLink("//*[@data-g-label=\"Sign in\"]");

        List<User> users = XMLParser.parseUsers();
        boolean isLoggedIn = loginBO.login(users.get(0));
        assertTrue(isLoggedIn);

        List<Message> messages = XMLParser.parseMessages();
        boolean isComposedMessage = composeMessageBO.composeMessage(messages.get(0));
        assertTrue(isComposedMessage);

        boolean isSelectedAndDeletedMessage = verifyMessageBO.selectAndDeleteSentMessage();
        assertTrue(isSelectedAndDeletedMessage);

    }
}


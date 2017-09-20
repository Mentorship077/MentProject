import com.TALab4.gmailSeleniumTask.businessobject.GmailComposeMessageBO;
import com.TALab4.gmailSeleniumTask.businessobject.GmailLoginBO;
import com.TALab4.gmailSeleniumTask.businessobject.GmailVerifyMessageBO;
import com.TALab4.gmailSeleniumTask.parser.XMLParser;
import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.User;
import com.TALab4.gmailSeleniumTask.util.DataProviderSource;
import com.TALab4.gmailSeleniumTask.util.EnvProperties;
import com.TALab4.gmailSeleniumTask.webdriverutils.WebDriverSingleton;
import org.apache.log4j.Logger;
import org.testng.Assert;
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


    @Test(dataProvider = "usersAndMessages", threadPoolSize = 3, dataProviderClass = DataProviderSource.class)
    public void gmailTest(User userList, Message messageList) throws JAXBException, InterruptedException {
        try {
            WebDriverSingleton.gotoURL(prop.getBaseUrl());
            WebDriverSingleton.clickFirstLink(prop.getFirstSignInLink());

            boolean isLoggedIn = loginBO.login(userList);
            assertTrue(isLoggedIn);
            boolean isComposedMessage = composeMessageBO.composeMessage(messageList);
            assertTrue(isComposedMessage);
            boolean isSelectedAndDeletedMessage = verifyMessageBO.selectAndDeleteSentMessage();
            assertTrue(isSelectedAndDeletedMessage);
        } finally {
            WebDriverSingleton.quitTheBrowser();
        }
    }
}


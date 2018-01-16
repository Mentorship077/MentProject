import com.mentProject.gmail.businessobject.GmailComposeMessageBO;
import com.mentProject.gmail.businessobject.GmailLoginBO;
import com.mentProject.gmail.businessobject.GmailVerifyMessageBO;
import com.mentProject.gmail.parser.model.Message;
import com.mentProject.gmail.parser.model.User;
import com.mentProject.gmail.util.EnvProperties;
import com.mentProject.gmail.webdriverutils.DataProviderSource;
import com.mentProject.gmail.webdriverutils.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;

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


    @Test(successPercentage = 75, dataProvider = "usersAndMessages", threadPoolSize = 3, dataProviderClass = DataProviderSource.class)
    public void gmailTest(User userList, Message messageList) throws JAXBException, InterruptedException {
        WebDriverManager.gotoURL(prop.getBaseUrl());

        loginBO.login(userList);
        composeMessageBO.composeMessage(messageList);
        verifyMessageBO.selectAndDeleteSentMessage();
    }

    @AfterMethod
    public void quitTheMethod() {
        WebDriverManager.quitTheBrowser();
    }
}


import com.mentProject.gmail.businessobject.GmailComposeMessageBO;
import com.mentProject.gmail.businessobject.GmailLoginBO;
import com.mentProject.gmail.businessobject.GmailVerifyMessageBO;
import com.mentProject.gmail.fileReader.model.Message;
import com.mentProject.gmail.fileReader.model.User;
import com.mentProject.gmail.util.EnvProperties;
import com.mentProject.gmail.util.DataProviderSource;
import com.mentProject.gmail.core.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created  on 10.09.17.
 */
public class ApplicationTest {
    private final static EnvProperties prop = EnvProperties.getInstance();
    private final static Logger LOG = Logger.getLogger(ApplicationTest.class);

    // Business objects
    private final GmailLoginBO loginBO = new GmailLoginBO();
    private final GmailComposeMessageBO composeMessageBO = new GmailComposeMessageBO();
    private final GmailVerifyMessageBO verifyMessageBO = new GmailVerifyMessageBO();


    @Test(dataProvider = "usersAndMessages", dataProviderClass = DataProviderSource.class)
    public void gmailTest(User userList, Message messageList){
        WebDriverManager.gotoURL(prop.getBaseUrl());
        loginBO.login(userList);
//        Thread.sleep(6000);
//        composeMessageBO.composeMessage(messageList);
//        verifyMessageBO.selectAndDeleteSentMessage();
    }

    @AfterMethod
    public void quitTheMethod() {
        WebDriverManager.quitTheBrowser();
    }
}


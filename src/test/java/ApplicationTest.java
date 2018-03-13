import com.mentProject.gmail.bo.GmailComposeMessageBO;
import com.mentProject.gmail.bo.GmailLoginBO;
import com.mentProject.gmail.bo.GmailDeleteMessageBO;
import com.mentProject.gmail.fileReader.enterDataGmail.model.Message;
import com.mentProject.gmail.fileReader.enterDataGmail.model.User;
import com.mentProject.gmail.util.EnvProperties;
import com.mentProject.gmail.util.DataProviderSource;
import com.mentProject.gmail.core.driver.WebDriverManager;
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
    private final GmailDeleteMessageBO verifyMessageBO = new GmailDeleteMessageBO();


    @Test(dataProvider = "usersAndMessages", dataProviderClass = DataProviderSource.class)
    public void gmailTest(User userList, Message messageList){
        WebDriverManager.gotoURL(prop.getBaseURL());
        loginBO.login(userList);
        composeMessageBO.compose(messageList);
        verifyMessageBO.delete();
    }

    @AfterMethod
    public void quitTheMethod() {
        WebDriverManager.quitTheBrowser();
    }
}
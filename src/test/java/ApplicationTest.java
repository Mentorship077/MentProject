import com.TALab4.gmailSeleniumTask.businessobject.GmailComposeMessageBO;
import com.TALab4.gmailSeleniumTask.businessobject.GmailLoginBO;
import com.TALab4.gmailSeleniumTask.businessobject.GmailVerifyMessageBO;
import com.TALab4.gmailSeleniumTask.parser.XMLParser;
import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.User;
import com.TALab4.gmailSeleniumTask.util.EnvProperties;
import com.TALab4.gmailSeleniumTask.webdriverutils.WebDriverUtils;
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
        WebDriverUtils.quitTheBrowser();
    }

    @Test
    public void gmailTest() throws JAXBException, InterruptedException {
        WebDriverUtils.gotoURL(prop.getBaseUrl());
        WebDriverUtils.clickFirstLink("//*[@data-g-label=\"Sign in\"]");

        List<User> users = XMLParser.parseUsers();
        loginBO.login(users.get(0));
        List<Message> messages = XMLParser.parseMessages();
        composeMessageBO.composeMessage(messages.get(0));
        verifyMessageBO.selectAndDeleteSentMessage();
//        for (User user: users) {
//            System.out.println(user.getEmail());
//        }

//        List<UserModel> model = DataUtils.readUsers("/user.xml");

//        assertTrue(isLoggedIn);
        // Verify that user is logged in
//       assertTrue("User is not located on GmailHomePage", isLoggedIn);
    }

  /*  @Test
    public void gmailLogin() {
        driver.findElement(By.xpath("//a[text()='Войти']")).click();

//        new GmailLoginPage(driver).emailLogin(emailValue,passwordValue);
        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.setEmail(utilBundle.getString("email"));
        gmailLoginPage.submitEmail();
        gmailLoginPage.setPassword(utilBundle.getString("password"));
        gmailLoginPage.submitPassword();
    }

    @Test(dependsOnMethods = {"gmailLogin"})
    public void composeMessage() {
        GmailComposeMessagePage createMessagePage = new GmailComposeMessagePage(driver);
        createMessagePage.clickCreateMessage();
        createMessagePage.fillTo(utilBundle.getString("to"));
        createMessagePage.fillSubject(utilBundle.getString("subject"));
        createMessagePage.fillTextMessage(utilBundle.getString("textMessage"));
        createMessagePage.sentMessage();
    }

    @Test(dependsOnMethods = {"composeMessage"})
    public void verifyMessage() {
        GmailVerifyMessage gmailVerifyMessage = new GmailVerifyMessage(driver);
        gmailVerifyMessage.openSent();
        gmailVerifyMessage.checkMessage();
        gmailVerifyMessage.deleteMessageAndConfirm();
    }

    @Test(dependsOnMethods = {"verifyMessage"})
    public void deleteMessageAndConfirm() {
        GmailVerifyMessage gmailVerifyMessage = new GmailVerifyMessage(driver);
        gmailVerifyMessage.deleteMessageAndConfirm();

    }*/
}


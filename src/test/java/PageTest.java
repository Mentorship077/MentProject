import com.TALab4.gmailSeleniumTask.pages.GmailCreateMessagePage;
import com.TALab4.gmailSeleniumTask.pages.GmailLoginPage;
import com.TALab4.gmailSeleniumTask.pages.GmailVerifyMessage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created  on 10.09.17.
 */
public class PageTest extends Assert {
    // Business objects


    private final static Logger LOG = Logger.getLogger(PageTest.class);
    private final static ResourceBundle utilBundle = ResourceBundle.getBundle("util");

    private final static String CHROME_DRIVER_PATH = utilBundle.getString("CHROME_DRIVER_PATH");
    private final static String FIRST_PAGE = "https://www.google.com/intl/ru/gmail/about/";

    private WebDriver driver;

    @BeforeTest
    public void startTheBrowser() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();

        driver.get(FIRST_PAGE);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }

    @AfterTest
    public void quitTheBrowser() {
        driver.quit();
    }

    @Test
    public void gmailTest(){

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
        GmailCreateMessagePage createMessagePage = new GmailCreateMessagePage(driver);
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
        gmailVerifyMessage.deleteMessage();
    }

    @Test(dependsOnMethods = {"verifyMessage"})
    public void deleteMessage() {
        GmailVerifyMessage gmailVerifyMessage = new GmailVerifyMessage(driver);
        gmailVerifyMessage.deleteMessage();

    }*/
}


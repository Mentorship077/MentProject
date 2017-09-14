import com.TALab4.gmailSeleniumTask.pages.CreateMessagePage;
import com.TALab4.gmailSeleniumTask.pages.SingUpPage;
import com.TALab4.gmailSeleniumTask.pages.VerifyMessage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created  on 10.09.17.
 */
public class PageTest {
    private final static Logger LOG = Logger.getLogger(PageTest.class);
    private final static ResourceBundle userBundle = ResourceBundle.getBundle("user");

    private static ChromeDriverService service;
    private WebDriver driver;


    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @BeforeTest
    public void createDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/intl/ru/gmail/about/");

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void gmailLogin() {
        driver.findElement(By.xpath("//a[text()='Войти']")).click();

//        new SingUpPage(driver).emailLogin(emailValue,passwordValue);
        SingUpPage singUpPage = new SingUpPage(driver);
        singUpPage.setEmail(userBundle.getString("email"));
        singUpPage.submitEmail();
        singUpPage.setPassword(userBundle.getString("password"));
        singUpPage.submitPassword();
    }

    @Test(dependsOnMethods = {"gmailLogin"})
    public void composeMessage() {
        CreateMessagePage createMessagePage = new CreateMessagePage(driver);
        createMessagePage.clickCreateMessage();
        createMessagePage.fillTo(userBundle.getString("to"));
        createMessagePage.fillSubject(userBundle.getString("subject"));
        createMessagePage.fillTextMessage(userBundle.getString("textMessage"));
        createMessagePage.sentMessage();
    }

    @Test(dependsOnMethods = {"composeMessage"})
    public void verifyMessage() {
        VerifyMessage verifyMessage = new VerifyMessage(driver);
        verifyMessage.openSent();
        verifyMessage.checkMessage();
        verifyMessage.deleteMessage();
    }

    @Test(dependsOnMethods = {"verifyMessage"})
    public void deleteMessage() {
        VerifyMessage verifyMessage = new VerifyMessage(driver);
        verifyMessage.deleteMessage();

    }
}


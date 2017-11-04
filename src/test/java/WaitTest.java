import com.TALab4.gmailSeleniumTask.util.WaitManager;
import com.TALab4.gmailSeleniumTask.webdriverutils.WebDriverManager;
import org.testng.annotations.Test;

public class WaitTest {
    private String SLOW_WEB_SITE = "https://tools.pingdom.com/";
    protected WaitManager waitManager = new WaitManager();

    @Test
    public void waitForLoadTest(){
        WebDriverManager.gotoURL(SLOW_WEB_SITE);
        long initalSpeed = System.currentTimeMillis();
//        waitManager.waitTillPageLoadedCustom();
        long secondarySpeed = System.currentTimeMillis();
        System.out.format("Result speed : %d \n",secondarySpeed-initalSpeed);
        WebDriverManager.quitTheBrowser();
    }
}

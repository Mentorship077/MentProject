import com.TALab4.gmailSeleniumTask.webdriverutils.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created  on 17.09.17.
 */
public class TestParallelOne {
    WebDriver driver = WebDriverSingleton.getInstance();

    @Test
    public void testCaseOne() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
        System.out.println("Test Case One with Thread Id:- "
        //Printing Id of the thread on using which test method got executed
                + Thread.currentThread().getId());
    }

    @Test
    public void testCaseTwo() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
        ////Printing Id of the thread on using which test method got executed
        System.out.println("Test Case two with Thread Id:- "
                + Thread.currentThread().getId());
    }
}

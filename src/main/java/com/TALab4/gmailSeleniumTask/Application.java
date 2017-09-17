/*
package com.TALab4.gmailSeleniumTask;

import com.TALab4.gmailSeleniumTask.pages.GmailCreateMessagePage;
import com.TALab4.gmailSeleniumTask.pages.GmailLoginPage;
import com.TALab4.gmailSeleniumTask.pages.GmailVerifyMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

*/
/**
 * Created  on 11.09.17.
 *//*

public class Application {
    private static final String PATH_USERS_XML = "src/main/resources/users.xml";

    private final static ResourceBundle userBundle = ResourceBundle.getBundle("user");

    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/intl/ru/gmail/about/");
        driver.findElement(By.xpath("//a[text()='Войти']")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        new GmailLoginPage(driver).emailLogin(userBundle.getString("email"),userBundle.getString("password"));
        new GmailComposeMessagePage(driver).generalCreteMessage(userBundle.getString("to"), userBundle.getString("subject"), userBundle.getString("textMessage"));

       GmailVerifyMessage gmailVerifyMessage = new GmailVerifyMessage(driver);
       gmailVerifyMessage.openSent();
       gmailVerifyMessage.checkMessage();
       gmailVerifyMessage.deleteMessageAndConfirm();

       driver.quit();
    }
}
*/

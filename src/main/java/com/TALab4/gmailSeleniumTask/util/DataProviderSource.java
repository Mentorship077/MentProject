package com.TALab4.gmailSeleniumTask.util;
import org.testng.annotations.DataProvider;

/**
 * Created  on 17.09.17.
 */
public class DataProviderSource {
    @DataProvider(name="client1")
    public static Object[][] getClient1Data() {
        return new Object[][]{{1}};
    }

    @DataProvider(name="client2")
    public static Object[][] getClient2Data() {
        return new Object[][]{{2}};
    }
}

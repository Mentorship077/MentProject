package com.TALab4.gmailSeleniumTask.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Used for retrieved info from proprties file
 * Created  on 16.09.17.
 */
public class EnvProperties {
    private static final String UTIL_PROPERTIES_PATH = "src/main/resources/util.properties";
    private static EnvProperties instance;
    private Properties properties;

    private EnvProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(
                    new File(UTIL_PROPERTIES_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EnvProperties getInstance() {
        if (instance == null) {
            instance = new EnvProperties();
        }
        return instance;
    }

    public String getBaseUrl() {
        return properties.getProperty("FIRST_PAGE");
    }
    public String getChomeDriverPath() {
        return properties.getProperty("CHROME_DRIVER_PATH");
    }
}

package com.loopdfs.cardproject.commons.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtils {
    public static Properties getConfigProperties(String propFileName,
                                                 ClassLoader classLoader) {
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            inputStream = classLoader.getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            }
        } catch (IOException e) {
            // Ignore - here we return empty properties
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
        return prop;
    }
}

package ru.job4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by VLADIMIR on 04.02.2017.
 */
public class Settings {

    /**
     * Properties.
     */
    private Properties properties = new Properties();

    /**
     * Constructor.
     * @param propertiesFileName - file name.
     */
    public Settings(String propertiesFileName) {
        ClassLoader classLoader = Settings.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(propertiesFileName)) {
            this.properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get value.
     * @param key - key.
     * @return - value.
     */
    public String getValue(String key) {
        return this.properties.getProperty(key);
    }

}

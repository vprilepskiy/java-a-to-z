package ru.job4j.manager;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by VLADIMIR on 04.02.2017.
 */
public class Settings {

    private Properties properties = new Properties();

    // загружаем файл в properties
    public Settings(String propertiesFileName) throws IOException {
        ClassLoader classLoader = Settings.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(propertiesFileName)) {
            this.properties.load(inputStream);
        }
    }

    // читаем properties файл
    public String getValue(String key) {
        return this.properties.getProperty(key);
    }

}

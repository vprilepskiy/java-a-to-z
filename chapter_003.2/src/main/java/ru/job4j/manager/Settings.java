package ru.job4j.manager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class Settings implements ISettings {

    /**
     * Конструктор.
     * @param propertiesFileName - файл настроек.
     */
    public Settings(String propertiesFileName) {
        ClassLoader classLoader = Settings.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(propertiesFileName)) {
            this.properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getValue(String key) {
        return this.properties.getProperty(key);
    }
}

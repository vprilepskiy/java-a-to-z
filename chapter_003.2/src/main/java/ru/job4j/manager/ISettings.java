package ru.job4j.manager;

import java.util.Properties;

/**
 * Created by VLADIMIR on 13.02.2017.
 */
public interface ISettings {

    /**
     * Свойства.
     */
    Properties properties = new Properties();

    /**
     * Возвращает значение по ключу
     * @param key
     * @return
     */
    public String getValue(String key);

}

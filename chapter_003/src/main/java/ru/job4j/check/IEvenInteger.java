package ru.job4j.check;

import java.io.InputStream;

/**
 * Created by VLADIMIR on 16.01.2017.
 */
public interface IEvenInteger {

    /**
     * Проверяет, является ли число четным.
     * @param in - входной поток.
     * @return - true если число четное.
     */
    boolean isNumber(InputStream in);

}

package ru.job4j.words;


import java.io.InputStream;

/**
 * Created by VLADIMIR on 21.01.2017.
 */
public interface IValidPalindrome {

    /**
     * Проверяет является ли слово палиндромом из пяти букв.
     *
     * @param inputStream - входной поток.
     * @return - true если слово палиндромом из пяти букв.
     */
    boolean fiveLetters(InputStream inputStream);

}

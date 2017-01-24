package ru.job4j.words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by VLADIMIR on 21.01.2017.
 */
public class ValidPalindrome implements IValidPalindrome {
    @Override
    public boolean fiveLetters(InputStream inputStream) {
        final int wordLengh = 5;
        boolean result = false;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String word = null;
        try {
            word = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ((word.length() == wordLengh) && (new StringBuilder(word).reverse().toString()).equalsIgnoreCase(word)) {
            result = true;
        }
        return result;
    }
}

package ru.job4j.words;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;

/**
 * Created by VLADIMIR on 16.01.2017.
 */
public class BadWord implements IBadWord {
    @Override
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            line = deleteBadWords(line, abuse);
            out.write(line.getBytes());
        }
    }

    /**
     * Удалит плохие слова.
     * @param line - Текст.
     * @param badWords - Плохие слова.
     * @return - Исправленный текст.
     */
    public String deleteBadWords(String line, String[] badWords) {
        for (String badWord : badWords) {
            line = line.replaceAll(badWord, "");
        }
        return line;
    }
}

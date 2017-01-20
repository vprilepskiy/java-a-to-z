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
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder stringBuilder = new StringBuilder();
        String newLine = "";
        String line;
        try {
            while ((line = br.readLine()) != null) {
                // записать перенос строки
                stringBuilder.append(newLine);
                // записать исправленную строку
                stringBuilder.append(deleteBadWords(line, abuse));
                // отослать в поток
                out.write(stringBuilder.toString().getBytes());
                newLine = "\n";
                // очистить
                stringBuilder.delete(0, stringBuilder.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
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

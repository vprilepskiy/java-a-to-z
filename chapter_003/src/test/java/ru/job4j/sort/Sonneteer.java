package ru.job4j.sort;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by VLADIMIR on 29.01.2017.
 */
public class Sonneteer {

    /**
     * Метод создаст текстовый файл размером около 4Гб.
     *
     * @param pathFile - путь куда сохранить файл.
     */
    public void writeDifferentWords(String pathFile) {
        new File(pathFile).delete();
        FileWriter fileWriter = null;
        final String letters = "qwertyuiop asdfghjkl zxcvbnm";

        try {
            fileWriter = new FileWriter(pathFile, true);

            final int maxNumberLettersInString = 200;
            final int maxNumberString = 40000000;

            // цикл строк
            for (int countString = 0; countString < maxNumberString; countString++) {
                int randomNumberLettersInString = this.getRandomNumber(maxNumberLettersInString);
                // цикл букв.
                for (int countLettersInString = 0; countLettersInString < randomNumberLettersInString; countLettersInString++) {
                    int randomIndexLetter = this.getRandomNumber(letters.length());
                    fileWriter.append(letters.toCharArray()[randomIndexLetter]);
                }
                fileWriter.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                /*NONE*/
            }
        }
    }

    /**
     * Генерирует случайное число.
     * @param maxValue - максимальное значение.
     * @return - случайное число.
     */
    private int getRandomNumber(int maxValue) {
        return Math.abs(new Random().nextInt() % maxValue);
    }

    @Test
    public void testWriteDifferentWords() {
        this.writeDifferentWords("C:\\Downloads\\bookRandom.txt");
    }
}

package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * Created by VLADIMIR on 29.01.2017.
 */
public class ReadAndWriteFile {

    /**
     * Прочитает файл.
     * @param pathFile - путь к файлу.
     * @return - прочитанная строка.
     */
    public String readFile(String pathFile){
        FileReader fileReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new FileReader(pathFile);
            int oneByte;
            while ((oneByte = fileReader.read()) != -1) {
                stringBuilder.append((char) oneByte);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                /*NONE*/
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Запишет строку в файл.
     * @param pathFile - путь к файлу.
     * @param body - строка.
     */
    public void writeFile(String pathFile, String body) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pathFile);
            fileWriter.write(body);
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

    @Test
    public void testHimself(){
        final String pathFile = System.getProperty("java.io.tmpdir") + "\\testFile.tmp";
        final String body = "Test string\nfor test himself";
        this.writeFile(pathFile, body);
        Assert.assertThat(body, Is.is(this.readFile(pathFile)));
        new File(pathFile).delete();
    }

}

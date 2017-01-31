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
     * @param file - файл для чтения.
     * @return - прочитанная строка.
     */
    public String readFile(File file){
        FileReader fileReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new FileReader(file);
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
     * @param file - файл для записи.
     * @param body - строка.
     */
    public void writeFile(File file, String body) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
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
        final String body = "Test string\nfor testOverwriteFileOnMap himself";
        File file = new File(pathFile);
        this.writeFile(file, body);
        Assert.assertThat(body, Is.is(this.readFile(file)));
        new File(pathFile).delete();
    }
}

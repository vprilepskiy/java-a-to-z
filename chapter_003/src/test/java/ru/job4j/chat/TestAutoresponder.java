package ru.job4j.chat;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


import static org.hamcrest.core.Is.is;

/**
 * Created by VLADIMIR on 22.01.2017.
 */
public class TestAutoresponder {

    /**
     * Test.
     * @throws IOException - упадет если не прочитается файл.
     */
    @Test
    public void testGetRandomWord() throws IOException {
        boolean result = true;
        final int count = 100;
        for (int i = 0; i <= count; i++) {
            if ((new Autoresponder().getRandomWord(System.getProperty("user.dir") + "//pom.xml")) == null) {
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);
    }


    /**
     * Test.
     * @throws IOException - IOException.
     */
    @Test
    public void testAutoBot() throws IOException {
        String pathWordBook = System.getProperty("user.dir") + "//book.txt";
        String pathLog = System.getProperty("user.dir") + "//log.txt";
        final String[] allCommands = {"Hello", "stop", "the log record is", "start", "world!!!", "exit"};

        StringBuilder stringBuilder = new StringBuilder();
        for (String command : allCommands) {
            stringBuilder.append(command);
            stringBuilder.append("\n");
        }

        // отправим в системный поток команды
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes());
        System.setIn(byteArrayInputStream);

        // вызываем тестируемый метод
        new Autoresponder().autoBot(pathWordBook, pathLog);
        byteArrayInputStream.close();

        // читаем лог файл
        FileInputStream fileInputStream = new FileInputStream(pathLog);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // сравнивем лог с отправляемыми командами
        int index = 0;
        Assert.assertThat(allCommands[index++], is(bufferedReader.readLine()));
        Assert.assertNotNull(bufferedReader.readLine());
        Assert.assertThat(allCommands[index++], is(bufferedReader.readLine()));
        Assert.assertThat(allCommands[index++], is(bufferedReader.readLine()));
        Assert.assertThat(allCommands[index++], is(bufferedReader.readLine()));
        Assert.assertNotNull(bufferedReader.readLine());
        Assert.assertThat(allCommands[index++], is(bufferedReader.readLine()));
        Assert.assertNotNull(bufferedReader.readLine());
        Assert.assertThat(allCommands[index++], is(bufferedReader.readLine()));

        // закрываем ресурсы
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
    }

}

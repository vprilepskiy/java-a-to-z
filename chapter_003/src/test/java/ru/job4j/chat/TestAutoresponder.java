package ru.job4j.chat;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;

/**
 * Created by VLADIMIR on 22.01.2017.
 */
public class TestAutoresponder {

    /**
     *
     * @throws IOException
     */
    @Test
    public void testGutoresponder() throws IOException {
        boolean result = true;
        int count = 100;
        for (int i = 0; i <= count; i++) {
            if ((new Autoresponder().getRandomWord(System.getProperty("user.dir") + "//pom.xml")) == null) {
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void test0() throws IOException {
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
        Assert.assertThat(allCommands[0], is(bufferedReader.readLine()));
        Assert.assertNotNull(bufferedReader.readLine());
        Assert.assertThat(allCommands[1], is(bufferedReader.readLine()));
        Assert.assertThat(allCommands[2], is(bufferedReader.readLine()));
        Assert.assertThat(allCommands[3], is(bufferedReader.readLine()));
        Assert.assertNotNull(bufferedReader.readLine());
        Assert.assertThat(allCommands[4], is(bufferedReader.readLine()));
        Assert.assertNotNull(bufferedReader.readLine());
        Assert.assertThat(allCommands[5], is(bufferedReader.readLine()));

        // закрываем ресурсы
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
    }

}

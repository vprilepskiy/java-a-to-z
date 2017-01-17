package ru.job4j.words;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;

/**
 * Created by VLADIMIR on 16.01.2017.
 */
public class TestBadWord {

    /**
     * Test for method deleteBadWords.
     */
    @Test
    public void testDeleteBadWords() {
        final String line = "Я гуляла, я гуляла\nИ налево и направо\nА чего ж мне не гулять?\nВсё-равно ведь скажут б___ь!\n\nАх. ты Гена, ах ты Гена\nТы не щупай за колено\nЩупай сразу за п___у\nА не то домой пойду.";
        final String[] badWords = {"б___ь!", "п___у"};
        final String result = "Я гуляла, я гуляла\nИ налево и направо\nА чего ж мне не гулять?\nВсё-равно ведь скажут \n\nАх. ты Гена, ах ты Гена\nТы не щупай за колено\nЩупай сразу за \nА не то домой пойду.";

        Assert.assertThat(result, is(new BadWord().deleteBadWords(line, badWords)));
    }

    /**
     * Test for method dropAbuses.
     */
    @Test
    public void testDropAbuses() {
        final String line = "Я гуляла, я гуляла\nИ налево и направо\nА чего ж мне не гулять?\nВсё-равно ведь скажут б___ь!\n\nАх. ты Гена, ах ты Гена\nТы не щупай за колено\nЩупай сразу за п___у\nА не то домой пойду.";
        final String[] badWords = {"б___ь!", "п___у"};
        final String result = "Я гуляла, я гуляла\nИ налево и направо\nА чего ж мне не гулять?\nВсё-равно ведь скажут \n\nАх. ты Гена, ах ты Гена\nТы не щупай за колено\nЩупай сразу за \nА не то домой пойду.";

        BadWord badWord = new BadWord();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        badWord.dropAbuses(new ByteArrayInputStream(line.getBytes()), out, badWords);

        byte[] bytes = out.toByteArray();
        String str = new String(bytes);

        Assert.assertThat(result, is(str));
    }
}

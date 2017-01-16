package ru.job4j.words;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by VLADIMIR on 16.01.2017.
 */
public class TestBadWord {

    /**
     * Test for menhod deleteBadWords.
     */
    @Test
    public void testDeleteBadWords() {
        final String line = "Я гуляла, я гуляла\nИ налево и направо\nА чего ж мне не гулять?\nВсё-равно ведь скажут б___ь!\n\nАх. ты Гена, ах ты Гена\nТы не щупай за колено\nЩупай сразу за п___у\nА не то домой пойду.";
        final String[] badWords = {"б___ь!", "п___у"};
        final String result = "Я гуляла, я гуляла\nИ налево и направо\nА чего ж мне не гулять?\nВсё-равно ведь скажут \n\nАх. ты Гена, ах ты Гена\nТы не щупай за колено\nЩупай сразу за \nА не то домой пойду.";

        Assert.assertThat(result, is(new BadWord().deleteBadWords(line, badWords)));
    }

}

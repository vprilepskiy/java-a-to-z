package ru.prilepskiy.good.word;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GoodWordTest {

    final Map<Word, Word> dataAndExpectedResult = new HashMap();
    final Map<Word, Word> failDataAndExpectedResult = new HashMap();

    @Before
    public void addTestData() {
        this.dataAndExpectedResult.put(new Word(4, "good"), new Word(0, "good"));
        this.dataAndExpectedResult.put(new Word(4, "aabc"), new Word(2, "ab"));
        this.dataAndExpectedResult.put(new Word(3, "aaa"), new Word(3, ""));

        this.failDataAndExpectedResult.put(new Word(0, ""), null);
        this.failDataAndExpectedResult.put(new Word(1, "ab"), null);
    }

    @Test
    public void convert() {
        dataAndExpectedResult.forEach((data, expect) -> {
            final long start = System.currentTimeMillis();
            Assert.assertEquals(expect, new GoodWord().convert(data));
            System.out.printf("Run time millis: %d%n", System.currentTimeMillis() - start);
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertFail() {
        failDataAndExpectedResult.forEach((data, expect) -> new GoodWord().convert(data));
    }
}
package ru.prilepskiy.good.word;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GoodWordTest {

    final Map<String, String> dataAndExpectedResult = new HashMap();

    @Before
    public void addTestData() {
        this.dataAndExpectedResult.put("good", "good");
        this.dataAndExpectedResult.put("aabc", "ab");
        this.dataAndExpectedResult.put("aaa", "");
        this.dataAndExpectedResult.put("ab", "ab");
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
        new GoodWord().convert("");
    }
}
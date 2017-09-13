package ru.job4j.set.quickadd;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 15.06.2017.
 */
public class SimpleSetTest {

    /**
     * ATest.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {
        final String value0 = "test0";
        final String value1 = "test1";
        final String value2 = "test2";
        final String value3 = "test3";

        final int size = 2;
        SimpleSet<String> simpleSet = new SimpleSet(size);
        final String[] values = {value2, value2, value0, value1, value3, value3, value1};

        for (String value : values) {
            simpleSet.add(value);
        }

        final String[] expect = {value2, value0, value1, value3};
        Iterator<String> it = simpleSet.iterator();

        final int sizeArray = 4;
        final String[] result = new String[sizeArray];
        int index = 0;
        while (it.hasNext()) {
            result[index++] = it.next();
        }

        Assert.assertThat(result, Is.is(expect));
    }
}

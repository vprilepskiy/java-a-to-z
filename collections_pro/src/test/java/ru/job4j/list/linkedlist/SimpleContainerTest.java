package ru.job4j.list.linkedlist;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;

/**
 * Created by VLADIMIR on 06.06.2017.
 */
public class SimpleContainerTest {

    /**
     * ATest.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {

        SimpleContainer<String> simpleContainer = new SimpleContainer();
        final String[] values = {"test0", "test1", "test2"};

        for (String value : values) {
            simpleContainer.add(value);
        }

        Iterator<String> it = simpleContainer.iterator();
        int index = 0;

        String[] result = new String[values.length];
        while (it.hasNext()) {
            result[index++] = it.next();
        }

        Assert.assertThat(result, Is.is(values));

    }

    /**
     * ATest.
     */
    @Test
    public void whenAddElementsThenGetWithIndex() {

        SimpleContainer<String> simpleContainer = new SimpleContainer();
        final String[] values = {"test0", "test1", "test2", "test3", "test4"};

        for (String value : values) {
            simpleContainer.add(value);
        }

        String[] result = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = simpleContainer.get(i);
        }

        Assert.assertThat(result, Is.is(values));
    }

}

package ru.job4j.list.arraylist;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 02.06.2017.
 */
public class SimpleContainerTest {

    /**
     * Test.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {

        final int size = 2;
        SimpleContainer<String> simpleContainer = new SimpleContainer(size);
        final String[] values = {"test0", "test1", "test2", "test3", "test4"};

        for (String value : values) {
            simpleContainer.add(value);
        }

        Iterator it = simpleContainer.iterator();
        int index = 0;
        while (it.hasNext()) {
            Assert.assertThat(it.next(), Is.is(values[index++]));
        }
    }

}

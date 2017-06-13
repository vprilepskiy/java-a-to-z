package ru.job4j.list.set.arrayset;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.set.arrayset.SimpleSet;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 13.06.2017.
 */
public class SimpleSetTest {

    /**
     * Test.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {

        final int size = 2;
        SimpleSet<String> simpleSet = new SimpleSet(size);
        final String[] values = {"test0", "test1", "test2", "test2", "test3", "test4"};

        for (String value : values) {
            simpleSet.add(value);
        }

        final String[] expect = {"test0", "test1", "test2", "test3", "test4"};
        Iterator it = simpleSet.iterator();
        int index = 0;
        while (it.hasNext()) {
            Assert.assertThat(it.next(), Is.is(expect[index++]));
        }
    }

}

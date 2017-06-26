package ru.job4j.set.linkedset;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.set.linledset.SimpleSet;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 14.06.2017.
 */
public class SimpleSetTest {

    /**
     * Test.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {

        SimpleSet<String> simpleSet = new SimpleSet();
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

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
     * Test.
     */
    @Test
    public void whenAddElementsThenGetWithIterator() {

        final int size = 2;
        SimpleContainer<String> simpleContainer = new SimpleContainer();
        final String[] values = {"test0", "test1", "test2", "test3", "test4"};

        for (String value : values) {
            simpleContainer.add(value);
        }

        Iterator it = simpleContainer.iterator();
        int index = 0;

        System.out.println(it.hasNext() + "; " + it.next());
        System.out.println(it.hasNext() + "; " + it.next());
        System.out.println(it.hasNext() + "; " + it.next());
        System.out.println(it.hasNext() + "; " + it.next());
        System.out.println(it.hasNext() + "; " + it.next());
        System.out.println(it.hasNext());

//        while (MyIterator.hasNext()) {
//            System.out.println(MyIterator.next());
//            Assert.assertThat(MyIterator.next(), Is.is(values[index++]));
//        }
    }

}

package ru.job4j.set.linkedset;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.set.linledset.SimpleSet;

import java.util.Arrays;
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

//    @Test
//    public void a() {
//        SimpleSet<String> simpleSet = new SimpleSet();
//
//        String value0 = "test0";
//        String value1 = "test1";
//        String value2 = "test2";
//        String value3 = "test3";
//        String value4 = "test4";
//
//
//        final String[] values = {value3, value2, value1, value0, value0, value4};
//
//        for (String value : values) {
//            simpleSet.add(value);
//        }
//
//        Iterator it = simpleSet.iterator();
//        while (it.hasNext()) {
////            Assert.assertThat(it.next(), Is.is(expect[index++]));
//            System.out.println(it.next().hashCode());
//        }
//    }
//
    @Test
    public void b() {
        String value0 = "test0";
        String value1 = "test1";
        String value2 = "test2";
        String value3 = "test3";
        String value4 = "test4";
        final String[] values = {value1, value3, value4};
//        final String[] values = new String[10];

        for (String s : values) {
            System.out.println(s + "; " + s.hashCode());
        }

        System.out.println(Arrays.binarySearch(values, value2) + "; " + value2.hashCode());
    }

}

package ru.job4j.set.quickadd;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by VLADIMIR on 15.06.2017.
 */
public class SimpleSetTest {

    @Test
    public void whenAddElementInMiddleOfArray() {
        SimpleSet simpleSet = new SimpleSet();
        final int[] array = new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0};
        simpleSet.addInMiddle(array, 1, 0);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testBynarySearch() {
//        int[] array = new int[]{1, 3, 5, 7, 9, 0, 0, 0};
        int[] array = new int[]{0, 0, 0, 0, 0, 0};
        int i = Arrays.binarySearch(array, 0, 0, 50);
        if (i >= 0) {
            System.out.println("Найден элемент с индексом " + i);
        } else {
            System.out.println("Место для вставки " + (Math.abs(i) - 1));
        }
    }


    /**
     * Test.
     */
    @Test

    public void whenAddElementsThenGetWithIterator() {

        final int size = 2;
        SimpleSet<String> simpleSet = new SimpleSet(size);
        final String[] values = {"test0", "test1", "test1", "test2", "test3", "test3"};

        for (String value : values) {
            simpleSet.add(value);
        }

        final String[] expect = {"test0", "test1", "test2", "test3"};
        Iterator it = simpleSet.iterator();
        int index = 0;
        while (it.hasNext()) {
            Assert.assertThat(it.next(), Is.is(expect[index++]));
        }
    }

}

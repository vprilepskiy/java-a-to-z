package ru.job4j.iterator.convert;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by VLADIMIR on 27.05.2017.
 */
public class ConverterTest {

    /**
     * Test.
     */
    @Test
    public void test() {

        final Integer[] arr1 = new Integer[] {4, 2, 0, 4, 6, 4, 9};
        final Integer[] arr2 = new Integer[] {0, 9, 8, 7, 5};
        final Integer[] arr3 = new Integer[] {1, 3, 5, 6, 7, 0, 9, 8, 4};

        final Iterator<Integer> itInt1 = Arrays.asList(arr1).iterator();
        final Iterator<Integer> itInt2 = Arrays.asList(arr2).iterator();
        final Iterator<Integer> itInt3 = Arrays.asList(arr3).iterator();

        final List<Iterator<Integer>> list = new ArrayList();
        list.add(itInt1);
        list.add(itInt2);
        list.add(itInt3);

        final Iterator<Iterator<Integer>> it = list.iterator();
        final Iterator<Integer> result = new Converter().convert(it);

        final Integer[] arr = new Integer[] {4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4};
        final Iterator<Integer> expect = Arrays.asList(arr).iterator();

        while (result.hasNext()) {
            Assert.assertThat(result.next(), Is.is(expect.next()));
        }
    }

}

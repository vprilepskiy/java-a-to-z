package ru.job4j.converter;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by VLADIMIR on 05.05.2017.
 */
public class ConvertListTest {

    /**
     * Test.
     */
    @Test
    public void whenSetArrayThenGetList() {

        final int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        final List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        ConvertList convertList = new ConvertList();

        Assert.assertThat(result, Is.is(convertList.toList(array)));
    }

    /**
     * Test.
     */
    @Test
    public void whenSetListThenGetArray() {

        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        final int rows = 3;
        final int[][] result = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};

        ConvertList convertList = new ConvertList();

        Assert.assertThat(result, Is.is(convertList.toArray(list, rows)));
    }

    /**
     * Test.
     */
    @Test
    public void whenSetListArrThenArray() {

        final int[] arr0 = {1, 2};
        final int[] arr1 = {3, 4, 5, 6};

        List<int[]> list = new ArrayList<int[]>();
        list.add(arr0);
        list.add(arr1);

        final List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6);

        ConvertList convertList = new ConvertList();

        Assert.assertThat(result, Is.is(convertList.convert(list)));

    }
}

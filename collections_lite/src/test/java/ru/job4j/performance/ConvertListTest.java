package ru.job4j.performance;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.converter.ConvertList;

import java.util.Arrays;
import java.util.List;

/**
 * Created by VLADIMIR on 05.05.2017.
 */
public class ConvertListTest {

    @Test
    public void test() {

        final int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        final List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        ConvertList convertList = new ConvertList();

        Assert.assertThat(result, Is.is(convertList.toList(array)));

    }

    @Test
    public void test2() {

        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        final int rows = 4;
        final int[][] result = {{1, 2, 3, 4}, {5, 6, 7, 0}};

        ConvertList convertList = new ConvertList();

        Assert.assertThat(result, Is.is(convertList.toArray(list, rows)));

    }

}

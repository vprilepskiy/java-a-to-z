package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 22.05.2017.
 */
public class IteratorDoubleArrayTest {

    /**
     * Test.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        final int[][] values = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        final IteratorDoubleArray it = new IteratorDoubleArray(values);
        final int steps = 5;

        for (int i = 0; i < steps; i++) {
            it.next();
        }
        final int result = (int) it.next();

        final int expect = 6;
        Assert.assertThat(result, Is.is(expect));
    }

    /**
     * Test.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContantValue() {
        final int[][] values = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        IteratorDoubleArray it = new IteratorDoubleArray(values);
        final int steps = 4;

        for (int i = 0; i < steps; i++) {
            it.next();
        }

        Assert.assertThat(true, Is.is(it.hasNext()));

        for (int i = 0; i < steps; i++) {
            it.next();
        }

        Assert.assertThat(false, Is.is(it.hasNext()));
    }

}

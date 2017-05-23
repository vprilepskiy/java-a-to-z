package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 22.05.2017.
 */
public class IteratorEvenNumbersArrayTest {

    /**
     * Test next.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        final int[] values = new int[] {1, 2, 7, 8, 10};
        IteratorEvenNumbersArray it = new IteratorEvenNumbersArray(values);

        it.next();
        int result = (int) it.next();

        final int expect = 8;
        Assert.assertThat(result, Is.is(expect));
    }

    /**
     * Test hasNext.
     */
    @Test
    public void whenCheckNextPositionShouldReturnTrue() {
        final int[] values = new int[] {1, 2, 7, 8, 10, 7};
        IteratorEvenNumbersArray it = new IteratorEvenNumbersArray(values);

        it.next();
        Assert.assertThat(it.hasNext(), Is.is(true));
    }

    /**
     * Test hasNext.
     */
    @Test
    public void whenCheckNextPositionShouldReturnFalse() {
        final int[] values = new int[] {1, 2, 7, 8, 10, 7};
        IteratorEvenNumbersArray it = new IteratorEvenNumbersArray(values);

        // 2
        it.next();
        // 8
        it.next();
        //10
        it.next();

        Assert.assertThat(it.hasNext(), Is.is(false));
    }

}

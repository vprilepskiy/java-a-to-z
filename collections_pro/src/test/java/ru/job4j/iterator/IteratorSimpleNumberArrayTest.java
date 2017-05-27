package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 24.05.2017.
 */
public class IteratorSimpleNumberArrayTest {

    /**
     * Test is Simple.
     */
    @Test
    public void whenSetNumberThenGetIsSimple() {
        final int[] values = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        IteratorSimpleNumberArray it = new IteratorSimpleNumberArray(values);

        final boolean[] expect = new boolean[] {false, false, true, true, false, true, false, true, false, false};

        for (int i = 0; i < values.length; i++) {
            Assert.assertThat(it.isSimple(values[i]), Is.is(expect[i]));
        }
    }

    /**
     * Test hasNext.
     */
    @Test
    public void whenCheckNextPositionShouldReturnTrue() {
        final int[] values = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        IteratorSimpleNumberArray it = new IteratorSimpleNumberArray(values);

        it.next();

        Assert.assertThat(it.hasNext(), Is.is(true));
    }

    /**
     * Test hasNext.
     */
    @Test
    public void whenCheckNextPositionShouldReturnFalse() {
        final int[] values = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        IteratorSimpleNumberArray it = new IteratorSimpleNumberArray(values);

        // 2
        it.next();
        // 3
        it.next();
        // 5
        it.next();
        // 7
        it.next();

        Assert.assertThat(it.hasNext(), Is.is(false));
    }

}

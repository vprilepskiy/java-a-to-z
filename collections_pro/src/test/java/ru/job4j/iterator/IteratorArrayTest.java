package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 18.05.2017.
 */
public class IteratorArrayTest {

    /**
     * Example ForEach.
     */
    public static final class ForEachArray implements Iterable {

        /**
         * Array.
         */
        private final int[] values;

        /**
         * ForEach.
         * @param values - object.
         */
        public ForEachArray(int[] values) {
            this.values = values;
        }

        @Override
        public Iterator iterator() {
            return new IteratorArray(this.values);
        }
    }

    /**
     * ATest.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        final int[] values = new int[] {1, 3};
        IteratorArray it = new IteratorArray(values);

        it.next();
        int result = (int) it.next();

        final int expect = 3;
        Assert.assertThat(result, Is.is(expect));
    }

    /**
     * ATest.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContantValue() {
        IteratorArray it = new IteratorArray(new int[] {1});

        it.next();
        boolean result = it.hasNext();

        Assert.assertThat(result, Is.is(false));
    }

    /**
     * ATest.
     */
    @Test
    public void foreach() {

        final ForEachArray forEachArray = new ForEachArray(new int[] {1, 4, 5});

        for (Object value : forEachArray) {
            System.out.println(value);
        }

    }
}
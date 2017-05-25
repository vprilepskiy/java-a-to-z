package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 24.05.2017.
 */
public class IteratorSimpleNumberArrayTest {

    @Test
    public void whenSetNumberThenGetIsSimple(){
        final int[] values = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        IteratorSimpleNumberArray it = new IteratorSimpleNumberArray(values);



        Assert.assertThat(it.isPrime(values[0]), Is.is(false));
        Assert.assertThat(it.isPrime(values[1]), Is.is(false));
        Assert.assertThat(it.isPrime(values[2]), Is.is(true));
        Assert.assertThat(it.isPrime(values[3]), Is.is(true));
        Assert.assertThat(it.isPrime(values[4]), Is.is(false));
        Assert.assertThat(it.isPrime(values[5]), Is.is(true));
        Assert.assertThat(it.isPrime(values[6]), Is.is(false));
        Assert.assertThat(it.isPrime(values[7]), Is.is(true));
        Assert.assertThat(it.isPrime(values[8]), Is.is(false));
        Assert.assertThat(it.isPrime(values[9]), Is.is(false));
    }



}

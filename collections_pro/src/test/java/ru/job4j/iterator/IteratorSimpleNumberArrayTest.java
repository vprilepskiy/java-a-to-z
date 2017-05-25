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
        final int[] values = new int[] {};
        IteratorSimpleNumberArray it = new IteratorSimpleNumberArray(values);

        Assert.assertThat(it.isPrime(0), Is.is(false));
        Assert.assertThat(it.isPrime(1), Is.is(false));
        Assert.assertThat(it.isPrime(2), Is.is(true));
    }



}

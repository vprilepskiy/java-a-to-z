package ru.job4j.check;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * Created by VLADIMIR on 16.01.2017.
 */
public class TestEvenInteger {

    /**
     * Test for method isNumber.
     */
    @Test
    public void testIsNumber() {
        Assert.assertTrue(new EvenInteger().isNumber(new ByteArrayInputStream("4".getBytes())));
        Assert.assertFalse(new EvenInteger().isNumber(new ByteArrayInputStream("5".getBytes())));
    }

}

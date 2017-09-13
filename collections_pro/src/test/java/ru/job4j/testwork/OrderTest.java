package ru.job4j.testwork;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 13.09.2017.
 */
public class OrderTest {

    /**
     * Test.
     */
    @Test
    public void compareTo() {

        final Order o1 = new Order(new Book("book", 120), -10);
        final Order o2 = new Order(new Book("book", 120), 10);

        Assert.assertEquals(o1.compareTo(o2), -1);
        Assert.assertEquals(o2.compareTo(o1), 1);

    }

}
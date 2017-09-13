package ru.job4j.testwork;

import org.junit.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;

/**
 * Created by VLADIMIR on 30.08.2017.
 */
public class XMLParseTest {

    /**
     * Test read.
     */
    @Test
    public void read() {

        // data
        final File file = new File("orders_for_test.xml");

        // result
        final Collection<Order> result = new XMLParse(file).read();

        // expect
        final Order o0 = new Order(new Book("book-1", 115), 5);
        final Order o1 = new Order(new Book("book-1", 115), 10);
        final Order o2 = new Order(new Book("book-1", 118.5), 10);
        final Order o3 = new Order(new Book("book-2", 116), 2);
        final Order o4 = new Order(new Book("book-1", 118.5), 4);
        final Order o5 = new Order(new Book("book-2", 120), 10);
        final Order o6 = new Order(new Book("book-1", 115), -15);
        final Order o7 = new Order(new Book("book-1", 118), -15);
        final Order o8 = new Order(new Book("book-2", 116.5), -4);
        final Order o9 = new Order(new Book("book-2", 120), -5);

        final Collection<Order> expect = Arrays.asList(o0, o1, o2, o3, o4, o5, o6, o7, o8, o9);

        // assert
        Assert.assertArrayEquals(expect.toArray(), result.toArray());
    }
}

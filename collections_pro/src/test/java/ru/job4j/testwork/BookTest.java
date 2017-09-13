package ru.job4j.testwork;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 13.09.2017.
 */
public class BookTest {

    /**
     * Test.
     */
    @Test
    public void compareTo() {

        final Book b1 = new Book("book-1", 100);
        final Book b2 = new Book("book-1", 120);

        Assert.assertEquals(b1.compareTo(b2), -1);
        Assert.assertEquals(b2.compareTo(b1), 1);

    }

}
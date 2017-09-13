package ru.job4j.testwork;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by VLADIMIR on 13.09.2017.
 */
public class PersonsTest {

    /**
     * Test.
     */
    @Test
    public void equalsTest() {
        Assert.assertTrue(new Persons.Ask().equals(new Persons.Ask()));
        Assert.assertFalse(new Persons.Ask().equals(new Persons.Bid()));
    }
}
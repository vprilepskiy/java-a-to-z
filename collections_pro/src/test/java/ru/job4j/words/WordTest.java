package ru.job4j.words;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 22.09.2017.
 */
public class WordTest {

    /**
     * Test.
     */
    @Test
    public void equalsIgnoreOrder() {

        Assert.assertTrue(new Word("ACB").equalsIgnoreOrder("BAC"));

        Assert.assertFalse(new Word("ACB").equalsIgnoreOrder("BACB"));

    }

}
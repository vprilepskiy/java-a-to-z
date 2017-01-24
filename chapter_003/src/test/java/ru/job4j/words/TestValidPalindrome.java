package ru.job4j.words;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;


/**
 * Created by VLADIMIR on 21.01.2017.
 */
public class TestValidPalindrome {

    /**
     * Test.
     */
    @Test
    public void testFiveLettersWhenTrue() {
        Assert.assertTrue(new ValidPalindrome().fiveLetters(new ByteArrayInputStream("топот".getBytes())));
    }

    /**
     * Test.
     */
    @Test
    public void testFiveLettersWhenTrue2() {
        Assert.assertTrue(new ValidPalindrome().fiveLetters(new ByteArrayInputStream("ТОпот".getBytes())));
    }

    /**
     * Test.
     */
    @Test
    public void testFiveLettersWhenFalse() {
        Assert.assertFalse(new ValidPalindrome().fiveLetters(new ByteArrayInputStream("saippuakivikauppias".getBytes())));
    }

    /**
     * Test.
     */
    @Test
    public void testFiveLettersWhenFalse2() {
        Assert.assertFalse(new ValidPalindrome().fiveLetters(new ByteArrayInputStream("fff".getBytes())));
    }

}

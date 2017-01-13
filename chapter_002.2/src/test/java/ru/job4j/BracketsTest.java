package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by VLADIMIR on 13.01.2017.
 */
public class BracketsTest {

    /**
     * Выражение верное.
     */
    @Test
    public void TestLegalityExpressionWithBracketsWhenValid() {
        final String line = "((2 + 2) x 2 + 4) + 3";
        final boolean valid = new Brackets().validExpression(line);
        assertThat(true, is(valid));
    }

    /**
     * Выражение неверное.
     */
    @Test
    public void TestLegalityExpressionWithBracketsWhenInvalid() {
        final String line = "((2 + 2) x 2 + 4)) + 3";
        final boolean valid = new Brackets().validExpression(line);
        assertThat(false, is(valid));
    }

}

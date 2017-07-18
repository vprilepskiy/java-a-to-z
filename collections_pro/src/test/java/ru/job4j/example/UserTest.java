package ru.job4j.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 18.07.2017.
 */
public class UserTest {

    /**
     * User.
     */
    private final User x = new User(0, "Name", "FirstName");
    /**
     * User.
     */
    private final User y = new User(0, "Name", "FirstName");
    /**
     * User.
     */
    private final User z = new User(0, "Name", "FirstName");

    /**
     * РЕФФЛЕКТИВНОСТЬ.
     * Само на себя всегда true.
     */
    @Test
    public void testEqualsReflexive() {
        Assert.assertTrue(x.equals(x));
    }

    /**
     * СИММЕТРИЧНОСТЬ.
     * Если x=y, то y=x.
     */
    @Test
    public void testEqualsSymmetric() {
        Assert.assertTrue(x.equals(y) == y.equals(x));
    }

    /**
     * ТРАНЗИТИВНОСТЬ.
     * Если x=y и y=z, то x=z.
     */
    @Test
    public void testEqualsTransitive() {

        if (x.equals(y) && y.equals(z)) {
            Assert.assertTrue(x.equals(z));
        } else {
            Assert.fail();
        }
    }

    /**
     * НЕПРОТИВОРЕЧИВОСТЬ.
     * Если несколько раз вызвать equals, то результат не поменяется.
     */
    @Test
    public void testEqualsConsistent() {
        final int count = 100;
        for (int i = 0; i > count; i++) {
            Assert.assertTrue(x.equals(y));
        }
    }

    /**
     * ЕСЛИ NULL ТО FALSE.
     * Если в метод equals передать null, то метод не должен падать в NPE, а должен возвращать false.
     */
    @Test
    public void testEqualsNull() {
        Assert.assertFalse(x.equals(null));
    }
}

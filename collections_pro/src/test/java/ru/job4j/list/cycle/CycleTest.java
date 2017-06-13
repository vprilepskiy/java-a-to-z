package ru.job4j.list.cycle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 08.06.2017.
 */
public class CycleTest {

    /**
     * First.
     */
    private final Node first = new Node(1);
    /**
     * Two.
     */
    private final Node two = new Node(2);
    /**
     * Third.
     */
    private final Node third = new Node(3);
    /**
     * Four.
     */
    private final Node four = new Node(4);

    /**
     * Link begin with end.
     */
    @Test
    public void whenLinkingBeginWithEndThenTrue() {

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        Assert.assertTrue(new Cycle().hasCycle(first));
    }

    /**
     * Link begin with begin.
     */
    @Test
    public void whenLinkingBeginWithBeginThenTrue() {

        first.setNext(first);
        two.setNext(third);

        Assert.assertTrue(new Cycle().hasCycle(first));
    }

    /**
     * Link validate.
     */
    @Test
    public void whenNotHasCycleThenFalse() {

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(null);

        Assert.assertFalse(new Cycle().hasCycle(first));
    }

}

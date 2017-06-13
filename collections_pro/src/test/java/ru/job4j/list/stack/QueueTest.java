package ru.job4j.list.stack;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 08.06.2017.
 */
public class QueueTest {

    /**
     * Test.
     */
    @Test
    public void test() {

        Queue queue = new Queue();

        queue.push("test0");
        queue.push("test1");
        queue.push("test2");

        Assert.assertThat("test0", Is.is(queue.pop()));
        Assert.assertThat("test1", Is.is(queue.pop()));
        Assert.assertThat("test2", Is.is(queue.pop()));
    }
}

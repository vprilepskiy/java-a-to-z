package ru.job4j.list.stack;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 08.06.2017.
 */
public class StackTest {

    /**
     * Test.
     */
    @Test
    public void test() {

        Stack stack = new Stack();

        stack.push("test0");
        stack.push("test1");
        stack.push("test2");

        Assert.assertThat("test2", Is.is(stack.pop()));
        Assert.assertThat("test1", Is.is(stack.pop()));
        Assert.assertThat("test0", Is.is(stack.pop()));
    }
}



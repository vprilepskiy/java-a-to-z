package ru.job4j.tree.task2;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 21.08.2017.
 */
public class TreeTest {

    /**
     * ATest for findByValue().
     */
    @Test
    public void testFindByValue() {

        final Tree tree = new Tree();

        final Tree.Node node11 = new Tree.Node(11, null, null);
        final Tree.Node node12 = new Tree.Node(12, null, null);
        final Tree.Node node21 = new Tree.Node(21, null, null);
        final Tree.Node node22 = new Tree.Node(22, null, null);

        final Tree.Node node1 = new Tree.Node(1, node11, node12);
        final Tree.Node node2 = new Tree.Node(2, node21, node22);
        final Tree.Node node0 = new Tree.Node(0, node1, node2);


        Assert.assertThat((tree.findByValue(node0, 0)).getValue(), Is.is(0));
        Assert.assertThat((tree.findByValue(node0, 1)).getValue(), Is.is(1));
        final int twentyOne = 21;
        Assert.assertThat((tree.findByValue(node0, twentyOne)).getValue(), Is.is(twentyOne));
    }


    /**
     * ATest for isBinary.
     */
    @Test
    public void testIsBinaryWhenFalse() {

        final Tree tree = new Tree();

        final Tree.Node node21 = new Tree.Node(21, null, null);
        final Tree.Node node2 = new Tree.Node(2, node21, null);
        final Tree.Node node0 = new Tree.Node(0, null, node2);

        Assert.assertFalse(tree.isBinary(node0));
    }

    /**
     * ATest for isBinary.
     */
    @Test
    public void testIsBinaryWhenTrue() {

        final Tree tree = new Tree();

        final Tree.Node node11 = new Tree.Node(11, null, null);
        final Tree.Node node12 = new Tree.Node(12, null, null);
        final Tree.Node node1 = new Tree.Node(1, node11, node12);
        final Tree.Node node0 = new Tree.Node(0, node1, null);

        Assert.assertTrue(tree.isBinary(node0));
    }


    /**
     * ATest.
     */
    @Test
    public void testAdd() {

        final Tree tree = new Tree();
        final int[] values = {15, 5, 30, 22, 30};

        for (int i = 0; i < values.length; i++) {
            tree.add(values[i]);
        }

        final String expect = "(Node{value=15, left=(Node{value=5, left=null, right=null}), right=(Node{value=30, left=(Node{value=22, left=null, right=(Node{value=30, left=null, right=null})}), right=null})})";

        Assert.assertThat(expect.toString(), Is.is(tree.getRootNode().toString()));


    }
}


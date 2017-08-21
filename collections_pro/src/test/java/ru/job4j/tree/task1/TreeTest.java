package ru.job4j.tree.task1;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;


/**
 * Created by VLADIMIR on 25.07.2017.
 */
public class TreeTest {

    /**
     * Test method Search().
     */
    @Test
    public void testSearch() {

        Tree<String> tree = new Tree<String>();

        Tree.Node nodeVasiliy = new Tree.Node("Vasiliy");
        Tree.Node nodeViktor = new Tree.Node("Viktor");
        Tree.Node nodeVova = new Tree.Node("Vova");
        Tree.Node nodeAndrey = new Tree.Node("Andrey");
        Tree.Node nodeTanya = new Tree.Node("Tanya");
        Tree.Node nodeDimka = new Tree.Node("Dimka");
        Tree.Node nodeOlya = new Tree.Node("Olya");
        Tree.Node nodeMisha = new Tree.Node<>("Misha");

        nodeVasiliy.getChildren().add(nodeOlya);
        nodeVasiliy.getChildren().add(nodeTanya);
        nodeVasiliy.getChildren().add(nodeViktor);

        nodeOlya.getChildren().add(nodeMisha);

        nodeTanya.getChildren().add(nodeDimka);

        nodeViktor.getChildren().add(nodeAndrey);
        nodeViktor.getChildren().add(nodeVova);

        Assert.assertThat(tree.search(nodeVasiliy, tree.new SearchCondition((2))), Is.is(nodeMisha));
        Assert.assertThat(tree.search(nodeVasiliy, tree.new SearchCondition(("Andrey"))), Is.is(nodeAndrey));
    }



    /**
     * Test Add.
     */
    @Test
    public void testAdd() {
        Tree<String> tree = new Tree();

        int length = 0;

        length++;
        length++;
        Assert.assertTrue(tree.add("Vasiliy", "Viktor"));
        Assert.assertThat(tree.length(), Is.is(length));

        length++;
        Assert.assertTrue(tree.add("Vasiliy", "Olya"));
        Assert.assertThat(tree.length(), Is.is(length));

        Assert.assertFalse(tree.add("None", "Olya"));
        Assert.assertThat(tree.length(), Is.is(length));
    }



    /**
     * Test Iterator.
     */
    @Test
    public void testIterator() {
        final Tree<String> tree = new Tree();

        tree.add("Vasiliy", null);
        tree.add("Vasiliy", "Viktor");
        tree.add("Vasiliy", "Tanya");
        tree.add("Viktor", "Andrey");
        tree.add("Viktor", "Vova");
        tree.add("Tanya", "Dimka");

        Iterator<String> iterator = tree.iterator();

        final String[] expect = {"Vasiliy", "Viktor", "Andrey", "Vova", "Tanya", "Dimka"};
        final String[] result = new String[expect.length];

        int index = 0;
        while (iterator.hasNext()) {
            result[index++] = iterator.next();
        }

        Assert.assertArrayEquals(expect, result);
    }



    /**
     * Test IsBinary.
     */
    @Test
    public void testIsBinary() {
        final Tree<String> tree = new Tree();

        tree.add("Vasiliy", "Viktor");
        Assert.assertFalse(tree.isBinary());

        tree.add("Vasiliy", "Tanya");
        Assert.assertTrue(tree.isBinary());
    }
}
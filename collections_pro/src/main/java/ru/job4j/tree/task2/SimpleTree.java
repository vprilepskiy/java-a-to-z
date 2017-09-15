package ru.job4j.tree.task2;

/**
 * Created by VLADIMIR on 21.08.2017.
 */
public interface SimpleTree {

    /**
     * Find value.
     * @param root - root node.
     * @param value - find value.
     * @return - search node.
     */
    Tree.Node findByValue(Tree.Node root, int value);

    /**
     * Find binary node.
     * @param root - root node.
     * @return - True if found. False if not found.
     */
    boolean isBinary(Tree.Node root);

    /**
     * Add value.
     * @param value - value.
     */
    void add(int value);

}

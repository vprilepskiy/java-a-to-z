package ru.job4j.tree.task2;

/**
 * Created by VLADIMIR on 21.08.2017.
 */
public class Tree implements SimpleTree {


    /**
     * Node.
     */
    static class Node {
        /**
         * Value.
         */
        private int value;

        /**
         * Left node.
         */
        private Node left;
        /**
         * Right node.
         */
        private Node right;

        /**
         * Constructor.
         *
         * @param value - Value.
         * @param left  - Left node.
         * @param right - Right node.
         */
        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * Getter.
         *
         * @return - value.
         */
        public int getValue() {
            return this.value;
        }

        /**
         * Getter.
         *
         * @return - value.
         */
        public Node getLeft() {
            return this.left;
        }

        /**
         * Getter.
         *
         * @return - value.
         */
        public Node getRight() {
            return this.right;
        }

        @Override
        public String toString() {
            return new StringBuilder("(Node{value=").append(this.value).append(", left=").append(this.left).append(", right=").append(this.right).append("})").toString();
        }
    }


    /**
     * Again.
     */
    private boolean findAgain;
    /**
     * Found value.
     */
    private Node findNode;


    @Override
    public Node findByValue(Node root, int value) {
        this.findAgain = true;
        this.findNode = null;
        this.findNode = this.find(root, value);
        return this.findNode;
    }


    /**
     * Find value.
     *
     * @param root  - root node.
     * @param value - find value.
     * @return - search node.
     */
    private Node find(Node root, int value) {
        if ((this.findAgain) && (root != null)) {
            // сравниваем значение
            if (root.value == value) {
                this.findAgain = false;
                this.findNode = root;
                // сравниваем левое значение
            } else if ((root.left != null) && (root.left.value == value)) {
                this.findAgain = false;
                this.findNode = root.left;
                // сравниваем правое значение
            } else if ((root.right != null) && (root.right.value == value)) {
                this.findAgain = false;
                this.findNode = root.right;
                // если ничего не подошло
            } else {
                this.findNode = this.find(root.left, value);
                this.findNode = this.find(root.right, value);
            }
        }
        return this.findNode;
    }


    @Override
    public boolean isBinary(Node root) {
        this.findAgain = true;
        this.findAgain = this.findBinary(root);
        return !this.findAgain;
    }


    /**
     * Find binary node.
     *
     * @param root - Root node.
     * @return - False if found. True if not found.
     */
    private boolean findBinary(Node root) {
        if ((this.findAgain) && (root != null)) {
            // проверяем ноду на двойное значение
            if ((root.left != null) && (root.right != null)) {
                this.findAgain = false;
                // проверяем левое значение
            } else if (root.left != null) {
                this.findAgain = this.findBinary(root.left);
                // проверяем правое значение
            } else if (root.right != null) {
                this.findAgain = this.findBinary(root.right);
            }
        }
        return this.findAgain;
    }

    /**
     * Getter.
     * @return - root node.
     */
    Node getRootNode() {
        return rootNode;
    }

    /**
     * Root node.
     */
    private Node rootNode;


    @Override
    public void add(int value) {
        this.rootNode = this.add(this.rootNode, value);
    }

    /**
     * Add node in tree.
     *
     * @param root  - root node.
     * @param value - value.
     * @return - root node.
     */
    Node add(Node root, int value) {
        // если нода нулевая
        if (root == null) {
            root = new Node(value, null, null);
            // если нода не нулевая
            // проверяем левое значение
        } else if (root.value >= value) {
            root.left = this.add(root.left, value);
            // проверяем правое значение
        } else if (root.value < value) {
            root.right = this.add(root.right, value);
        }
        return root;
    }


}

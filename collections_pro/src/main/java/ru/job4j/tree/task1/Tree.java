package ru.job4j.tree.task1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by VLADIMIR on 24.07.2017.
 *
 * @param <E> - generic.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * Count for rows in tree.
     */
    private int rowCount = 0;

    /**
     * Root node.
     */
    private Node<E> nodeRoot = null;

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        // если нода нулевая
        if (this.nodeRoot == null) {
            // создаем родителя
            this.nodeRoot = new Node<>(parent);
            // увеличиваем счетчик
            this.rowCount++;
            if (child != null) {
                // добавляем в родителя дочерний элемент
                this.nodeRoot.children.add(new Node<E>(child));
                // увеличиваем счетчик
                this.rowCount++;
            }
            result = true;
            // если нода не нулевая
        } else {
            // ищем родителя
            Node<E> nodeSearch = this.search(this.nodeRoot, new SearchCondition(parent));
            // если нода найдена
            if (nodeSearch != null) {
                // добавляем в родителя дочерний элемент
                nodeSearch.children.add(new Node<E>(child));
                // увеличиваем счетчик
                this.rowCount++;
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean isBinary() {
        Node<E> nodeBinary = this.search(this.nodeRoot, new SearchCondition());
        return nodeBinary != null;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /**
             * Index for iterator.
             */
            private int indexIt = 0;

            @Override
            public boolean hasNext() {
                return rowCount > this.indexIt;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return search(nodeRoot, new SearchCondition(this.indexIt++)).value;
            }
        };
    }


    /**
     * Get size rows in tree.
     * @return - count.
     */
    public int length() {
        return this.rowCount;
    }



    /**
     * Node.
     *
     * @param <E> - generic.
     */
    static class Node<E> {
        /**
         * Value.
         */
        private final E value;
        /**
         * Children.
         */
        private final List<Node<E>> children;

        /**
         * Constructor.
         *
         * @param value - value.
         */
        Node(E value) {
            this.value = value;
            children = new LinkedList<Node<E>>();
        }

        /**
         * Getter.
         *
         * @return - children.
         */
        public List<Node<E>> getChildren() {
            return this.children;
        }

        @Override
        public String toString() {
            return "Node{ value=" + value + '}';
        }
    }

    /**
     * Index.
     */
    private int index;
    /**
     * Node.
     */
    private Node<E> node;
    /**
     * Again.
     */
    private boolean again;


    /**
     * Find node in tree by condition.
     *
     * @param root - Node root.
     * @param sear - Search condition.
     * @return - node.
     */
    Node<E> search(Node<E> root, SearchCondition sear) {

        this.node = root;

        List<Node<E>> childList = root.children;

        this.index++;

//        System.out.println("sout: " +  this.index + "; " + this.node);

        if (sear.getResult()) {
            // выйти из цикла
            this.again = false;
        } else {
            Iterator<Node<E>> iterator = childList.iterator();
            while (iterator.hasNext()) {
                if (this.again) {
                    Node<E> child = iterator.next();
                    // рекурсивно вызвать этот метод
                    this.node = this.search(child, sear);
                } else {
                    break;
                }
            }
        }

        // если не сработал поиск
        if (this.again) {
            this.node = null;
        }

        return this.node;
    }


    /**
     * Search condition for method search.
     */
    class SearchCondition {

        /**
         * Search by index.
         */
        private Integer searchIndex;
        /**
         * Search by value.
         */
        private E searchValue;

        /**
         * Constructor.
         */
        SearchCondition() {
            this.setDefaultValues();
        }

        /**
         * Constructor.
         *
         * @param searchIndex - set by index.
         */
        SearchCondition(int searchIndex) {
            this.searchIndex = searchIndex;
            this.setDefaultValues();
        }

        /**
         * Constructor.
         *
         * @param searchValue - set by value.
         */
        SearchCondition(E searchValue) {
            this.searchValue = searchValue;
            this.setDefaultValues();
        }

        /**
         * Reset search condition.
         */
        private void setDefaultValues() {
            index = -1;
            node = null;
            again = true;
        }

        /**
         * Comparison by index.
         *
         * @param searchIndex - index.
         * @return - result.
         */
        private boolean setCondition(int searchIndex) {
            return index == searchIndex;
        }

        /**
         * Comparison by value.
         *
         * @param searchValue - value.
         * @return - result.
         */
        private boolean setCondition(E searchValue) {
            return node.value.compareTo(searchValue) == 0;
        }

        /**
         * Max size of child elements.
         */
        private final int binaryNumber = 2;

        /**
         * @return - result.
         */
        public boolean getResult() {
            if (searchIndex != null) {
                return this.setCondition(this.searchIndex);
            } else if (searchValue != null) {
                return this.setCondition(this.searchValue);
            } else {
                return node.children.size() >= this.binaryNumber;
            }
        }
    }
}
package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 24.07.2017.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

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
            // добавляем в родителя дочерний элемент
            this.nodeRoot.children.add(new Node<E>(child));
        } else {
            // ищем ноду
            Node<E> nodeSearch = this.search(this.nodeRoot, new SearchCondition(parent));
            // добавляем в родителя дочерний элемент
            nodeSearch.children.add(new Node<E>(child));
        }
        return result;
    }



    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int indexIt = 0;

            @Override
            public boolean hasNext() {
//                index
                return false;
            }

            @Override
            public E next() {
                return search(nodeRoot, new SearchCondition(this.indexIt++)).value;
            }
        };
    }


    /**
     * Node.
     * @param <E> - generic.
     */
    private class Node<E> {

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
         * @param value - value.
         */
        Node(E value) {
            this.value = value;
            children = new LinkedList<Node<E>>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     *
     */
    int index = -1;
    /**
     *
     */
    Node<E> node;

    boolean again = true;

    /**
     * Выведет искомый элемент в дереве.
     * @param root - Node root.
     * @param sear - Search condition.
     * @return
     */
    private Node<E> search(Node<E> root, SearchCondition sear) {


        this.node = root;
        List<Node<E>> childList = root.children;

        this.index++;

        System.out.println(this.index + "; " + this.node);

        // выйти по условию
        if (sear.getResult()) {
            again = false;
        } else {
//            if (!childList.isEmpty()) {
            if (true) {
                Iterator<Node<E>> iterator = childList.iterator();
                while (iterator.hasNext()) {
                    if (again == true) {
                        Node<E> el = iterator.next();
                        node = this.search(el, sear);
                    } else {
                        break;
                    }
                }
            }
        }

        return this.node;
    }



    /**
     * Условие поиска.
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
         * @param searchIndex - set by index.
         */
        SearchCondition(int searchIndex){
            this.searchIndex = searchIndex;
        }

        /**
         * Constructor.
         * @param searchValue - set by value.
         */
        SearchCondition(E searchValue){
            this.searchValue = searchValue;
        }

        /**
         * Comparison by index.
         * @param searchIndex - index.
         * @return
         */
        public boolean setCondition(int searchIndex) {
            return index == searchIndex;
        }

        /**
         * Comparison by value.
         * @param searchValue - value.
         * @return
         */
        public boolean setCondition(E searchValue) {
            return node.value.compareTo(searchValue) == 0;
        }

        boolean getResult(){
            if (searchIndex != null) {
                return this.setCondition(this.searchIndex);
            }
            if (searchValue != null) {
                return this.setCondition(this.searchValue);
            }
            return false;
        }
    }



    public void a() {
        Node nodeVasiliy = new Node<>("Vasiliy");
        Node nodeViktor = new Node<>("Viktor");
        Node nodeVova = new Node<>("Vova");
        Node nodeAndrey = new Node<>("Andrey");
        Node nodeTanya = new Node<>("Tanya");
        Node nodeDimka = new Node<>("Dimka");
        Node nodeOlya = new Node<>("Olya");
        Node nodeMisha = new Node<>("Misha");

        nodeVasiliy.children.add(nodeOlya);
        nodeVasiliy.children.add(nodeTanya);
        nodeVasiliy.children.add(nodeViktor);

        nodeOlya.children.add(nodeMisha);

        nodeTanya.children.add(nodeDimka);

        nodeViktor.children.add(nodeAndrey);
        nodeViktor.children.add(nodeVova);

        System.out.println(this.search(nodeVasiliy, new SearchCondition(10)));
    }

}


//    @Override
//    public Iterator<E> iterator() {
//        return new MyIterator();
//    }

//    /**
//     * Iterator.
//     */
//    private class MyIterator implements Iterator<E>{
//
//        /**
//         * List.
//         */
//        private List<Node<E>> nodeList = new LinkedList<>();
//
//        /**
//         * Iterator for list.
//         */
//        private final Iterator<Node<E>> iterator;
//
//
//
//        /**
//         * Constructor.
//         */
//        private MyIterator(){
//            // add root element
//            if (nodeRoot != null) {
//                nodeList.add(nodeRoot);
//                // convert
//                this.toList();
//            }
//
//            // get iterator
//            this.iterator = this.nodeList.iterator();
//        }
//
//
//        /**
//         * Проход по дереву с передачей ссылок в список.
//         */
//        private void toList() {
//
//            // обрабатывать с позиции
//            int indexProcessNode = 0;
//
//            // смотрим сколько элементов в листе
//            int length = this.nodeList.size();
//
//            boolean again;
//
//            // горизонтальный обход по дереву
//            do {
//                again = false;
//                // счетчик
//                int index = 0;
//                // лист с наследниками
//                List<Node<E>> nodeListChildren = new LinkedList<>();
//                // проходим по списку
//                for (Node<E> tmpNode : this.nodeList) {
//                    // начать с не обработанных нодов
//                    if (index >= indexProcessNode) {
//                        // проверяем на присутствие наследников в ноде
//                        if ((tmpNode != null) && (!tmpNode.children.isEmpty())) {
//                            // если наследники есть
//                            // добавляем в лист children
//                            nodeListChildren.addAll(tmpNode.children);
//                            again = true;
//                        }
//                    }
//                    index++;
//                }
//                // добавляем children в общий лист
//                this.nodeList.addAll(nodeListChildren);
//                // изменяем позицию с которой надо начинать следующую итерацию
//                indexProcessNode = length;
//            } while (again);
//        }
//
//
//        @Override
//        public boolean hasNext() {
//            return this.iterator.hasNext();
//        }
//
//        @Override
//        public E next() {
//            return this.iterator.next().value;
//        }
//    }


//    @Override
//    public Iterator<E> iterator() {
//        return new Iterator<E>() {
//
//            /**
//             * List.
//             */
//            private List<Node<E>> nodeList = new LinkedList<>();
//
//            /**
//             * Iterator for list.
//             */
//            private final Iterator<Node<E>> iterator;
//
//            /**
//             * Instance initializer.
//             */ {
//                // add root element
//                if (nodeRoot != null) {
//                    nodeList.add(nodeRoot);
//                    // convert
//                    this.toList();
//                }
//                // get iterator
//                this.iterator = this.nodeList.iterator();
//            }
//
//            /**
//             * Проход по дереву с передачей ссылок в список.
//             */
//            private void toList() {
//
//                // обрабатывать с позиции
//                int indexProcessNode = 0;
//
//                // смотрим сколько элементов в листе
//                int length = this.nodeList.size();
//
//                boolean again;
//
//                // горизонтальный обход по дереву
//                do {
//                    again = false;
//                    // счетчик
//                    int index = 0;
//                    // лист с наследниками
//                    List<Node<E>> nodeListChildren = new LinkedList<>();
//                    // проходим по списку
//                    for (Node<E> tmpNode : this.nodeList) {
//                        // начать с не обработанных нодов
//                        if (index >= indexProcessNode) {
//                            // проверяем на присутствие наследников в ноде
//                            if ((tmpNode != null) && (!tmpNode.children.isEmpty())) {
//                                // если наследники есть
//                                // добавляем в лист children
//                                nodeListChildren.addAll(tmpNode.children);
//                                again = true;
//                            }
//                        }
//                        index++;
//                    }
//                    // добавляем children в общий лист
//                    this.nodeList.addAll(nodeListChildren);
//                    // изменяем позицию с которой надо начинать следующую итерацию
//                    indexProcessNode = length;
//                } while (again);
//            }
//
//
//            @Override
//            public boolean hasNext() {
//                return this.iterator.hasNext();
//            }
//
//            @Override
//            public E next() {
//                return this.iterator.next().value;
//            }
//        };
//    }
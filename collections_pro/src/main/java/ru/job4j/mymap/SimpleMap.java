package ru.job4j.mymap;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 11.07.2017.
 */

/**
 * Simple implementation of the map.
 * @param <K> - key.
 * @param <V> - value.
 */
public class SimpleMap<K, V> implements ISimpleMap<K, V>, Iterable<V> {

    /**
     * Default size of array.
     */
    private final int defaultSize = 16;
    /**
     * Default load factor.
     */
    private final double defaultLoadFactor = 0.75;
    /**
     * Array for nodes.
     */
    private Node<K, V>[] nodes;
    /**
     * Count rows.
     */
    private int size = 0;


    /**
     * Default constructor.
     */
    public SimpleMap() {
        this.nodes = new Node[this.defaultSize];
    }

    /**
     * Constructor witch size of array.
     *
     * @param size - size of array.
     */
    public SimpleMap(int size) {
        this.nodes = new Node[size];
    }


    @Override
    public boolean insert(K key, V value) {
        // расширить массив
        this.expandArray();
        // добавить ноду
        boolean result = this.add(this.nodes, new Node(key, value));
        if (result) {
            this.size++;
        }
        return result;
    }


    /**
     * Add node in array nodes.
     *
     * @param nodes - array.
     * @param node  - node.
     * @return - true if added. false if not added;
     */
    private boolean add(Node<K, V>[] nodes, Node<K, V> node) {
        boolean result = false;
        if (node != null) {
            // вычисляем позицию
            int index = this.indexFor(this.hash(node.getKey()), nodes.length);
            // если ячейка свободная
            if (nodes[index] == null) {
                // добовляем элемент в массив
                nodes[index] = node;
                result = true;
            } else {
                // если ячейка занята
                // то проверяем равенство ключей
                if (this.equalKey(nodes[index].getKey(), node.getKey())) {
                    // если колючи равны то заменяем значение.
                    nodes[index] = node;
                    result = true;
                } else {
                    // и если ключи не равны то возникает коллизия
                    // тут требуется реализовать коллизию, но в задании сказано, что этого не требуется
                    result = false;
                }
            }
        }
        return result;
    }


    /**
     * Checks the equality of keys.
     * @param key1 - key.
     * @param key2 - key.
     * @return - true if equal.
     */
    private boolean equalKey(K key1, K key2) {
        if ((key1 == null) || (key2 == null)) {
            return false;
        }
        return (key1 == key2) || (key1.equals(key2));
    }


    /**
     * Expand size of array in doubly.
     */
    private void expandArray() {
        // если размер меньше нужного
        if ((this.size) > (this.nodes.length * this.defaultLoadFactor)) {
            // создаем новый массив больше в 2 раза
            Node<K, V>[] newNodes = new Node[this.nodes.length * 2];
            // переписываем массив
            for (Node node : this.nodes) {
                // вставляем в новый массив
                this.add(newNodes, node);
            }
            // передаем ссылку на номый массив
            this.nodes = newNodes;
        }
    }



    @Override
    public V get(K key) {
        V value = null;
        int index = this.findIndexNode(this.nodes, key);
        if ((index != -1) && (this.equalKey(this.nodes[index].getKey(), key))) {
            value = this.nodes[index].getValue();
        }
        return value;
    }



    @Override
    public boolean delete(K key) {
        boolean result = false;
        int index = this.findIndexNode(this.nodes, key);
        if ((index != -1) && (this.equalKey(this.nodes[index].getKey(), key))) {
            this.nodes[index] = null;
            result = true;
        }
        return result;
    }



    /**
     * Hash function.
     *
     * @param key - object Key.
     * @return - the best hashCode.
     */
    int hash(K key) {
        final int bitShift = 16;
        int hash = 0;
        if (key != null) {
            hash = key.hashCode();
            hash = hash ^ (hash >>> bitShift);
        }
        return hash;
    }



    /**
     * Find position for array.
     *
     * @param hash   - hashCode.
     * @param length - array length.
     * @return - position.
     */
    int indexFor(int hash, int length) {
        return hash % this.nodes.length;
    }



    /**
     * Find index Node.
     *
     * @param nodes - nodes.
     * @param key   - key.
     * @return - index of array. -1 - if not found.
     */
    int findIndexNode(Node<K, V>[] nodes, K key) {
        // вычисляем позицию
        int index = this.indexFor(this.hash(key), nodes.length);
        // получаем ноду
        Node<K, V> node = nodes[index];
        // проверяем ноду на совпадение ключей
        if ((key != null) && (node != null) && (key.equals(node.getKey()))) {
            return index;
        } else {
            return -1;
        }
    }



    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            private int itIndex = 0;

            @Override
            public boolean hasNext() {
                return (this.getNextIndex() != -1);
            }

            @Override
            public V next() {
                itIndex = this.getNextIndex();
                V result = nodes[itIndex].getValue();
                itIndex++;
                return result;
            }

            private int getNextIndex() {
                int result = -1;

                for (int i = this.itIndex; i < nodes.length; i++) {
                    if (nodes[i] != null) {
                        result = i;
                        break;
                    }
                }
                return result;
            }
        };
    }
}



/**
 * Node.
 *
 * @param <K> - Key.
 * @param <V> - Value.
 */
class Node<K, V> {

    /**
     * Key.
     */
    private final K key;
    /**
     * Value.
     */
    private final V value;

    /**
     * Constructor.
     * @param key - key.
     * @param value - value.
     */
    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Getter.
     * @return - key.
     */
    public K getKey() {
        return this.key;
    }

    /**
     * Getter.
     * @return - value.
     */
    public V getValue() {
        return this.value;
    }
}



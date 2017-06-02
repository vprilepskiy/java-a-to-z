package ru.job4j.list.ch;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 31.05.2017.
 */
public interface ISimpleContainer<E> extends Iterable<E> {

    /**
     * Add element in collection.
     * @param value - value.
     */
    void add(E value);

    /**
     * Get element from collection.
     * @param index - index.
     * @return - value.
     */
    E get(int index);
}

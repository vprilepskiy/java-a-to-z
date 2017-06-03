package ru.job4j.list.arraylist;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 31.05.2017.
 * @param <E> - generic.
 */
public class SimpleContainer<E> implements ISimpleContainer<E> {

    /**
     * Default size of container.
     */
    private final int defaultSize = 10;
    /**
     * Array of objects.
     */
    private Object[] container;
    /**
     * Index null cell.
     */
    private int index = 0;

    /**
     * Default constructor.
     */
    public SimpleContainer() {
        this.container = new Object[this.defaultSize];
    }

    /**
     * Constructor witch size of array.
     * @param size - size of array.
     */
    public SimpleContainer(int size) {
        this.container = new Object[size];
    }

    @Override
    public void add(E value) {
        if (this.index > (this.container.length - 1)) {
            Object[] container = new Object[this.container.length + 1];
            System.arraycopy(this.container, 0, container, 0, this.container.length);
            this.container = container;
        }

        this.container[this.index++] = value;
    }

    @Override
    public E get(int index) {
        return (E) this.container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return container.length > this.index;
            }

            @Override
            public E next() {
                return (E) container[this.index++];
            }
        };
    }
}

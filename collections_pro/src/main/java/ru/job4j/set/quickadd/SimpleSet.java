package ru.job4j.set.quickadd;

import ru.job4j.list.ISimpleContainer;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 15.06.2017.
 */
public class SimpleSet<E> implements ISimpleContainer<E> {

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
     * Hash code of objects. Sorted array.
     */
    private int[] hash;

    /**
     * Default constructor.
     */
    public SimpleSet() {
        this.container = new Object[this.defaultSize];
    }

    /**
     * Constructor witch size of array.
     * @param size - size of array.
     */
    public SimpleSet(int size) {
        this.container = new Object[size];
    }

    @Override
    public void add(E value) {
        if (!(this.contains(value))) {
            if (this.index > (this.container.length - 1)) {
                this.container = this.expand(this.container, this.container.length * 2);
            }
            this.container[this.index++] = value;
        }
    }

    /**
     * Expand size of array in doubly.
     */
    private Object[] expand(Object[] array, int newSize) {
        Object[] container = new Object[newSize];
        System.arraycopy(array, 0, container, 0, array.length);
        return container;
    }

    /**
     * Проверит на наличие такого элемента в коллекции.
     * @param value - элемент.
     * @return - true - если существует, false - если не существует.
     */
    private boolean contains(E value) {
        boolean result = false;



        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                result = true;
                break;
            }
        }



        return result;
    }

    @Override
    public E get(int index) {
        return (E) this.container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int itIndex = 0;

            @Override
            public boolean hasNext() {
                return index > this.itIndex;
            }

            @Override
            public E next() {
                return (E) container[this.itIndex++];
            }
        };
    }

}

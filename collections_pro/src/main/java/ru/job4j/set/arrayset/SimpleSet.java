package ru.job4j.set.arrayset;

import ru.job4j.list.arraylist.SimpleContainer;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 13.06.2017.
 * @param <E> - generic.
 */
public class SimpleSet<E> extends SimpleContainer<E> {

    /**
     * Constructor.
     */
    public SimpleSet() {
        super();
    }

    /**
     * Constructor witch size of array.
     * @param size - size of array.
     */
    public SimpleSet(int size) {
        super(size);
    }

    @Override
    public void add(E value) {
        if (!(this.contains(value))) {
            super.add(value);
        }
    }

    /**
     * Проверит на наличие такого элемента в коллекции.
     * @param value - элемент.
     * @return - true - если существует, false - если не существует.
     */
    private boolean contains(E value) {
        boolean result = false;

        Iterator<E> iterator = super.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

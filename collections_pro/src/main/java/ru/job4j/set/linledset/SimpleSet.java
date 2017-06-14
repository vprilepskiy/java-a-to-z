package ru.job4j.set.linledset;

import ru.job4j.list.linkedlist.SimpleContainer;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 14.06.2017.
 * @param <E> - generic.
 */
public class SimpleSet<E> extends SimpleContainer<E> {

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

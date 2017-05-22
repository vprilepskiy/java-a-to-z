package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 18.05.2017.
 */
public class IteratorArray implements Iterator {

    /**
     * Array.
     */
    private final int[] values;
    /**
     * Index.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param values - Array.
     */
    public IteratorArray(final int[] values) {
        this.values = values;
    }

    /**
     * Проверяет возможность извлечения следующих объектов из массива.
     * @return - true если есть следующий объект. False - если конец массива.
     */
    public boolean hasNext() {
        return this.values.length > this.index;
    }

    /**
     * Вернет объект из массива и сдвинет индекс на следующую ячейку.
     * @return - объект.
     */
    public Object next() {
        return values[this.index++];
    }
}

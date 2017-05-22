package ru.job4j.iterator;

import java.util.Iterator;

/**
 * 5.1.1. Итератор для двухмерного массива int[][] [#15306]
 *
 * Created by VLADIMIR on 22.05.2017.
 */
public class IteratorDoubleArray implements Iterator {

    /**
     * Double Array.
     */
    private final int[][] values;
    /**
     * Second index.
     */
    private int i = 0;
    /**
     * First index.
     */
    private int j = 0;

    /**
     * Constructor.
     * @param values - Double Array.
     */
    public IteratorDoubleArray(int[][] values) {
        this.values = values;
    }

    /**
     * Проверяет возможность извлечения следующих объектов из массива.
     * @return - true если есть следующий объект. False - если конец массива.
     */
    @Override
    public boolean hasNext() {
        return this.values.length > this.i;
    }

    /**
     * Вернет объект из массива и сдвинет индекс на следующую ячейку.
     * @return - объект.
     */
    @Override
    public Object next() {
        Object value = this.values[this.i][this.j++];

        if (this.j >= this.values[i].length) {
            this.i++;
            this.j = 0;
        }

        return value;
    }
}

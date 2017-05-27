package ru.job4j.iterator;

import java.util.Iterator;

/**
 * 5.1.3. Создать итератор простые числа. [#15308]
 *
 * Created by VLADIMIR on 24.05.2017.
 */
public class IteratorSimpleNumberArray implements Iterator {

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
     * @param values - array.
     */
    public IteratorSimpleNumberArray(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;

        if (this.getNextIndex() != -1) {
            result = true;
        }

        return result;
    }

    @Override
    public Object next() {

        this.index = this.getNextIndex();
        Object result = this.values[this.index];
        this.index++;

        return result;
    }

    /**
     * Проверит является ли число простым.
     * @param value - проверяемое число.
     * @return - true если число простое, false - если число составное.
     */
    public boolean isSimple(int value) {

        boolean result = true;

        if ((value == 0) || (value == 1)) {
            result = false;
        } else {
            for (int i = 2; i <= value / 2; i++) {
                if (value % i == 0) {
                    result = false;
                }
            }
        }

        return result;
    }

    /**
     * Найдет следующий индекс элемента, значение которого - четное число.
     * @return - индекс элемента или -1 если не найден.
     */
    private int getNextIndex() {
        int result = -1;

        for (int i = this.index; i < this.values.length; i++) {
            if (this.isSimple(this.values[i])) {
                result = i;
                break;
            }
        }

        return result;
    }


}

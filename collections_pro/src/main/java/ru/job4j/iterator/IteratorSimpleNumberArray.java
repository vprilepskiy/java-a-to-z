package ru.job4j.iterator;

import java.util.Iterator;

/**
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

    public IteratorSimpleNumberArray(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;

        for (int i = this.index; i < this.values.length; i++) {
            if (this.isPrime(this.values[i])) {
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public Object next() {

        Object result = null;
        boolean again;

        do {
            if (this.isPrime(this.values[this.index])) {
                result = this.values[this.index];
                again = false;
            } else {
                again = true;
            }
            this.index++;
        } while (again);

        return result;
    }


    public boolean isPrime(int value) {

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

}

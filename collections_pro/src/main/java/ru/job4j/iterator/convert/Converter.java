package ru.job4j.iterator.convert;

import java.util.Iterator;

/**
 * Created by VLADIMIR on 27.05.2017.
 */
public class Converter implements IConverter {

    /**
     * Двойной итератор.
     */
    private Iterator<Iterator<Integer>> it;

    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        this.it = it;

        IteratorIterator result = new IteratorIterator();

        return result;
    }

    /**
     * Итератор для двойного итератора.
     */
    private class IteratorIterator implements Iterator<Integer> {

        /**
         * Вложенный итератор.
         */
        private Iterator<Integer> itInner;

        @Override
        public boolean hasNext() {

            boolean result = false;

            if ((this.itInner != null) && (this.itInner.hasNext())) {
                result = true;
            } else {
                result = it.hasNext();
            }

            return result;
        }

        @Override
        public Integer next() {

            if ((this.itInner == null) || !(this.itInner.hasNext())) {
                this.itInner = it.next();
            }

            return this.itInner.next();
        }
    }

}

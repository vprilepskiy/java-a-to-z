package ru.job4j.list.stack;

/**
 * Created by VLADIMIR on 08.06.2017.
 * <p>
 * Stack - первый пришел - последний вышел. (пирамидка)
 *
 * @param <E> - Generic.
 */
public class Stack<E> implements ISimpleContainer<E> {

    /**
     * Последний элемент.
     */
    private Element<E> lastElement;

    @Override
    public void push(E value) {
        this.lastElement = new Element<E>(this.lastElement, value);
    }

    @Override
    public E pop() {
        // получить последний (текущий) элемент.
        Element<E> element = this.lastElement;
        // передать ссылку первому элементу от следующего
        this.lastElement = element.getPrev();
        // вернуть значение первого элемента
        return element.getValue();
    }

    /**
     * Element of linkedList.
     *
     * @param <E> - type value.
     */
    private class Element<E> {

        /**
         * Value.
         */
        private final E value;
        /**
         * Link for prev Element.
         */
        private Element<E> prev;

        /**
         * Constructor.
         *
         * @param prev  - prev link.
         * @param value - value.
         */
        private Element(Element<E> prev, E value) {
            this.prev = prev;
            this.value = value;
        }

        /**
         * Getter.
         *
         * @return - value.
         */
        public E getValue() {
            return value;
        }

        /**
         * Getter.
         *
         * @return - Link for next Element.
         */
        public Element<E> getPrev() {
            return this.prev;
        }
    }
}



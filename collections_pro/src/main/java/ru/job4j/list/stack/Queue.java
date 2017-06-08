package ru.job4j.list.stack;

/**
 * Created by VLADIMIR on 08.06.2017.
 *
 * Queue - первый пришел - первый вышел.
 * @param <E> - generic.
 */
public class Queue<E> implements ISimpleContainer<E> {

    /**
     * Первый элемент.
     */
    private Element<E> firstElement;

    /**
     * Последний элемент.
     */
    private Element<E> lastElement;

    @Override
    public void push(E value) {
        // создать новый элемент
        Element<E> newElement = new Element<E>(value);

        // добавить ссылку о новом элементе в текущий
        if (this.lastElement != null) {
            this.lastElement.setNext(newElement);
        }

        // передать ссылку о новом элементе в текущий
        this.lastElement = newElement;

        // добавить информацию о первом элементе
        if (this.firstElement == null) {
            this.firstElement = newElement;
        }
    }

    @Override
    public E pop() {
        // получить первый (текущий) элемент.
        Element<E> element = this.firstElement;
        // передать ссылку первому элементу от следующего
        this.firstElement = element.getNext();
        // вернуть значение первого элемента
        return element.getValue();
    }

    /**
     * Element of linkedList.
     * @param <E> - type value.
     */
    private class Element<E> {

        /**
         * Value.
         */
        private final E value;
        /**
         * Link for next Element.
         */
        private Element<E> next;

        /**
         * Constructor.
         * @param value - value.
         */
        private Element(E value) {
            this.value = value;
        }

        /**
         * Getter.
         * @return - value.
         */
        public E getValue() {
            return value;
        }

        /**
         * Getter.
         * @return - Link for next Element.
         */
        public Element<E> getNext() {
            return next;
        }

        /**
         * Setter.
         * @param next - Link for next Element.
         */
        public void setNext(Element<E> next) {
            this.next = next;
        }
    }
}


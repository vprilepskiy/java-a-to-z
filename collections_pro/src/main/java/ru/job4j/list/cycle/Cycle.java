package ru.job4j.list.cycle;

/**
 * Created by VLADIMIR on 08.06.2017.
 */
public class Cycle {

    /**
     * Выполнит проверку на зацикливание связных списков.
     *
     * @param first - первый объект из списка.
     * @return - true - если присутствует зацикливание, false - если остутствует зацикливание.
     */
    public boolean hasCycle(Node first) {

        boolean result = false;
        Node tempNode = first;

        while (tempNode.getNext() != null) {
            if (this.hasLinkToBack(tempNode)) {
                result = true;
                break;
            }
            tempNode = tempNode.getNext();
        }
        return result;
    }


    /**
     * Выполнит проверку, что на данный объект не ссылаются все последующие.
     *
     * @param first - проверяемый объект.
     * @return - true - если ссылаются, false - если не ссылаются.
     */
    private boolean hasLinkToBack(Node first) {

        boolean result = false;
        Node tempNode = first;

        // если следующая ссылка not null
        while (tempNode.getNext() != null) {
            // если следующая ссылка ссылается на предыдущий объект или на первый
            if ((tempNode.getNext() == tempNode) || (tempNode.getNext() == first)) {
                result = true;
                break;
            }
            // сдвинуться вправо
            tempNode = tempNode.getNext();
        }
        return result;
    }
}

/**
 * Element of linked list.
 *
 * @param <T> - generic.
 */
class Node<T> {
    /**
     * Value.
     */
    private T value;
    /**
     * Next element.
     */
    private Node<T> next;

    /**
     * Constructor.
     *
     * @param value - value.
     */
    Node(T value) {
        this.value = value;
    }

    /**
     * Getter.
     * @return - link for next element.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter.
     * @param next - link for next element.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Value = " + value;
    }
}



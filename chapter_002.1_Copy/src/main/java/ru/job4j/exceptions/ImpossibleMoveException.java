package ru.job4j.exceptions;

/**
 * Фигура не может туда пойти.
 */
public class ImpossibleMoveException extends Exception {

    /**
     * Exception.
     * @param msg msg
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }

}

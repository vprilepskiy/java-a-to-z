package ru.job4j.exceptions;

/**
 * Фигуры нет в этой ячейке.
 */
public class FigureNotFoundException extends Exception {

    /**
     * Exception.
     * @param msg msg
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }

}

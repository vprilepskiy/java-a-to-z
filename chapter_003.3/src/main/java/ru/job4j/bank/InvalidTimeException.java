package ru.job4j.bank;

/**
 * Created by VLADIMIR on 26.04.2017.
 */
public class InvalidTimeException extends Exception {

    /**
     * Исключение возникает когда не верные временные рамки.
     * @param message - сообщение.
     */
    public InvalidTimeException(String message) {
        super(message);
    }
}

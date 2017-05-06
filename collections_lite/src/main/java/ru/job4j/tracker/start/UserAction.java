package ru.job4j.tracker.start;

/**
 * Интерфейс.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 28.12.2016
 */
public interface UserAction {
    /**
     * Ключ - действие которое мы должны запрашивать у пользователя.
     * @return - ключ.
     */
    int key();

    /**
     * Основные дейсвия.
     * @param input - метод ввода.
     * @param output - метод вывода.
     * @param tracker - механизмы выполнения вводимых команд.
     */
    void execute(Input input, Output output, Tracker tracker);

    /**
     * сообщает, что данный метод делает.
     * @return - сообщение.
     */
    String info();
}
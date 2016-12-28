package ru.job4j.start;

/**
 * Абстрактный класс.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 28.12.2016
 */
public abstract class BaseAction implements UserAction {

    /**
     * Название метода.
     */
    private String name;
    /**
     * Действия.
     */
    private UserAction[] actions;

    /**
     * Конструктор.
     */
    public BaseAction(String name, UserAction[] actions) {
        this.name = name;
        this.actions = actions;
    }

    /**
     * Ключ - действие которое мы должны запрашивать у пользователя.
     * @return - ключ.
     */
    public int key() {
        int key = -1;
        int index = 0;
        for (UserAction userAction : actions) {
            if (userAction != null && userAction == this) {
                key = index;
            }
            index++;
        }
        return key;
    }

    /**
     * Основные дейсвия.
     * @param input - метод ввода.
     * @param output - метод вывода.
     * @param tracker - механизмы выполнения вводимых команд.
     */
    public abstract void execute(Input input, Output output, Tracker tracker);

    /**
     * сообщает, что данный метод делает.
     * @return - сообщение.
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}

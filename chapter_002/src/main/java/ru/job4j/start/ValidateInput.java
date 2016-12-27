package ru.job4j.start;

/**
 * Класс ввода данных с консоли с обработкой ошибок.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 27.12.2016
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Задает вопрос, получает ответ. Если ошибка, то задает вопрос повторно.
     * @param question - запрос.
     * @param range - массив разрешенных ответов.
     * @return - ответ.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace();
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate date again.");
            }
        } while (invalid);
        return value;
    }
}

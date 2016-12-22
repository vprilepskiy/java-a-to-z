package ru.job4j.start;

/**
 * Интерфейс ввода данных.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 22.12.2016
 */
public interface Input {

	/**
	 * Задает вопрос, получает ответ.
	 * @param question - запрос.
	 * @return - ответ.
	 */
	public String ask (String question);
}

package ru.job4j.start;

import ru.job4j.models.Item;

/**
 * Интерфейс вывода данных.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 22.12.2016
 */
public interface Output {

	/**
	 * Получает ответы от Tracker.
	 * @param items - массив заявок.
	 */
	void answer(Item[] items);
}
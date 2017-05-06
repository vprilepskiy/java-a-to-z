package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.ArrayList;

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
	void answer(ArrayList<Item> items);
}
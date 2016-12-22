package ru.job4j.start;

import ru.job4j.models.Item;
import ru.job4j.models.ItemGetString;

/**
 * Класс вывода данных в массив.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 22.12.2016
 */
public class StubOutput implements Output {

	/**
	 * Массив ответов.
	 */
	private String[] asks = null;

	/**
	 * Выведет в массив содержимое заявки.
	 * @param items - заявки.
	 */
	public void answer(Item[] items) {
		asks = new String[items.length];
		int index = 0;
		for (Item item : items) {
			if (item != null) {
				asks[index] = "№ " + index + "; " + new ItemGetString(item).getLine();
			}
			index++;
		}
	}

	/**
	 * Возвращает массив ответов.
	 * @return - ответы.
	 */
	public String[] getAsks() {
		return asks;
	}
}
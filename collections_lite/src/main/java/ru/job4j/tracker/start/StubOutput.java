package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.ItemGetString;

import java.util.ArrayList;

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
	@Override
	public void answer(ArrayList<Item> items) {
		this.asks = new String[items.size()];
		int index = 0;
		for (Item item : items) {
			if (item != null) {
				this.asks[index] = "№ " + index + "; " + new ItemGetString(item).getLine();
			}
			index++;
		}
	}

	/**
	 * Возвращает массив ответов.
	 * @return - ответы.
	 */
	public String[] getAsks() {
		return this.asks;
	}

}
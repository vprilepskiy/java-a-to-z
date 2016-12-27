package ru.job4j.start;

import ru.job4j.models.Item;
import ru.job4j.models.ItemGetString;

/**
 * Класс вывода данных в консоль.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 22.12.2016
 */
public class ConsoleOutput implements Output {

	/**
	 * Выведет в консоль содержимое заявки.
	 * @param items - заявки.
	 */
	public void answer(Item[] items) {
		int index = 0;
		for (Item item : items) {
			if (item != null) {
				System.out.println("№ " + index + "; " + new ItemGetString(item).getLine());
			}
			index++;
		}
	}
}
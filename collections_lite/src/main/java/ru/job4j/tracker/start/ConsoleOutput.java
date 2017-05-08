package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.ItemGetString;

import java.util.ArrayList;

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
	@Override
	public void answer(ArrayList<Item> items) {
		int index = 0;
		for (Item item : items) {
			if (item != null) {
				System.out.println("№ " + index + "; " + new ItemGetString(item).getLine());
			}
			index++;
		}
	}
}
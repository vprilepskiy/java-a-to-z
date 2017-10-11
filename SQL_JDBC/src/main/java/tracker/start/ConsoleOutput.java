package tracker.start;


import tracker.models.Item;

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
				System.out.printf("%S %d %S %S \n" , "№", index, ";", item.toString());
			}
			index++;
		}
	}
}
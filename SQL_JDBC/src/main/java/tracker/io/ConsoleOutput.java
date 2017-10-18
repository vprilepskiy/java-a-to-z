package tracker.io;

import tracker.models.Item;
import java.util.List;

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
	public void answer(List<Item> items) {
		for (Item item : items) {
			if (item != null) {
				System.out.println(item);
			}
		}
	}
}
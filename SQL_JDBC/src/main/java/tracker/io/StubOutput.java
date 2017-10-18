package tracker.io;

import tracker.models.Item;

import java.util.List;

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
	public void answer(List<Item> items) {
		this.asks = new String[items.size()];
		int index = 0;
		for (Item item : items) {
			if (item != null) {
				this.asks[index] = String.format("№ %d; name: %s; desc: %s", item.getId(), item.getName(), item.getDescription());
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
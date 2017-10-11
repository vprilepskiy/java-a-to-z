package tracker.start;



import tracker.models.Item;

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
				this.asks[index] = String.format("%S %d %S %S \n" , "№", index, ";", item.toString());
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
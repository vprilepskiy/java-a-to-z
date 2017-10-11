package tracker.models;

/**
 * Класс преобразует Item для чтения.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 22.12.2016
 */
public class ItemGetString {

	/**
	 * заявка.
	 */
	private Item item;

	/**
	 * Конструктор.
	 * @param item - заявка.
	 */
	public ItemGetString(Item item) {
		this.item = item;
	}

	/**
	 * Преобразует Item в String.
	 * @return - строка.
	 */
	public String getLine() {
		return "name: " + this.item.getName() + "; " + "desc: " + this.item.getDescription() + "; " + "create: " + this.item.getCreate();
	}
}
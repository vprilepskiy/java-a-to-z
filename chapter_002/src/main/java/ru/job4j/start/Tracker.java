package ru.job4j.start;

import java.util.Random;
import ru.job4j.models.Item;

/**
 * Класс агрегирует Item.
 * @author Vladimir Prilepskiy
 * @since 14.12.2016
 * @version 1
 */
public class Tracker {

	/**
	 * размер массива.
	 */
	private final int sizeArray = 1000;
	/**
	 * массив заявок.
	 */
	private Item[] items = new Item[sizeArray];
	/**
	 * позиция в массиве последнй заявки.
	 */
	private int position = 0;
	/**
	 * для ключа.
	 */
	private static final Random RM = new Random();

	/**
	 * Добавляет заявку.
	 * @param item - заявка.
	 * @return - заявка.
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[position++] = item;
		return item;
	}

	/**
	 * Редактирует заявку.
	 * @param item - заявка.
	 * @return - заявка.
	 */
	public Item update(Item item) {
		Item result = findById(item.getId());
		result.setName(item.getName());
		result.setDescription(item.getDescription());
		result.setCreate(item.getCreate());
		return result;
	}

	/**
	 * Удаляет заявку.
	 * @param item - заявка.
	 * @return - true если удалена и false если не удалена.
	 */
//	public boolean del(Item item) {
//		boolean result = false;
//		if (item != null) {
//			item = null;
//			result = true;
//		}
//		return result;
//	}
	public boolean del(Item item) {
		boolean result = false;
		int index = 0;
		for (Item it : items) {
			if (it != null && it.equals(item)) {
				items[index] = null;
				result = true;
				break;
			}
			index++;
		}
		return result;
	}

	/**
	 * Найдет по id.
	 * @param id - ключ заявки.
	 * @return - заявка.
	 */
	protected Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

	/**
	 * Найдет по названию.
	 * @param name - название.
	 * @return - заявка.
	 */
	protected Item[] findByName(String name) {
		Item[] result = new Item[position];
		int index = 0;
		for (Item item : items) {
			if (item != null && item.getName().equals(name)) {
				result[index] = item;
				index++;
			}
		}
		return result;
	}

	/**
	 * Найдет по описанию.
	 * @param description - описание.
	 * @return - заявка.
	 */
	protected Item[] findByDescription(String description) {
		Item[] result = new Item[position];
		int index = 0;
		for (Item item : items) {
			if (item != null && item.getDescription().equals(description)) {
				result[index] = item;
				index++;
			}
		}
		return result;
	}

	/**
	 * Найдет по дате создания.
	 * @param create - дата создания.
	 * @return - заявка.
	 */
	protected Item[] findByCreate(long create) {
		Item[] result = new Item[position];
		int index = 0;
		for (Item item : items) {
			if (item != null && item.getCreate() == create) {
				result[index] = item;
				index++;
			}
		}
		return result;
	}


	/**
	 * Генерирует уникальный ключ.
	 * @return - уникальный ключ.
	 */
	String generateId() {
		final int maxRandom = 100;
		return String.valueOf(System.currentTimeMillis() + RM.nextInt(maxRandom));
	}

	/**
	 * Выведет все заявки.
	 * @return - все заявки.
	 */
	public Item[] getAll() {
		Item[] result = new Item[position];
		for (int index = 0; index != position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}

	/**
	 * Добавит комментарий.
	 * @param item - заявка.
	 * @param comment - комментарий.
	 * @return - заявка.
	 */
	public Item addComment(Item item, String comment) {
		if (comment != null) {
			// если нет ни одного комментария
			if (item.getComment() == null) {
				String[] arrComment = {comment};
				item.setComment(arrComment);
			} else {
				String[] arrComment = new String[item.getComment().length + 1];
				item.setComment(arrComment);
			}
		}
		return item;
	}
}
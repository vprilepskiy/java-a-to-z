package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.ArrayList;
import java.util.Random;

/**
 * Класс агрегирует Item.
 * @author Vladimir Prilepskiy
 * @since 14.12.2016
 * @version 1
 */
public class Tracker {

	/**
	 * Лист заявок.
	 */
	private ArrayList<Item> items = new ArrayList<Item>();

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
		Item result = null;
		item.setId(this.generateId());
		if (this.items.add(item)) {
			result = item;
		}
		return result;
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
	public boolean del(Item item) {
		return this.items.remove(item);
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
	protected ArrayList<Item> findByName(String name) {
		ArrayList<Item> result = new ArrayList<Item>();
		for (Item item : items) {
			if (item != null && item.getName().equals(name)) {
				result.add(item);
			}
		}
		return result;
	}

	/**
	 * Найдет по описанию.
	 * @param description - описание.
	 * @return - заявка.
	 */
	protected ArrayList<Item> findByDescription(String description) {
		ArrayList<Item> result = new ArrayList<Item>();
		for (Item item : items) {
			if (item != null && item.getDescription().equals(description)) {
				result.add(item);
			}
		}
		return result;
	}

	/**
	 * Найдет по дате создания.
	 * @param create - дата создания.
	 * @return - заявка.
	 */
	protected ArrayList<Item> findByCreate(long create) {
		ArrayList<Item> result = new ArrayList<Item>();
		for (Item item : items) {
			if (item != null && item.getCreate() == create) {
				result.add(item);
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
	public ArrayList<Item> getAll() {
		return this.items;
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
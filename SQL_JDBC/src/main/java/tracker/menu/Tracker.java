package tracker.menu;


import tracker.db.DB;
import tracker.models.Item;
import tracker.Settings;

import java.util.List;

/**
 * Класс агрегирует Item.
 * @author Vladimir Prilepskiy
 * @since 14.12.2016
 * @version 1
 */
public class Tracker {

	/**
	 * Manager for DB.
	 */
	private final DB.Manager dbManager;

	/**
	 * Settings.
	 */
	private final Settings settings;

	/**
	 * Constructor.
	 * @param db - db.
	 * @param settings - settings.
	 */
	public Tracker(DB db, Settings settings) {
		this.dbManager = db.new Manager();
		this.settings = settings;
	}



	/**
	 * Добавляет заявку.
	 * @param item - заявка.
	 * @return - заявка.
	 */
	public Item add(Item item) {
		Item result = null;

		String prepareSQL = settings.getValue("SQL_INSERT_INTO_ITEMS");
		Object[] args = new Object[]{item.getName(), item.getDescription(), System.currentTimeMillis()};

		if (this.dbManager.update(prepareSQL, args) > 0) {
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
		Item result = null;

		String prepareSQL = settings.getValue("SQL_UPDATE_ITEMS");
		Object[] args = new Object[]{item.getName(), item.getDescription(), item.getId()};

		if (this.dbManager.update(prepareSQL, args) > 0) {
			result = item;
		}
		return null;
	}




	/**
	 * Удаляет заявку.
	 * @param item - заявка.
	 * @return - true если удалена и false если не удалена.
	 */
	public boolean del(Item item) {
		boolean result = false;

		final String prepareSQL = settings.getValue("DELETE_FROM_ITEMS");
		Object arg = item.getId();
		if (dbManager.update(prepareSQL, arg) > 0) {
			result = true;
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

		final String prepareSQL = settings.getValue("SELECT_ITEMS_WHERE_ID");
		final List<Item> rows = dbManager.getItems(prepareSQL, id);

		if (rows.size() > 0) {
			result = rows.get(0);
		}

		return result;
	}

	/**
	 * Найдет по названию.
	 * @param name - название.
	 * @return - заявка.
	 */
	protected List<Item> findByName(String name) {
		final String prepareSQL = settings.getValue("SELECT_ITEMS_WHERE_NAME");
		return dbManager.getItems(prepareSQL, name);
	}

	/**
	 * Найдет по описанию.
	 * @param description - описание.
	 * @return - заявка.
	 */
	protected List<Item> findByDescription(String description) {
		final String prepareSQL = settings.getValue("SELECT_ITEMS_WHERE_DESCRIPTION");
		return dbManager.getItems(prepareSQL, description);
	}


	/**
	 * Найдет по дате создания.
	 * @param create - дата создания.
	 * @return - заявка.
	 */
	protected List<Item> findByCreate(long create) {
		final String prepareSQL = settings.getValue("SELECT_ITEMS_WHERE_CREATE_DATE");
		return dbManager.getItems(prepareSQL, create);
	}




	/**
	 * Выведет все заявки.
	 * @return - все заявки.
	 */
	public List<Item> getAll() {
		final String sql = settings.getValue("SELECT_ITEMS_ALL");
		return dbManager.getItems(sql);
	}




	/**
	 * Добавит комментарий.
	 * @param item - заявка.
	 * @param comment - комментарий.
	 * @return - заявка.
	 */
	public Item addComment(Item item, String comment) {
		Item result = null;

		final String prepareSQL = settings.getValue("SQL_INSERT_INTO_COMMENTS");
		Object[] args = new Object[]{comment, item.getId()};

		if (this.dbManager.update(prepareSQL, args) > 0) {
			result = item;
		}
		return result;
	}
}
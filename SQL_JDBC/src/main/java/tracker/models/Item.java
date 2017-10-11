package tracker.models;

/**
 * Класс деталь.
 * @author Vladimir Prilepskiy
 * @since 14.12.2016
 * @version 1
 */
public class Item {

	/**
	 * Название.
	 */
	private String name;
	/**
	 * Описание.
	 */
	private String description;
	/**
	 * Время создания.
	 */
	private long create;
	/**
	 * Комментарии.
	 */
	private String[] comment;
	/**
	 * Уникальный ключ.
	 */
	private String id;

	/**
	 * Конструктор пустой.
	 */
	public Item() {
	}

	/**
	 * Конструктор.
	 * @param name - имя.
	 * @param description - описание.
	 * @param create - время создания.
	 */
	public Item(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
	}

	/**
	 * Setter.
	 * @param name - имя.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter.
	 * @param description - описание.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Setter.
	 * @param create - время создания.
	 */
	public void setCreate(long create) {
		this.create = create;
	}

	/**
	 * Setter.
	 * @param id - уникальный ключ.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Setter.
	 * @param comment - комментарии.
	 */
	public void setComment(String[] comment) {
		this.comment = comment;
	}

	/**
	 * Setter.
	 * @return - имя.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter.
	 * @return - описание.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Getter.
	 * @return - время создания.
	 */
	public long getCreate() {
		return this.create;
	}

	/**
	 * Getter.
	 * @return уникальный ключ.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Getter.
	 * @return - комментарии.
	 */
	public String[] getComment() {
		return comment;
	}
}
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
	 * Уникальный ключ.
	 */
	private int id;

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
	public void setId(int id) {
		this.id = id;
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
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ");
		sb.append(this.id);
		sb.append("; name: ");
		sb.append(this.name);
		sb.append("; desc: ");
		sb.append(this.description);
		sb.append("; create: ");
		sb.append(this.create);
		return sb.toString();
	}
}
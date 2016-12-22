package ru.job4j.models;

/**
 * ����� ����������� Item ��� ������.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 22.12.2016
 */
public class ItemGetString {

	/**
	 * ������.
	 */
	private Item item;

	/**
	 * �����������.
	 * @param item - ������.
	 */
	public ItemGetString (Item item) {
		this.item = item;
	}

	/**
	 * ����������� Item � String.
	 * @return - ������.
	 */
	public String getLine () {
		return "name: " + this.item.getName() + "; " + "desc: " + this.item.getDescription() + "; " + "create: " + this.item.getCreate();
	}
}
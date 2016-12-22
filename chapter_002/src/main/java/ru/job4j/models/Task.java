package ru.job4j.models;

/**
 * Task.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 14.12.2016
 */
public class Task extends Item {

	/**
	 * Конструктор.
	 * @param name - имя.
	 * @param desc - описание.
	 */
	public Task (String name, String desc){
		this.name = name;
		this.description = desc;
	}

	/**
	 * Просто для примера.
	 * @return - просто строка.
	 */
	public String calculatePrice() {
		return "100%";
	}
}
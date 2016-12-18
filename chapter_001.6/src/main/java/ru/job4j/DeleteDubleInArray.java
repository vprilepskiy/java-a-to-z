package ru.job4j;

import java.util.Arrays;

/**
 * Работа с массивами.
 * @author vprilepskiy
 * @since 01.12.2016
 * @version 1
 */
 public class DeleteDubleInArray {

	/**
	 * Массив.
	 */
	private String[] array;

	/**
	 * Конструктор.
	 * @param array - массив.
	 */
	DeleteDubleInArray(String[] array) {
		this.array = array;
	}

	/**
	 * Возвращает массив с уникальными элентами.
	 * @return массив с уникальными элентами.
	 */
	public String[] uniqueElements() {
		String[] uniqueArray = new String[this.array.length];
		int indexUnique = 0;
		for (int index = 0; index <= this.array.length - 1; index++) {
			if (!existsInArray(uniqueArray, this.array[index])) {
				uniqueArray [indexUnique] = this.array[index];
				indexUnique++;
			}
		}
		return Arrays.copyOf(uniqueArray, indexUnique);
	}

	/**
	 * Проверяет существование элемента в массиве.
	 * @param array - массив.
	 * @param sought - искомый элемент.
	 * @return - true если найден или false если не найден.
	 */
	private boolean existsInArray(String[] array, String sought) {
		boolean exists = false;
		for (int index = 0; index < array.length - 1; index++) {
			if (sought.equals(array[index])) {
				exists = true;
				break;
			}
		}
		return exists;
	}
}
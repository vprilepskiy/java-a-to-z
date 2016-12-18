package ru.job4j;

/**
 * Работа с массивами.
 * @author vprilepskiy
 * @since 30.11.2016
 * @version 1
 */
public class Turn {

	/**
	 * Массив.
	 */
	private int[] array;

	/**
	 * Конструктор.
	 * @param array - массив
	 */
	Turn(int[] array) {
		this.array = array;
	}

	/**
	 * Разворачивает массив.
	 */
	public void back() {
		int left;
		int right;
		int backIndex = this.array.length - 1;
		for (int index = 0; index < this.array.length / 2; index++) {
			left = this.array[index];
			right = this.array[backIndex];
			this.array[index] = right;
			this.array[backIndex] = left;
			backIndex--;
		}
	}

	/**
	 * Сортирует массив мотодом пузырька.
	 */
	public void bubbleSort() {
		int left;
		int right;
		boolean again = true;
		while (again) {
			again = false;
			for (int index = 0; index < this.array.length - 1; index++) {
				left = this.array[index];
				right = this.array[index + 1];
				// сравнить left и right и поменять местами
				if (left > right) {
					this.array[index] = right;
					this.array[index + 1] = left;
					// если была замена, поднять флаг
					again = true;
				}
			}
		}
	}
}
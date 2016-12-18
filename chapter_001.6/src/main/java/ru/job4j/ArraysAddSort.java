package ru.job4j;

/**
 * Объеденит и отсортирует массив.
 * @author vprilepskiy
 * @version 1
 * @since 05.12.2016
 */
public class ArraysAddSort {

	/**
	 * Объединенный массив.
	 */
	private int[] arrAdd;

	/**
	 * Индекс пустой ячейки.
	 */
	private int index = 0;

	/**
	 * Объеденит и отсортирует массив.
	 * @param arrayA - массив для добавления.
	 * @param arrayB - массив для добавления.
	 * @return - объедененный и отсортированный массив.
	 */
	public int[] add(int[] arrayA, int[] arrayB) {
		this.arrAdd = new int[arrayA.length + arrayB.length];

		int indexA = 0;
		int indexB = 0;

		boolean again = true;
		while (again) {
			// если индексА меньше чем длиннаМассивА и если индексБ мненьше чем длиннаМассивБ
			if ((indexA <= arrayA.length - 1) && (indexB <= arrayB.length - 1)) {
				// если А меньше Б
				if (arrayA[indexA] < arrayB[indexB]) {
					// добавить А
					put(arrayA[indexA]);
					indexA++;
					// если Б меньше А
				} else if (arrayB[indexB] < arrayA[indexA]) {
					// добавить Б
					put(arrayB[indexB]);
					indexB++;
					// если А равно Б
				} else {
					// добавить А и Б
					put(arrayA[indexA]);
					indexA++;
					put(arrayB[indexB]);
					indexB++;
				}
				// если индексА меньше чем длиннаМассивА и если индексБ больше чем длиннаМассивБ
			} else if ((indexA <= arrayA.length - 1) && (indexB > arrayB.length - 1)) {
				// добавить А
				put(arrayA[indexA]);
				indexA++;
				// если индексБ меньше чем длиннаМассивБ и если индексА больше чем длиннаМассивА
			} else if ((indexB <= arrayB.length - 1) && (indexA > arrayA.length - 1)) {
				// добавить Б
				put(arrayB[indexB]);
				indexB++;
			} else {
				// break;
				again = false;
			}
		}
		return this.arrAdd;
	}

	/**
	 * Добавит элемент в массив.
	 * @param element - элемент.
	 */
	private void put(int element) {
		if (this.arrAdd.length >= this.index) {
			this.arrAdd[index] = element;
			this.index++;
		} else {
			System.err.println("Невозможно добавить элемент: " + element + " в индекс: " + (index + 1));
		}
	}
}
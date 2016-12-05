package ru.job4j;

import java.util.Arrays;

/**
 * Объеденит и отсортирует массив.
 * @author vprilepskiy
 * @since 05.12.2016
 * @version 1
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
	 * @param array0 - массив для добавления.
	 * @param array1 - массив для добавления.
	 * @return - объедененный и отсортированный массив.
	 */
	public int[] add(int[] array0, int[] array1) {
		this.arrAdd = new int[array0.length + array1.length];
		put(array0);
		put(array1);
		Arrays.sort(this.arrAdd);
		return this.arrAdd;
	}

	/**
	 * Добавит элементы в массив.
	 * @param array - массив.
	 */
	private void put(int[] array) {
		for (int element : array) {
			this.arrAdd[index] = element;
			this.index++;
		}
	}
}
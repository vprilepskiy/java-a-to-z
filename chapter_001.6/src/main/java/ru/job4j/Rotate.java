package ru.job4j;

/**
 * Работа с массивами.
 * @author vprilepskiy
 * @since 30.11.2016
 * @version 1
 */
public class Rotate {

	/**
	 * массив для поворота.
	 */
	private int[][] values;

	/**
	 * Конструктор.
	 * @param values - квадратный массив.
	 */
	Rotate(int[][] values) {
		this.values = values;
	}

	/**
	 * повернуть на 90 градусов.
	 */
	public void rollRight() {
		final int[][] clonelValues = this.values.clone();
		for (int i = 0; i < clonelValues.length; i++) {
			clonelValues[i] = this.values[i].clone();
		}
		for (int indexLine = 0; indexLine < clonelValues.length; indexLine++) {
			int rotateIndexColumn = clonelValues[0].length - 1;
			for (int indexColumn = 0; indexColumn < clonelValues[indexLine].length; indexColumn++) {
				this.values[indexLine][rotateIndexColumn] = clonelValues[indexColumn][indexLine];
				rotateIndexColumn--;
			}
		}
	}
}
package ru.job4j;

/**
 * Найти максимальное значение.
 * @author vprilepskiy
 * @since 27.11.2016
 * @version 1
 */
public class Max {

	/**
	 * Метод находит максимальное значение.
	 * @param first - первое значение.
	 * @param second - второе значение.
	 * @return - максимальное значение.
	 */
	public int max(int first, int second) {
		int maxValue = first > second ? first : second;
		return maxValue;
	}

	/**
	 * Метод находит максимальное значение.
	 * @param first - первое значение.
	 * @param second - второе значение.
	 * @param third - третье значение.
	 * @return - максимальное значение.
	 */
	public int max(int first, int second, int third) {
		int maxBetweenFirstAndSecond = first > second ? first : second;
		int maxBetweenSecondAndThird = second > third ? second : third;
		int maxValue = maxBetweenFirstAndSecond > maxBetweenSecondAndThird ? maxBetweenFirstAndSecond : maxBetweenSecondAndThird;
		return maxValue;
	}
}
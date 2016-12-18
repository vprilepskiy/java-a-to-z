package ru.job4j;

/**
 * Математические функции.
 * @author vprilepskiy
 * @since 28.11.2016
 * @version 1
 */
public class Counter {

	/**
	 * Подсчет суммы четных чисел в диапозоне.
	 * @param start - первое число.
	 * @param finish - последнее число.
	 * @return - сумма четных чисел
	 */
	int add(int start, int finish) {
		int sumEven = 0;
		for (int index = start; index <= finish; index++) {
			if (index % 2 == 0) {
				sumEven = sumEven + index;
			}
		}
		return sumEven;
	}

	/**
	 * Вычисляет факториал.
	 * @param value - число
	 * @return - факториал
	 */
	int factorial(int value) {
		int result = 1;
		if (value != 0) {
			for (int i = 1; i <= value; i++) {
				result = result * i;
			}
		}
		return result;
	}
}
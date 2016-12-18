package ru.job4j;

/**
 * Class Calculator.
 * @author vprilepskiy
 * @since 25.11.2016
 * @version 1
 */
public class Calculator {
	/**
	 * результат.
	 */
	private double result = 0;

	/**
	 * Метод сложения.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	 * Метод вычитания.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 */
	public void subtract(double first, double second) {
		this.result = first - second;
	}
		/**
	 * Метод умножения.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}
		/**
	 * Метод деления.
	 * @param first - первый аргумент.
	 * @param second - второй аргумент.
	 */
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
	 * Метод умножения результат.
	 * @return - результат
	 */
	public double getResult() {
		return this.result;
	}
}
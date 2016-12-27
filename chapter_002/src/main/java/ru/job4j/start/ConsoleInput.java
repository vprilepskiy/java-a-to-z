package ru.job4j.start;

import java.util.Scanner;

/**
 * Класс ввода данных с консоли.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 27.12.2016
 */
public class ConsoleInput implements Input {

	/**
	 * Сканнер.
	 */
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Задать вопрос, получить ответ.
	 * @param question - запрос.
	 * @return - введенное с консоли.
	 */
	public String ask(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}

	/**
	 * Задает вопрос, получает ответ.
	 * @param question - запрос.
	 * @param range - массив разрешенных ответов.
	 * @return - ответ.
	 */
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
				break;
			}
		}
		if (exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range.");
		}
	}
}
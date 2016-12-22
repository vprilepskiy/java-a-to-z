package ru.job4j.start;

import java.util.Scanner;

/**
 * Класс ввода данных с консоли.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 22.12.2016
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

}
package ru.job4j.start;

/**
 * Класс ввода данных для тестирования.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 22.12.2016
 */
public class StabInput implements Input {
	/**
	 * массив команд.
	 */
	private String[] answers;
	/**
	 * позиция.
	 */
	private int position = 0;

	/**
	 * Констркутор.
	 * @param answers - массив команд.
	 */
	public StabInput(String[] answers) {
		this.answers = answers;
	}

	/**
	 * Поочередно задает вопросы и возвращает ответы.
	 * @param question - запрос.
	 * @return - ответ.
	 */
	public String ask(String question) {
		return answers[position++];
	}
}

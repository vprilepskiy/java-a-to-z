package tracker.io;

import tracker.menu.MenuOutException;

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

	@Override
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
			StringBuilder sb = new StringBuilder();

			sb.append("Out of menu rang!!!");
			sb.append('\n');

			sb.append("value entered: ");
			sb.append(key);
			sb.append('\n');

			for (int validValue : range) {
				sb.append("valid value :");
				sb.append(validValue);
				sb.append('\n');
			}

			throw new MenuOutException(sb.toString());
		}
	}
}
package tracker.io;

/**
 * Интерфейс ввода данных.
 * @author Vladimir Prilepskiy
 * @version 1
 * @since 22.12.2016
 */
public interface Input {

	/**
	 * Задает вопрос, получает ответ.
	 * @param question - запрос.
	 * @return - ответ.
	 */
	String ask(String question);

	/**
	 * Задает вопрос, получает ответ.
	 * @param question - запрос.
	 * @param range - массив разрешенных ответов.
	 * @return - ответ.
	 */
	int ask(String question, int[] range);
}
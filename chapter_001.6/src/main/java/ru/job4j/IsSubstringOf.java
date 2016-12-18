package ru.job4j;

/**
 * Поиск подстроки.
 * @author vprilepskiy
 * @since 04.12.2016
 * @version 1
 */
public class IsSubstringOf {

	/**
	 * Выполняет проверку содержания подстроки в строке.
	 * @param origin - строка.
	 * @param sub - подстрока.
	 * @return - true если является подстрокой.
	 */
	boolean contains(String origin, String sub) {

		boolean isSubstring = false;

		char[] arrOrigin = origin.toCharArray();
		char[] arrSub = sub.toCharArray();

		// длины строк
		int originLengh = arrOrigin.length;
		int subLengh = arrSub.length;

		// кол-во проверок
		int countSearch = originLengh - subLengh;

		for (int indexRightShift = 0; indexRightShift <= countSearch; indexRightShift++) {
			for (int indexSub = 0; indexSub < subLengh; indexSub++) {
				if (arrOrigin[indexRightShift + indexSub] == arrSub[indexSub]) {
					isSubstring = true;
				} else {
					isSubstring = false;
					break;
				}
			}
			if (isSubstring) {
				break;
			}
		}
		return isSubstring;
	}
}
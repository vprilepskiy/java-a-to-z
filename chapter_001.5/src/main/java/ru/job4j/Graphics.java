package ru.job4j;

/**
 * Псевдографика.
 * @author vprilepskiy
 * @since 28.11.2016
 * @version 1
 */
public class Graphics {

	/**
	 * метод создает линию для пирамиды.
	 * @param h - этаж пирамиды.
	 * @return - линия пирамиды без пробелов вначале.
	 */
	String piramidLine(int h) {
		StringBuffer sb = new StringBuffer();
		if (h > 0) {
			sb.append('^');
			if (h > 1) {
				int spaceCount = (h - 2) * 2 + 1;
				for (int indexLine = 0; indexLine < spaceCount; indexLine++) {
					sb.append(' ');
				}
				sb.append('^');
			}
		}
		return sb.toString();
	}

	/**
	 * Метод создает всю пирамиду.
	 * @param h - Высота пирамиды.
	 * @return - возвращает прирамиду
	 */
	String piramid(int h) {
		StringBuffer sb = new StringBuffer();
		int indexLine = 0;
		for (int indexColumn = h; indexColumn > 0; indexColumn--) {
			indexLine++;
			for (int spaceCount = indexColumn; spaceCount > 1; spaceCount--) {
				sb.append(' ');
			}
			sb.append(piramidLine(indexLine) + '\n');
		}
		return sb.toString();
	}
}
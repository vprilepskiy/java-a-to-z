package ru.job4j;

/**
 * Created by VLADIMIR on 13.01.2017.
 */
public class Brackets {

    /**
     * Проверяет кол-во открывающих скобок против закрывающих.
     *
     * @param line - строка.
     * @return - true если выражение верное.
     */
    public boolean validExpression(String line) {
        boolean result = true;
        int count = 0;
        final char openBracket = '(';
        final char closeBracket = ')';

        for (char ch : line.toCharArray()) {
            if (ch == openBracket) {
                count++;
            }
            if (ch == closeBracket) {
                count--;
            }
            if (count < 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}

package ru.prilepskiy.good.word;

public class GoodWord {

    public String convert(String word) {
        final StringBuilder sb = new StringBuilder(word);

        if (1 > word.length() || word.length() > 2 * Math.pow(10, 5)) {
            throw new IllegalArgumentException("Количество символов в строке не соответствует числу n (1≤n≤2*10^5)");
        }

        for (int i = 0; i < sb.length(); i = i + 2) {
            while (true) {
                if (sb.length() <= i + 1) {
                    sb.deleteCharAt(i);
                    break;
                } else if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                } else {
                    break;
                }
            }
        }

        return sb.toString();
    }
}

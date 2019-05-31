package ru.prilepskiy.good.word;

public class GoodWord {

    public Word convert(Word w) {
        final StringBuilder sb = new StringBuilder(w.getS());

        if (1 > w.getK() || w.getK() > 2 * Math.pow(10, 5)) {
            throw new IllegalArgumentException("Количество символов в строке не соответствует числу n (1≤n≤2*10^5)");
        } else if (w.getK() != w.getS().length()) {
            throw new IllegalArgumentException("Число символов в строке не соответствует числу n.");
        } else {
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
        }
        return new Word(w.getS().length() - sb.length(), sb.toString());
    }
}

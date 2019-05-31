package ru.prilepskiy.good.word;

public class Word {

    private final int k;
    private final String s;

    public Word(int k, String s) {
        this.k = k;
        this.s = s;
    }

    public int getK() {
        return k;
    }

    public String getS() {
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (k != word.k) return false;
        return s != null ? s.equals(word.s) : word.s == null;
    }

    @Override
    public int hashCode() {
        int result = k;
        result = 31 * result + (s != null ? s.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Word{" +
            "k=" + k +
            ", s='" + s + '\'' +
            '}';
    }
}

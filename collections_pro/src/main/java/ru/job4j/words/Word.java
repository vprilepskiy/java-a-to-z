package ru.job4j.words;

import java.util.Arrays;

/**
 * Created by VLADIMIR on 22.09.2017.
 */
public class Word {

    /**
     * Word 1.
     */
    private final String word;

    /**
     * Constructor.
     * @param word - Word 1.
     */
    public Word(String word) {
        this.word = word;
    }

    /**
     * Equals two words on chars.
     * @param word - Word 2.
     * @return - True if the set of letters the same.
     */
    public boolean equalsIgnoreOrder(String word) {

        // to array
        char[] arr1 = this.word.toCharArray();
        char[] arr2 = word.toCharArray();

        // Sort. Java 8.
        Arrays.parallelSort(arr1);
        Arrays.parallelSort(arr2);

        // equals Strings.
        return new String(arr1).equals(new String(arr2));
    }
}

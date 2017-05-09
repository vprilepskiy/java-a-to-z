package ru.job4j.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by VLADIMIR on 08.05.2017.
 */
public class Sort {

    /**
     * String.compareTo возвращает 1, 0, -1.
     */
    public void compareTest() {

        System.out.println("Aleksandr".compareTo("Boris"));
        System.out.println("Boris".compareTo("Boris"));
        System.out.println("Boris".compareTo("Aleksandr"));
    }

    /**
     * Comparator. Задает условия сортировки.
     */
    public void sortCollection() {

        ArrayList<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList("Boris", "Alex", "Fedor", "Ivan"));

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        };

        list.sort(comparator);

        for (String element : list) {
            System.out.println(element);
        }

    }

    /**
     * Main.
     * @param args - аргументы.
     */
    public static void main(String[] args) {
        new Sort().compareTest();
        new Sort().sortCollection();
    }
}

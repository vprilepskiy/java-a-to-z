package ru.job4j.multisorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by VLADIMIR on 16.05.2017.
 */
public class Sorter {

    /**
     * Разделитель.
     */
    private final String regex = "\\\\";
    /**
     * Коллекция.
     */
    private Set<List<String>> listSet;


    /**
     * Конструктор.
     * @param lines - массив строк.
     */
    public Sorter(String[] lines) {
        this.arrayToCollection(lines);
    }


    /**
     * Преобразует массив в коллекцию.
     * @param lines - массив строк.
     */
    private void arrayToCollection(String[] lines) {
        this.listSet = new HashSet<>();
        for (String line : lines) {
            String[] arr = line.split(this.regex);
            this.listSet.add(Arrays.asList(arr));
        }
    }


    /**
     * Вернет коллекцию.
     * @return - коллекция.
     */
    public Set<List<String>> getCollection() {
        return this.listSet;
    }


    /**
     * Преобразует коллекцию в массив.
     * @return - массив.
     */
    public String[] getArray() {

        String[] result = new String[this.listSet.size()];

        int index = 0;
        for (List<String> list : this.listSet) {

            StringBuilder sb = new StringBuilder();

            String regex = "";

            for (String s : list) {
                sb.append(regex);
                sb.append(s);
                regex = "\\";
            }

            result[index] = sb.toString();
            index++;
        }
        return result;
    }


    /**
     * Добавить родительский отдел.
     * @return
     */
    public void addParentDept() {

        Set<List<String>> tempLists = new HashSet<>();

        int step = 0;
        boolean again = false;

        do {
            for (List<String> line : this.listSet) {

                // максимальный индекс строки
                int maxIndex = line.size() - 1 - step;

                if (maxIndex >= 1) {

                    // получить родителя
                    List<String> seniorDept = line.subList(0, maxIndex);

                    // добавить в коллекцию
                    tempLists.add(seniorDept);

                    again = true;
                } else {
                    again = false;
                }
            }
            this.listSet.addAll(tempLists);
            step++;
        } while (again);
    }


    /**
     * Сортировка массива.
     * @param reverse - в обратном порядке.
     */
    public void sort(boolean reverse) {

        // 1 или -1 для прямой или обратной сортировки.
        int direction;

        if (reverse) {
            direction = -1;
        } else {
            direction = 1;
        }

        TreeSet<List<String>> treeSet = new TreeSet<>(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {

                int result = 0;

                Iterator it1 = o1.iterator();
                Iterator it2 = o2.iterator();

                while (it1.hasNext() || it2.hasNext()) {

                    if (!(it1.hasNext())) {
                        return -1;
                    }

                    if (!(it2.hasNext())) {
                        return 1;
                    }

                    String s1 = (String) it1.next();
                    String s2 = (String) it2.next();

                    result = s1.compareTo(s2) * direction;

                    // если первые элемент не оодинаковые
                    if (result != 0) {
                        return result;
                    }
                }

                return result;
            }
        });

        treeSet.addAll(this.listSet);
        this.listSet = treeSet;
    }
}

package ru.job4j.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VLADIMIR on 05.05.2017.
 */
public class ConvertList implements IConvertList {

    @Override
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();

        for (int [] arr : array) {
            for (int element : arr) {
                list.add(element);
            }
        }

        return list;
    }

    @Override
    public int[][] toArray(List<Integer> list, int rows) {

        int[][] array = new int[(list.size() / rows) + ((list.size() % rows) > 0 ? 1 : 0 )][rows];

        int j = 0;
        int i = 0;

        for (int element : list) {
            array[i][j] = element;
            j++;
            if (j >= rows) {
                j = 0;
                i++;
            }
        }
        return array;
    }
}

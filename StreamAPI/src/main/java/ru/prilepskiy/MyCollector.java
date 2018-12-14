package ru.prilepskiy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCollector {

    public static void main(String[] args) {

        // [People{index=0, name='Null'}, People{index=1, name='One'}, People{index=2, name='Two'}]
        final List<People> peoples = Arrays.asList(
            new People(0, "Null"),
            new People(1, "One"),
            new People(2, "Two")
        );

        // [Null, One, Two]
        final ArrayList<String> result = peoples.stream().collect(
            () -> new ArrayList<>(), //supplier
            (arr, a) -> arr.add(a.name), //accumulator
            (arr1, arr2) -> arr1.addAll(arr2) //combiner
        );

        System.out.println(peoples);
    }


    public static class People {
        public People(int i, String s) {
            this.index = i;
            this.name = s;
        }
        int index;
        String name;
    }

}

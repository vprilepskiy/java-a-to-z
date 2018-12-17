package ru.prilepskiy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("MacBook", "Apple", "Samsung", "Casio", "Sony", "LG", "IIyama");

        strings.forEach(s -> System.out.println(s));
        strings.forEach(System.out::println);

        final List<String> result = new ArrayList<>();
        strings.forEach(result::add);
    }

}

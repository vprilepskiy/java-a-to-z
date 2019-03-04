package ru.prilepskiy;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmptyStream {

    public static void main(String[] args) {

        Set<Object> collect = Stream.empty().collect(Collectors.toSet());
        System.out.println(collect.size());

    }

}

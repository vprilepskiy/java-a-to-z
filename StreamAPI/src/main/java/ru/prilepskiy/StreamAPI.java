package ru.prilepskiy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args)  {

        final List<String> list = Arrays.asList("MacBook", "Apple", "Samsung", "Casio", "Sony", "LG", "IIyama");
        final Stream<String> stream = list.stream();
        final Stream<String> parallelStream = list.parallelStream();

        System.out.println(" stream.count(); " + list.stream().count()); // 7

        System.out.println(" stream.limit(3); " + list.stream().limit(3).collect(Collectors.toList())); // [MacBook, Apple, Samsung]

        System.out.println(" stream.skip(3); " + list.stream().skip(3).collect(Collectors.toList())); // [Casio, Sony, LG, IIyama]

        // [Apple, Casio, IIyama, LG, MacBook, Samsung, Sony]
        System.out.println(" stream.sorted(можно передать компаратор); " + list.stream().sorted().collect(Collectors.toList()));

        // [LG, Sony, Apple, Casio, IIyama, MacBook, Samsung]
        System.out.println(" stream.sorted(компаратор по длинне); " + list.stream().sorted(Comparator.comparing(s -> s.length())).collect(Collectors.toList()));

//      // условие для поиска
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.contains("o");
//            }
//        };

        // [MacBook, Casio, Sony]
        System.out.println(" stream.filter(условие);" + list.stream().filter(s -> s.contains("o")).collect(Collectors.toList()));

        // [MacBook_new, Apple_new, Samsung_new, Casio_new, Sony_new, LG_new, IIyama_new]
        System.out.println(" stream.map(выражение);" + list.stream().map(s -> s.concat("_new")).collect(Collectors.toList()));

//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        // MacBook Apple Samsung Casio Sony LG IIyama
        System.out.print(" stream.forEach(действие); ");
        list.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();

        // [0, 0, 0, 0, 0]
        System.out.print("Stream.generate(() -> 1); ");
        System.out.println(Stream.generate(() -> 0).limit(5).collect(Collectors.toList()));

        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("Stream.iterate(начать с 0, с шагом 1)");
        System.out.println(Stream.iterate(0, x -> x + 1).limit(10).collect(Collectors.toList()));

        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("IntStream.range(0, 10); ");
        System.out.println(Arrays.toString(IntStream.range(0, 10).toArray()));

        // {0=MacBook, 1=Apple, 2=Samsung, 3=Casio, 4=Sony, 5=LG, 6=IIyama}
        Function<String, Integer> functionKey = new Function<String, Integer>() {
            int i;

            @Override
            public Integer apply(String s) {
                return i++;
            }
        };
        final Map<Integer, String> map = list.stream()
            .collect(Collectors.toMap((functionKey), (s -> s)));
        System.out.println("Collectors.toMap((functionKey), (functionVal)); " + map);

        // {2=[LG], 4=[Sony], 5=[Apple, Casio], 6=[IIyama], 7=[MacBook, Samsung]}
        Map<Integer, List<String>> map1 = list.stream()
            //.collect(Collectors.groupingBy(String::length));
            .collect(Collectors.groupingBy(s -> s.length()));
        System.out.println("Collectors.groupingBy(s -> s.length(); " + map1);

        // {false=[Apple, Samsung, LG, IIyama],
        //                                      true=[MacBook, Casio, Sony]}
        Map<Boolean, List<String>> map2 = list.stream()
            .collect(Collectors.partitioningBy(s -> s.contains("o")));
        System.out.println("Collectors.partitioningBy(s -> s.contains(\"o\"); " + map2);
    }
}

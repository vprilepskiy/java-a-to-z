package ru.prilepskiy;

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {

        String value = "11";
        String result = Optional.ofNullable(value).orElse("empty");
        System.out.println(result);

    }

}

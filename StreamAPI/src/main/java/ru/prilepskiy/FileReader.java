package ru.prilepskiy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public static void main(String[] args) {
        try (Stream<String> stringStream = Files.lines(Paths.get("pom.xml"))) {
            stringStream.filter(s -> !s.isEmpty()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

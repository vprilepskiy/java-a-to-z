package ru.prilepskiy.reference;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private final Cache<String, String> cache = new Cache<>();

    public String read(String path) {
        String result = null;
        Optional<String> cacheValue = this.cache.get(path);
        if (cacheValue.isPresent()) {
            result = cacheValue.get();
        } else {
            result = this.readFile(path);
            this.cache.put(path, result);
        }
        return result;
    }

    private String readFile(String path) {
        String result = null;
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            result = lines.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

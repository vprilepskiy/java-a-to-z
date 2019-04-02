package ru.prilepskiy.reference;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void read() throws IOException {
        final String text = "Hello World !!!";
        // создать временный файл
        final File tempFile = File.createTempFile("tempFile", ".tmp");
        // записать значение
        Files.write(Paths.get(tempFile.getAbsolutePath()), text.getBytes());

        FileReader fileReader = new FileReader();
        // чтение из файла
        assertEquals(text, fileReader.read(tempFile.getAbsolutePath()));
        // файл существует
        assertTrue(tempFile.exists());
        // файл успешно удален
        assertTrue(tempFile.delete());
        // файла не существует
        assertFalse(tempFile.exists());
        // чтение из кэша
        assertEquals(text, fileReader.read(tempFile.getAbsolutePath()));
    }
}
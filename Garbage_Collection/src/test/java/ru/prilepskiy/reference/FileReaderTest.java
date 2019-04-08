package ru.prilepskiy.reference;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileReaderTest {

    /**
     * В тесте выполняются следующие шаги:
     *  создать временный файл
     *  записать значение
     *  чтение из файла
     *  проверка что файл существует
     *  проверка что файл успешно удален
     *  проверка что файла не существует
     *  проверка что выполняется чтение из кэша
     * @throws IOException
     */
    @Test
    public void read() throws IOException {
        final String text = "Hello World !!!";
        final File tempFile = File.createTempFile("tempFile", ".tmp");
        Files.write(Paths.get(tempFile.getAbsolutePath()), text.getBytes());

        FileReader fileReader = new FileReader();
        assertEquals(text, fileReader.read(tempFile.getAbsolutePath()));
        assertTrue(tempFile.exists());
        assertTrue(tempFile.delete());
        assertFalse(tempFile.exists());
        assertEquals(text, fileReader.read(tempFile.getAbsolutePath()));
    }
}
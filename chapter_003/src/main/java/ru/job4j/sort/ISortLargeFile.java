package ru.job4j.sort;

import java.io.File;

/**
 * Created by VLADIMIR on 17.01.2017.
 */
public interface ISortLargeFile {

    /**
     * Отсортирует файл по длинне строк.
     * @param source - путь к файлу для чтения.
     * @param distance - путь к файлу для записи.
     */
    void sort(File source, File distance);

}

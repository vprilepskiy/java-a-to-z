package ru.job4j.sort;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by VLADIMIR on 17.01.2017.
 */
public class SortLargeFile {

    private FileInputStream fileInputStream;
    private BufferedInputStream bufferedInputStream;

    /**
     * Конструктор.
     *
     * @param path
     * @throws FileNotFoundException
     */
    public SortLargeFile(String path) throws FileNotFoundException {
        this.fileInputStream = new FileInputStream(path);
        this.bufferedInputStream = new BufferedInputStream(this.fileInputStream);
    }

    /**
     * Конструктор.
     */
    public SortLargeFile() {
    }

    // номер байта начала строки
    private long bytePosition;

    // прочитано до конца.
    public boolean readToEnd;

    /**
     * Метод считывает файл побайтово.
     *
     * @return - массив элементов
     * @throws IOException
     */
    public long[][] countStringLengthsAndIndexesPosition(final int sizeArray) throws IOException {

//        // кол-во строк в массиве
//        final int sizeArray = 1024 * 100;

        // массив содержит {динна строки; номер байта начало строки}
        long[][] lengthsAndIndexes = new long[sizeArray][2];

        // байт
        int oneByte = 0;
        // динна строки
        long stringLength = 0;
        // счетчик строк
        int countString = 0;

        while (true) {
            oneByte = this.bufferedInputStream.read();
            this.bytePosition++;
            stringLength++;
            if (((char) oneByte == '\n') || (oneByte == -1)) {

                lengthsAndIndexes[countString][0] = stringLength;
                lengthsAndIndexes[countString][1] = this.bytePosition - stringLength;

                stringLength = 0;
                countString++;
                // если конец файла
                if (oneByte == -1) {
                    this.readToEnd = true;
                    break;
                }
            }
            // если массив заполнится
            if (countString >= sizeArray) {
                break;
            }
        }
        return lengthsAndIndexes;
    }

    /**
     * Сортирует двумерный массив мотодом пузырька.
     *
     * @param lengthsAndIndexes - массив.
     */
    public void bubbleSort(long[][] lengthsAndIndexes) {
        final int columnForSort = 0;
        long[] left = new long[lengthsAndIndexes[0].length];
        long[] right = new long[lengthsAndIndexes[0].length];
        boolean again = true;

        while (again) {
            again = false;
            for (int i = 0; i < lengthsAndIndexes.length - 1; i++) {
                for (int j = 0; j < lengthsAndIndexes[i].length; j++) {
                    left[j] = lengthsAndIndexes[i][j];
                    right[j] = lengthsAndIndexes[i + 1][j];

                    // сравнить left и right и поменять местами
                    if (left[columnForSort] > right[columnForSort]) {
                        lengthsAndIndexes[i][j] = right[j];
                        lengthsAndIndexes[i + 1][j] = left[j];
                        // если была замена, поднять флаг
                        again = true;
                    }
                }
            }
        }
    }

    public void writeFileFromArray(long[][] lengthsAndIndexes, String pathToSaveFile) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        FileWriter fileWriter = new FileWriter(pathToSaveFile);
        for (long[] longs : lengthsAndIndexes) {
            if (((longs[0] != 0)) || (longs[1] != 0)) {
                stringBuilder.append(longs[0] + " " + longs[1]);
                stringBuilder.append('\n');
            }
        }
        fileWriter.append(stringBuilder.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}

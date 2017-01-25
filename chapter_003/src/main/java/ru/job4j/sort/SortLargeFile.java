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
     * @param path
     * @throws FileNotFoundException
     */
    public SortLargeFile(String path) throws FileNotFoundException {
        this.fileInputStream = new FileInputStream(path);
        this.bufferedInputStream = new BufferedInputStream(this.fileInputStream);
    }



//    public void sort(File source, File distance) {
//    }

    // номер байта начала строки
    private long bytePosition;

    // прочитано до конца.
    private boolean readToEnd;

    /**
     * Метод считывает файл побайтово.
     * @return - массив элементов
     * @throws IOException
     */
    public long[][] countStringLengthsAndIndexesPosition() throws IOException {

        // кол-во строк в массиве
        final int sizeArray = 1024 * 100;

        // массив содержит {номер байта начало строки; динна строки}
        long[][] array = new long[sizeArray][2];

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

                array[countString][0] = this.bytePosition - stringLength;
                array[countString][1] = stringLength;

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
        return array;
    }

//                // выполнить сортировку и запись в файл из массива и очистить его.
//                System.out.println("bubbleSort(arr, 1);");
//                bubbleSort(arr, 1);
//                System.out.println("writeFileAndCleanArray(arr, path + bytePosition);");
//                writeFileAndCleanArray(arr, path + this.bytePosition);
//                System.out.println(path + this.bytePosition);
//                stringCount = 0;


    /**
     * Сортирует двумерный массив мотодом пузырька.
     * @param array - массив.
     */
    public void bubbleSort(long[][] array) {
        final int columnNumber = 1;
        long[] left = new long[array[0].length];
        long[] right = new long[array[0].length];
        boolean again = true;

        while (again) {
            again = false;
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    left[j] = array[i][j];
                    right[j] = array[i + 1][j];

                    // сравнить left и right и поменять местами
                    if (left[columnNumber] > right[columnNumber]) {
                        array[i][j] = right[j];
                        array[i + 1][j] = left[j];
                        // если была замена, поднять флаг
                        again = true;
                    }
                }
            }
        }
    }


    public void writeFileAndCleanArray(long[][] arr, String pathFile) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        FileWriter fileWriter = new FileWriter(pathFile);
        for (long[] el : arr) {
            if (((el[0] != 0)) || (el[1] != 0)) {
                stringBuilder.append(el[0] + " " + el[1]);
                stringBuilder.append('\n');
            }
        }
        fileWriter.append(stringBuilder.toString());
        fileWriter.flush();
        fileWriter.close();
    }

//    public void readRandom(String path) throws IOException {
//        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
//        randomAccessFile.seek(14);
//        System.out.print(randomAccessFile.readLine());
//    }

//    public void read(String source) throws IOException {
//        RandomAccessFile randomAccessFile = new RandomAccessFile(source, "r");
//        int lengh = 0;
//        int indexByte = 0;
//        while (true) {
//
//            int b = randomAccessFile.read();
//            // если найдется конец строки или конец книги
//            if (((char) b == '\n') || (b == -1)) {
//            //    System.out.println(lengh + "; " + indexByte);
//                lengh = 0;
//            }
//            // если найдется конец книги
//            if (b == -1) {
//                break;
//            }
//            lengh++;
//            indexByte++;
//        }
//    }
//
//    public void methodor(String source) throws IOException {
//
//        //int[]index = new int [2];
//        ArrayList arr = new ArrayList<>();
//
//        //RandomAccessFile randomAccessFile = new RandomAccessFile(source, "r");
//        //FileInputStream fileInputStream = new FileInputStream(source);
//        FileReader file = new FileReader(new File(source));
//        BufferedReader bufferedReader = new BufferedReader(file);
//        String[] strings = new String[Short.MAX_VALUE];
//        StringBuilder stringBuilder = new StringBuilder();
//        short stringIndex = 0;
//        while (true) {
//            int b = bufferedReader.read();
//            // если найдется конец книги
//            if (b == -1) {
//                break;
//            }
//            // добавить смвол в строку
//            stringBuilder.append((char)b);
//            // если найдется конец строки
//            if (((char) b == '\n')) {
//                strings[stringIndex] = stringBuilder.toString();
//                stringBuilder.delete(0, stringBuilder.length());
//                stringIndex++;
//            }
//            //  System.out.print((char)b);
//        }
//    }


}

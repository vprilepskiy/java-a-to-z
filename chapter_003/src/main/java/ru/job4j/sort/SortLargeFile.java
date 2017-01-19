package ru.job4j.sort;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by VLADIMIR on 17.01.2017.
 */
public class SortLargeFile implements ISortLargeFile {
    @Override
    public void sort(File source, File distance) {
    }

    public void read(String source) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(source, "r");
        int lengh = 0;
        int indexByte = 0;
        while (true) {

            int b = randomAccessFile.read();
            // если найдется конец строки или конец книги
            if (((char) b == '\n') || (b == -1)) {
            //    System.out.println(lengh + "; " + indexByte);
                lengh = 0;
            }
            // если найдется конец книги
            if (b == -1) {
                break;
            }
            lengh++;
            indexByte++;
        }
    }

    public void methodor(String source) throws IOException {

        //int[]index = new int [2];
        ArrayList arr = new ArrayList<>();

        //RandomAccessFile randomAccessFile = new RandomAccessFile(source, "r");
        //FileInputStream fileInputStream = new FileInputStream(source);
        FileReader file = new FileReader(new File(source));
        BufferedReader bufferedReader = new BufferedReader(file);
        String[] strings = new String[Short.MAX_VALUE];
        StringBuilder stringBuilder = new StringBuilder();
        short stringIndex = 0;
        while (true) {
            int b = bufferedReader.read();
            // если найдется конец книги
            if (b == -1) {
                break;
            }
            // добавить смвол в строку
            stringBuilder.append((char)b);
            // если найдется конец строки
            if (((char) b == '\n')) {
                strings[stringIndex] = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                stringIndex++;
            }
            //  System.out.print((char)b);
        }
    }


}

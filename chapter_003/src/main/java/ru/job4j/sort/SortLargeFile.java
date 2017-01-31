package ru.job4j.sort;

import java.io.File;


/**
 * Created by VLADIMIR on 26.01.2017.
 */
public class SortLargeFile implements ISortLargeFile {

    @Override
    public void sort(File source, File distance) {
        long startTime = System.currentTimeMillis();

        ReadBigFile readBigFile = new ReadBigFile(source);
        Mapping mapping = new Mapping();
        int index = 0;
        int sizeArray = 65536;
        File[] filesForMerged = new File[32768];
        do {
            // получаем массив содержащий {динна строки; номер байта начало строки}
            long[][] lengthsAndIndexes = readBigFile.countStringLengthsAndIndexesPosition(sizeArray);
            // сортируем его
            mapping.bubbleSort(lengthsAndIndexes);
            // создаем уникальное имя файлу
            File newSaveFile = new File(System.getProperty("java.io.tmpdir") + "\\0tmp" + index);
            // запишем в массив
            filesForMerged[index] = newSaveFile;
            // сохраним на диск
            mapping.writeFileFromArray(lengthsAndIndexes, newSaveFile);
            index++;
        } while (!readBigFile.readToEnd);

        System.out.println((System.currentTimeMillis() - startTime) / 1000 / 60);
        System.out.println("выполним слияние индексных файлов");

        // выполним слияние файлов
        File pathIndexMap = mapping.dualUnionElementsOfArray(filesForMerged);
        //System.out.println(pathIndexMap);

        System.out.println((System.currentTimeMillis() - startTime) / 1000 / 60);
        System.out.println("Запишем по карте новый файл");

        WriteBigFile writeBigFile = new WriteBigFile(source, pathIndexMap, distance);
        System.out.println((System.currentTimeMillis() - startTime) / 1000 / 60);
    }

    public static void main(String[] args) {
        new SortLargeFile().sort(new File("C:\\Downloads\\bookRandom.txt"), new File("C:\\Downloads\\SORTbookRandom.txt"));
    }

}

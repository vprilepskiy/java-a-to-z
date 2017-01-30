package ru.job4j.sort;

import java.io.IOException;

/**
 * Created by VLADIMIR on 26.01.2017.
 */
public class MainClass {



    public static void main(String[] a){
        long startTime = System.currentTimeMillis();

        String pathRead = "C:\\Downloads\\bookRandom.txt";
        ReadBigFile readBigFile = new ReadBigFile(pathRead);
        Mapping mapping = new Mapping();
        int index = 0;
        int sizeArray = 65536;
        String[] pathFilesForMerged = new String[32768];
        do {
            // получаем массив содержащий {динна строки; номер байта начало строки}
            long[][] lengthsAndIndexes = readBigFile.countStringLengthsAndIndexesPosition(sizeArray);
            // сортируем его
            mapping.bubbleSort(lengthsAndIndexes);
            // создаем уникальное имя файлу
            String pathToSaveFile = System.getProperty("java.io.tmpdir") + "\\0tmp" + index;
            // запишем в массив
            pathFilesForMerged[index] = pathToSaveFile;
            // сохраним на диск
            mapping.writeFileFromArray(lengthsAndIndexes, pathToSaveFile);
            index++;
        } while (!readBigFile.readToEnd);

        System.out.println((System.currentTimeMillis() - startTime) / 1000 / 60);
        System.out.println("выполним слияние индексных файлов");

        // выполним слияние файлов
        String pathIndexMap = mapping.dualUnionElementsOfArray(pathFilesForMerged);
        //System.out.println(pathIndexMap);

        System.out.println((System.currentTimeMillis() - startTime) / 1000 / 60);
        System.out.println("Запишем по карте новый файл");

        WriteBigFile writeBigFile = new WriteBigFile(pathRead, pathIndexMap, pathRead + "SORT");
        System.out.println((System.currentTimeMillis() - startTime) / 1000 / 60);
    }

}

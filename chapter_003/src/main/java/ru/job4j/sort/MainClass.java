package ru.job4j.sort;

import java.io.IOException;

/**
 * Created by VLADIMIR on 26.01.2017.
 */
public class MainClass {



    public static void main(String[] a){

        String pathRead = "C:\\Downloads\\ArgoUML-0.34-setup.exe";
        ReadBigFile readBigFile = new ReadBigFile(pathRead);
        Mapping mapping = new Mapping();
        int index = 0;
        int sizeArray = 1024;
        String[] pathFilesForMerged = new String[1024 * 16];
        do {
            // получаем массив содержащий {динна строки; номер байта начало строки}
            long[][] lengthsAndIndexes = readBigFile.countStringLengthsAndIndexesPosition(sizeArray);
            // сортируем его
            mapping.bubbleSort(lengthsAndIndexes);
            // создаем уникальное имя файлу
            String pathToSaveFile = "C:\\projects\\vprilepskiy\\chapter_003\\TEMP\\0tmp" + index;
            // запишем в массив
            pathFilesForMerged[index] = pathToSaveFile;
            // сохраним на диск
            mapping.writeFileFromArray(lengthsAndIndexes, pathToSaveFile);
            index++;
        } while (!readBigFile.readToEnd);

        // выполним слияние файлов
        String pathIndexMap = mapping.dualUnionElementsOfArray(pathFilesForMerged);
        //System.out.println(pathIndexMap);

        WriteBigFile writeBigFile = new WriteBigFile(pathRead, pathIndexMap, pathRead + "SORT");
    }

}

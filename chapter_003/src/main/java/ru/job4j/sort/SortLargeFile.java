package ru.job4j.sort;

import java.io.File;


/**
 * Created by VLADIMIR on 26.01.2017.
 */
public class SortLargeFile implements ISortLargeFile {

    /**
     * Максимальное кол-во индексов в одном временном файле.
     * Чем больше число, тем больше нагрузка на процессор.
     * Чем меньше число, тем больше нагрузка на диск.
     */
    private final int maxNumOfIndexInOneFile = 8192;

    /**
     * Максимальное кол-во индексных файлов.
     */
    private final int maxNumOfIndexFiles = 65536;

    @Override
    public void sort(File source, File distance) {
        long startTime = System.currentTimeMillis();

        ReadBigFile readBigFile = new ReadBigFile(source);
        Mapping mapping = new Mapping();
        int index = 0;

        File[] filesForMerged = new File[this.maxNumOfIndexFiles];
        do {
            // получаем массив содержащий {динна строки; номер байта начало строки}
            long[][] lengthsAndIndexes = readBigFile.countStringLengthsAndIndexesPosition(this.maxNumOfIndexInOneFile);
            // сортируем его
            mapping.bubbleSort(lengthsAndIndexes);
            // создаем уникальное имя файлу
            File newSaveFile = new File(System.getProperty("java.io.tmpdir") + "\\0tmp" + index);
            // запишем в массив
            try {
                filesForMerged[index] = newSaveFile;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Требуется увеличить значение переменных maxNumOfIndexInOneFile или maxNumOfIndexFiles");
                e.printStackTrace();
                break;
            }
            // сохраним на диск
            mapping.writeFileFromArray(lengthsAndIndexes, newSaveFile);
            index++;
        } while (!readBigFile.isReadToEnd());

        // выполним слияние файлов
        File pathIndexMap = mapping.dualUnionElementsOfArray(filesForMerged);
        //System.out.println(pathIndexMap);

        WriteBigFile writeBigFile = new WriteBigFile(source, pathIndexMap, distance);
    }
}

package ru.job4j.sort;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by VLADIMIR on 26.01.2017.
 */
public class MainClass {

    private String[] fileNames = new String[Integer.MAX_VALUE];

    public void generateFileIndex() throws IOException {
        SortLargeFile sortLargeFile = new SortLargeFile("C:\\Temp\\projects\\Tracker\\mvn_clean_install.log");
        int index = 0;
        do{
            int sizeArray = 8;
            long[][] lengthsAndIndexes = sortLargeFile.countStringLengthsAndIndexesPosition(sizeArray);
            sortLargeFile.bubbleSort(lengthsAndIndexes);
            String fileName = "0_" + index;
            sortLargeFile.writeFileFromArray(lengthsAndIndexes, fileName);
            this.fileNames[index] = fileName;
            index++;
        }while (!(sortLargeFile.readToEnd));
    }

}

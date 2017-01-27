package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by VLADIMIR on 27.01.2017.
 */
public class TestReadBigFile {

    @Test
    public void testCountStringLengthsAndIndexesPosition() throws IOException {
        final int sizeArray = 10;
        ReadBigFile readBigFile = new ReadBigFile(System.getProperty("user.dir") + "\\TestFileForSort.txt");

        final long[][] firstLengthsAndIndexes = readBigFile.countStringLengthsAndIndexesPosition(sizeArray);
        final long[][] firstResult = {{28, 0}, {2, 28}, {12, 30}, {15, 42}, {27, 57}, {27, 84}, {2, 111}, {49, 113}, {42, 162}, {63, 204}};
        Assert.assertThat(firstResult, Is.is(firstLengthsAndIndexes));
        Assert.assertFalse(readBigFile.readToEnd);

//        for (int i = 0; i < firstLengthsAndIndexes.length; i++) {
//            for (int j = 0; j < firstLengthsAndIndexes[i].length; j++) {
//                System.out.print(firstLengthsAndIndexes[i][j] + "; ");
//            }
//            System.out.println();
//        }
//        System.out.println(readBigFile.readToEnd);

        final long[][] secondLengthsAndIndexes = readBigFile.countStringLengthsAndIndexesPosition(sizeArray);
        final long[][] secondResult = {{2, 267}, {46, 269}, {47, 315}, {2, 362}, {51, 364}, {29, 415}, {0, 0},{0, 0},{0, 0},{0, 0}};
        Assert.assertThat(secondResult, Is.is(secondLengthsAndIndexes));
        Assert.assertTrue(readBigFile.readToEnd);

//        for (int i = 0; i < secondLengthsAndIndexes.length; i++) {
//            for (int j = 0; j < secondLengthsAndIndexes[i].length; j++) {
//                System.out.print(secondLengthsAndIndexes[i][j] + "; ");
//            }
//            System.out.println();
//        }
//        System.out.println(readBigFile.readToEnd);
    }

}

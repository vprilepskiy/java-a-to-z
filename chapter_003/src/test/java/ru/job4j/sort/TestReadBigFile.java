package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by VLADIMIR on 27.01.2017.
 */
public class TestReadBigFile {

    @Test
    public void testCountStringLengthsAndIndexesPosition() {

        File tempFile = new File(System.getProperty("java.io.tmpdir") + "\\TestFileForSort.txt");
        final String bodyTextFile = "11g Release 2 (11.1.2.4.0) \n" +
                " \n" +
                "What's New \n" +
                "Release Notes \n" +
                "Certification Information \n" +
                "Accessibility Information \n" +
                " \n" +
                "Oracle JDeveloper and ADF Documentation Library \n" +
                "Installation Guide for Oracle JDeveloper \n" +
                "Installation Guide for Oracle Team Productivity Center Server \n" +
                " \n" +
                "Oracle ADF Skin Editor Documentation Library \n" +
                "Installation Guide for Oracle ADF Skin Editor \n" +
                " \n" +
                "Oracle JDeveloper 11g and Oracle ADF Code Samples \n" +
                "JDeveloper and ADF Tutorials";

        new ReadAndWriteFile().writeFile(tempFile, bodyTextFile);

        final int sizeArray = 10;
        ReadBigFile readBigFile = new ReadBigFile(tempFile);
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

        tempFile.delete();
    }

}

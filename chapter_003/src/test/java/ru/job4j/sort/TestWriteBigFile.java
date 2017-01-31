package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by VLADIMIR on 29.01.2017.
 */
public class TestWriteBigFile {

    @Test
    public void testOverwriteFileOnMap() {
        // текст исходного файла
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

        // текст файла с индексами
        final String bodyIndexFile = "2 28\n" +
                "2 111\n" +
                "2 267\n" +
                "2 362\n" +
                "12 30\n" +
                "15 42\n" +
                "27 57\n" +
                "27 84\n" +
                "28 0\n" +
                "29 415\n" +
                "42 162\n" +
                "46 269\n" +
                "47 315\n" +
                "49 113\n" +
                "51 364\n" +
                "63 204\n";

        // текст файла с результатом
        final String bodyResultFile = "  \n" +
                " \n" +
                " \n" +
                "What's New \n" +
                "Release Notes \n" +
                "Certification Information \n" +
                "Accessibility Information \n" +
                "11g Release 2 (11.1.2.4.0) \n" +
                "JDeveloper and ADF Tutorials\n" +
                "Installation Guide for Oracle JDeveloper \n" +
                "Oracle ADF Skin Editor Documentation Library \n" +
                "Installation Guide for Oracle ADF Skin Editor \n" +
                "Oracle JDeveloper and ADF Documentation Library \n" +
                "Oracle JDeveloper 11g and Oracle ADF Code Samples \n" +
                "Installation Guide for Oracle Team Productivity Center Server \n";

        // запишем
        File tempFile = new File(System.getProperty("java.io.tmpdir") + "\\TestFileForSort.txt");
        new ReadAndWriteFile().writeFile(tempFile, bodyTextFile);

        File tempIndexFile = new File(System.getProperty("java.io.tmpdir") + "\\Index.txt");
        new ReadAndWriteFile().writeFile(tempIndexFile, bodyIndexFile);

        File tempResultFile = new File(System.getProperty("java.io.tmpdir") + "\\IndexTestFileResult.txt");
        new WriteBigFile(tempFile, tempIndexFile, tempResultFile);

        // проверяем
        Assert.assertThat(bodyResultFile, Is.is(new ReadAndWriteFile().readFile(tempResultFile)));

        // удаляем
        tempFile.delete();
        tempIndexFile.delete();
        tempResultFile.delete();
    }


}

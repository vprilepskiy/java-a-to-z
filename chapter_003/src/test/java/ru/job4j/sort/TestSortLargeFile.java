package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by VLADIMIR on 31.01.2017.
 */
public class TestSortLargeFile {

    /**
     * Test.
     */
    @Test
    public void testSort() {
        // текст исходного файла
        StringBuilder bodyTextFile = new StringBuilder();
        bodyTextFile.append("11g Release 2 (11.1.2.4.0) \n");
        bodyTextFile.append(" \n");
        bodyTextFile.append("What's New \n");
        bodyTextFile.append("Release Notes \n");
        bodyTextFile.append("Certification Information \n");
        bodyTextFile.append("Accessibility Information \n");
        bodyTextFile.append(" \n");
        bodyTextFile.append("Oracle JDeveloper and ADF Documentation Library \n");
        bodyTextFile.append("Installation Guide for Oracle JDeveloper \n");
        bodyTextFile.append("Installation Guide for Oracle Team Productivity Center Server \n");
        bodyTextFile.append(" \n");
        bodyTextFile.append("Oracle ADF Skin Editor Documentation Library \n");
        bodyTextFile.append("Installation Guide for Oracle ADF Skin Editor \n");
        bodyTextFile.append(" \n");
        bodyTextFile.append("Oracle JDeveloper 11g and Oracle ADF Code Samples \n");
        bodyTextFile.append("JDeveloper and ADF Tutorials");

        // текст файла с результатом
        StringBuilder bodyResultFile = new StringBuilder();
        bodyResultFile.append("  \n");
        bodyResultFile.append(" \n");
        bodyResultFile.append(" \n");
        bodyResultFile.append("What's New \n");
        bodyResultFile.append("Release Notes \n");
        bodyResultFile.append("Certification Information \n");
        bodyResultFile.append("Accessibility Information \n");
        bodyResultFile.append("11g Release 2 (11.1.2.4.0) \n");
        bodyResultFile.append("JDeveloper and ADF Tutorials\n");
        bodyResultFile.append("Installation Guide for Oracle JDeveloper \n");
        bodyResultFile.append("Oracle ADF Skin Editor Documentation Library \n");
        bodyResultFile.append("Installation Guide for Oracle ADF Skin Editor \n");
        bodyResultFile.append("Oracle JDeveloper and ADF Documentation Library \n");
        bodyResultFile.append("Oracle JDeveloper 11g and Oracle ADF Code Samples \n");
        bodyResultFile.append("Installation Guide for Oracle Team Productivity Center Server \n");

        // запишем
        File tempFile = new File(System.getProperty("java.io.tmpdir") + "\\TestFileForSort.txt");
        new ReadAndWriteFile().writeFile(tempFile, bodyTextFile.toString());

        File tempResultFile = new File(System.getProperty("java.io.tmpdir") + "\\IndexTestFileResult.txt");
        new SortLargeFile().sort(tempFile, tempResultFile);

        // проверяем
        Assert.assertThat(bodyResultFile.toString(), Is.is(new ReadAndWriteFile().readFile(tempResultFile)));

        // удаляем
        tempFile.delete();
        tempResultFile.delete();

    }

}

package ru.job4j.sort;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by VLADIMIR on 17.01.2017.
 */
public class TestSortLargeFile {
    @Test
    public void test() throws IOException {
        new SortLargeFile().methodor("C:\\Downloads\\theme-91.epf");
       // new SortLargeFile().read("C:\\projects\\vprilepskiy\\chapter_001\\src\\main\\java\\ru\\job4j\\package-info.java");


    }

    @Test
    public void t() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dssdffsgsdsdfsdff");
        System.out.println(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());
        System.out.println(stringBuilder.toString());
    }

}


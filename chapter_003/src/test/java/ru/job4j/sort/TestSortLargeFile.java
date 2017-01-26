package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by VLADIMIR on 17.01.2017.
 */
public class TestSortLargeFile {


    @Test
    public void testBubbleSort() {
        long[][] arr = new long[9][2];

        arr[0][0] = 2;
        arr[0][1] = 152;
        arr[1][0] = 8;
        arr[1][1] = 358;
        arr[2][0] = 1;
        arr[2][1] = 451;
        arr[3][0] = 6;
        arr[3][1] = 656;
        arr[4][0] = 4;
        arr[4][1] = 154;
        arr[5][0] = 9;
        arr[5][1] = 159;
        arr[6][0] = 8;
        arr[6][1] = 258;

        long[][] result = new long[9][2];

        result[0][0] = 0;
        result[0][1] = 0;
        result[1][0] = 0;
        result[1][1] = 0;
        result[2][0] = 1;
        result[2][1] = 451;
        result[3][0] = 2;
        result[3][1] = 152;
        result[4][0] = 4;
        result[4][1] = 154;
        result[5][0] = 6;
        result[5][1] = 656;
        result[6][0] = 8;
        result[6][1] = 358;
        result[7][0] = 8;
        result[7][1] = 258;
        result[8][0] = 9;
        result[8][1] = 159;


        new SortLargeFile().bubbleSort(arr);

        Assert.assertThat(arr, Is.is(result));

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + "; ");
//            }
//            System.out.println();
//        }


    }

    @Test
    public void testCountStringLengthsAndIndexesPosition() throws IOException {
        SortLargeFile sortLargeFile = new SortLargeFile("C:\\projects\\vprilepskiy\\chapter_003\\pom.xml");
        long[][] arr1 = sortLargeFile.countStringLengthsAndIndexesPosition(8);

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + "; ");
            }
            System.out.println();
        }

        System.out.println(sortLargeFile.readToEnd);

        long[][] arr2 = sortLargeFile.countStringLengthsAndIndexesPosition(8);

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "; ");
            }
            System.out.println();
        }

        System.out.println(sortLargeFile.readToEnd);
    }
}
























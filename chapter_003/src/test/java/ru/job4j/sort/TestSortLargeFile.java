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

        new Mapping().bubbleSort(arr);

        Assert.assertThat(arr, Is.is(result));

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + "; ");
//            }
//            System.out.println();
//        }
    }





    public static void main(String[] a){
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir") + "\\TestFileForSort.txt");
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println(System.getProperty("file.separator"));
    }
}
























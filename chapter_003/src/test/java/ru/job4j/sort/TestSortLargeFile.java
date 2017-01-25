package ru.job4j.sort;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by VLADIMIR on 17.01.2017.
 */
public class TestSortLargeFile {

    @Test
    public void sdf(){
        int[][] arr = new int[10][2];

        arr[0][0] = 2; arr[0][1] = 52;
        arr[1][0] = 8; arr[1][1] = 58;
        arr[2][0] = 1; arr[2][1] = 51;
        arr[3][0] = 6; arr[3][1] = 56;
        arr[4][0] = 4; arr[4][1] = 54;
        arr[5][0] = 9; arr[5][1] = 59;
        arr[6][0] = 8; arr[6][1] = 68;

        int[][] result = new int[10][2];

        arr[0][0] = 1; arr[0][1] = 52;
        arr[1][0] = 1; arr[1][1] = 52;
        arr[2][0] = 1; arr[2][1] = 52;
        arr[3][0] = 1; arr[3][1] = 52;
        arr[4][0] = 1; arr[4][1] = 52;
        arr[5][0] = 8; arr[5][1] = 58;
        arr[6][0] = 1; arr[6][1] = 51;
        arr[7][0] = 6; arr[7][1] = 56;
        arr[8][0] = 4; arr[8][1] = 54;
        arr[9][0] = 9; arr[9][1] = 59;


        //new SortLargeFile().bubbleSort(arr, 0);



        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "; ");
            }
            System.out.println();
        }
    }

}


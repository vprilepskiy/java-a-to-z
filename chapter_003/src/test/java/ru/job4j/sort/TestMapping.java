package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * Created by VLADIMIR on 17.01.2017.
 */
public class TestMapping {


    @Test
    public void testBubbleSort() {
        final long[][] array = {{2, 152}, {8, 358}, {1, 451}, {6, 656}, {4, 154}, {9, 159}, {8, 258}, {0, 0}, {0, 0}};
        final long[][] result = {{0, 0}, {0, 0}, {1, 451}, {2, 152}, {4, 154}, {6, 656}, {8, 358}, {8, 258}, {9, 159}};

        new Mapping().bubbleSort(array);
        Assert.assertThat(array, Is.is(result));

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j] + "; ");
//            }
//            System.out.println();
//        }
    }

    @Test
    public void testWriteFileFromArray() {
        final long[][] array = {{1, 451}, {2, 152}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        final String result = "1 451\n2 152\n";

        final String pathToSaveFile = System.getProperty("java.io.tmpdir") + "\\tempTestFile.tmp";
        new Mapping().writeFileFromArray(array, pathToSaveFile);
        FileReader fileReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        Assert.assertThat(this.readFile(pathToSaveFile), Is.is(result));
        new File(pathToSaveFile).delete();
    }

    @Test
    public void testMergeFiles() {
        final String pathToSaveFirstPrepareTestFile = System.getProperty("java.io.tmpdir") + "\\tempFirstTestFile.tmp";
        final String pathToSaveSecondPrepareTestFile = System.getProperty("java.io.tmpdir") + "\\tempSecondTestFile.tmp";

        final String bodyFirstPrepareTestFile = "1 2653\n28 2466\n31 2541\n47 2494\n81 2572";
        final String bodySecondPrepareTestFile = "9 305\n29 195\n33 0\n44 385\n71 314\n81 33\n81 114\n81 224";

        final String bodyResultFile = "1 2653\n9 305\n28 2466\n29 195\n31 2541\n33 0\n44 385\n47 2494\n71 314\n81 33\n81 2572\n81 114\n81 224\n";

        this.writeFile(pathToSaveFirstPrepareTestFile, bodySecondPrepareTestFile);
        this.writeFile(pathToSaveSecondPrepareTestFile, bodyFirstPrepareTestFile);

        // выполним слияние
        final String pathResultFile = System.getProperty("java.io.tmpdir") + "\\tempResultTestFile.tmp";
        new Mapping().mergeFiles(pathToSaveFirstPrepareTestFile, pathToSaveSecondPrepareTestFile, pathResultFile);

        // проверим результат
        Assert.assertThat(this.readFile(pathResultFile), Is.is(bodyResultFile));

        // удалим файлы
        new File(pathToSaveFirstPrepareTestFile).delete();
        new File(pathToSaveSecondPrepareTestFile).delete();
        new File(pathResultFile).delete();
    }


    @Test
    public void testDualUnionElementsOfArray(){
        // массив путей к файлам для слияния
        String[] pathFilesForMerged = new String[5];
        pathFilesForMerged[0] = System.getProperty("java.io.tmpdir") + "\\0tmp0.tmp";
        pathFilesForMerged[1] = System.getProperty("java.io.tmpdir") + "\\0tmp1.tmp";
        pathFilesForMerged[2] = System.getProperty("java.io.tmpdir") + "\\0tmp2.tmp";
        pathFilesForMerged[3] = System.getProperty("java.io.tmpdir") + "\\0tmp3.tmp";
        pathFilesForMerged[4] = System.getProperty("java.io.tmpdir") + "\\0tmp4.tmp";

        // массив путей к файлам для слияния чтобы удалить временные файлы
        String delTempPathFilesForMerged[] = pathFilesForMerged.clone();

        // записать файлы
        this.writeFile(pathFilesForMerged[0], "9 429\n9 663\n51 750\n59 521\n71 801\n78 672\n83 438\n83 580");
        this.writeFile(pathFilesForMerged[1], "9 872\n9 1114\n51 1209\n59 972\n75 1260\n83 1031\n86 1123\n91 881");
        this.writeFile(pathFilesForMerged[2], "2 1498\n9 1335\n12 1557\n35 1626\n57 1500\n57 1569\n75 1344\n79 1419");
        this.writeFile(pathFilesForMerged[3], "2 1735\n2 1748\n2 1800\n9 1802\n11 1737\n50 1750\n65 1811\n74 1661");
        this.writeFile(pathFilesForMerged[4], "1 2653\n28 2466\n31 2541\n47 2494\n81 2572");

        // выполнить слияние
        String pathResultFile = new Mapping().dualUnionElementsOfArray(pathFilesForMerged);

        // проверяем
        String result = "1 2653\n2 1498\n2 1735\n2 1748\n2 1800\n9 429\n9 1335\n9 872\n9 1802\n9 663\n9 1114\n11 1737\n12 1557\n28 2466\n31 2541\n35 1626\n47 2494\n50 1750\n51 750\n51 1209\n57 1500\n57 1569\n59 521\n59 972\n65 1811\n71 801\n74 1661\n75 1260\n75 1344\n78 672\n79 1419\n81 2572\n83 438\n83 1031\n83 580\n86 1123\n91 881\n";
        Assert.assertThat(result, Is.is(readFile(pathResultFile)));

        // удаляем
        new File(delTempPathFilesForMerged[0]).delete();
        new File(delTempPathFilesForMerged[1]).delete();
        new File(delTempPathFilesForMerged[2]).delete();
        new File(delTempPathFilesForMerged[3]).delete();
        new File(delTempPathFilesForMerged[4]).delete();
       // new File(pathResultFile).delete();
        // поправить оствется много лишних файлов!!!!!!!!!!!

    }


    public static void main(String[] a) {
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir") + "\\TestFileForSort.txt");
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println(System.getProperty("file.separator"));
    }


    /**
     * Прочитает файл.
     * @param pathFile - путь к файлу.
     * @return - прочитанная строка.
     */
    private String readFile(String pathFile){
        FileReader fileReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new FileReader(pathFile);
            int oneByte;
            while ((oneByte = fileReader.read()) != -1) {
                stringBuilder.append((char) oneByte);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                /*NONE*/
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Запишет строку в файл.
     * @param pathFile - путь к файлу.
     * @param body - строка.
     */
    private void writeFile(String pathFile, String body) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pathFile);
            fileWriter.write(body);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                /*NONE*/
            }
        }
    }
}
























package ru.job4j.sort;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * Created by VLADIMIR on 17.01.2017.
 */
public class Mapping {


    /**
     * Сортирует двумерный массив методом пузырька. TEST OK.
     *
     * @param lengthsAndIndexes - массив.
     */
    public void bubbleSort(long[][] lengthsAndIndexes) {
        final int columnForSort = 0;
        long[] left = new long[lengthsAndIndexes[0].length];
        long[] right = new long[lengthsAndIndexes[0].length];
        boolean again = true;

        while (again) {
            again = false;
            for (int i = 0; i < lengthsAndIndexes.length - 1; i++) {
                for (int j = 0; j < lengthsAndIndexes[i].length; j++) {
                    left[j] = lengthsAndIndexes[i][j];
                    right[j] = lengthsAndIndexes[i + 1][j];

                    // сравнить left и right и поменять местами
                    if (left[columnForSort] > right[columnForSort]) {
                        lengthsAndIndexes[i][j] = right[j];
                        lengthsAndIndexes[i + 1][j] = left[j];
                        // если была замена, поднять флаг
                        again = true;
                    }
                }
            }
        }
    }



     /**
     * Производит запись данных из массива в файл. TEST OK.
     * @param lengthsAndIndexes - массив для записи в файл.
     * @param saveFile - файл.
     */
    public void writeFileFromArray(long[][] lengthsAndIndexes, File saveFile) {
        StringBuilder stringBuilder = new StringBuilder();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(saveFile);
            for (long[] longs : lengthsAndIndexes) {
                // не писать если {0, 0}.
                if (((longs[0] != 0)) || (longs[1] != 0)) {
                    stringBuilder.append(longs[0] + " " + longs[1]);
                    stringBuilder.append('\n');
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.append(stringBuilder.toString());
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * Перебирает попарно элементы массива (файлы). TEST OK.
     * Передает в метод три переменные (2 файла для слияния) + (1 файл с результатом).
     * Выполняется пока не останется один файл.
     * @param filesForMerged - массив файлов для слияния.
     * @return - файл после слияния.
     */
    public File dualUnionElementsOfArray(File[] filesForMerged) {

        boolean again = true;
        File firstFile = null;
        File secondFile = null;
        int countLoop = 1;

        while (again) {
            again = false;
            for (int index = 0; index < filesForMerged.length; index++) {
                // получаем первую переменную и в массив передаем null
                if (firstFile == null) {
                    if (filesForMerged[index] != null) {
                        firstFile = filesForMerged[index];
                        filesForMerged[index] = null;
                    }
                    // получаем вторую переменную и в массив передаем null
                } else {
                    if (filesForMerged[index] != null) {
                        secondFile = filesForMerged[index];
                        filesForMerged[index] = null;
                    }
                }
                // если обе переменные заполнены
                if ((firstFile != null) && (secondFile != null)) {
                    // передаем в массив новое значение
                    String newFileName = System.getProperty("java.io.tmpdir") + "\\" + countLoop + "tmp" + secondFile.getName().split("tmp")[1];
                    File newFile = new File(newFileName);
                    // вызываем метод mergeFiles();
                    this.mergeFiles(firstFile, secondFile, newFile);
                    filesForMerged[index] = newFile;
                    // удаляем ненужные файлы
                    firstFile.delete();
                    secondFile.delete();
                    firstFile = null;
                    secondFile = null;
                    again = true;
                }
                // если дошли до конца а пары не найдено, то записать в последнюю
                if ((index == filesForMerged.length - 1) && (firstFile != null) && (secondFile == null)) {
                    filesForMerged[index] = firstFile;
                    firstFile = null;
                }
            }
//            for (String s : filesForMerged) {
//                System.out.println(s);
//            }
//            System.out.println("********************" + countLoop);
            countLoop++;
        }
        // возвращаем последний элемент массива
        return filesForMerged[filesForMerged.length - 1];
    }



    /**
     * Выполняет слияние двух отсортированных файлов в один. TEST OK.
     *
     * @param firstFile  - первый файл с индексами.
     * @param secondFile - второй файл с индексами.
     * @param resultFile - готовый файл.
     */
    public void mergeFiles(File firstFile, File secondFile, File resultFile) {
        FileReader firstReader = null;
        FileReader secondReader = null;
        BufferedReader firstBufferedReader = null;
        BufferedReader secondBufferedReader = null;
        FileWriter fileWriter = null;

        try {
            firstReader = new FileReader(firstFile);
            secondReader = new FileReader(secondFile);
            firstBufferedReader = new BufferedReader(firstReader);
            secondBufferedReader = new BufferedReader(secondReader);
            fileWriter = new FileWriter(resultFile);

            boolean again = true;
            boolean readNextA = true;
            boolean readNextB = true;
            String stringA = null;
            String stringB = null;

            while (again) {
                if (readNextA) {
                    stringA = firstBufferedReader.readLine();
                    readNextA = false;
                }
                if (readNextB) {
                    stringB = secondBufferedReader.readLine();
                    readNextB = false;
                }

                // если считались обе строки
                if ((stringA != null) && (stringB != null)) {
                    // если А меньше Б
                    if ((Long.parseLong(stringA.split(" ")[0])) < (Long.parseLong(stringB.split(" ")[0]))) {
                        // добавить А
                        fileWriter.append(stringA);
                        fileWriter.append('\n');
                        readNextA = true;
                        // если Б меньше А
                    } else if ((Long.parseLong(stringB.split(" ")[0])) < (Long.parseLong(stringA.split(" ")[0]))) {
                        // добавить Б
                        fileWriter.append(stringB);
                        fileWriter.append('\n');
                        readNextB = true;
                        // если А равно Б
                    } else {
                        // добавить А и Б
                        fileWriter.append(stringA);
                        fileWriter.append('\n');
                        readNextA = true;
                        fileWriter.append(stringB);
                        fileWriter.append('\n');
                        readNextB = true;
                    }
                    // если считалась только стокаА
                } else if ((stringA != null) && (stringB == null)) {
                    // добавить А
                    fileWriter.append(stringA);
                    fileWriter.append('\n');
                    readNextA = true;
                    // если считалась только стокаБ
                } else if ((stringA == null) && (stringB != null)) {
                    // добавить Б
                    fileWriter.append(stringB);
                    fileWriter.append('\n');
                    readNextB = true;
                } else {
                    again = false;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                firstReader.close();
                secondReader.close();
                firstBufferedReader.close();
                secondBufferedReader.close();
            } catch (IOException e) {
                /*NONE*/
            }
        }
    }

}

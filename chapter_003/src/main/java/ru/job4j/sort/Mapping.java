package ru.job4j.sort;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by VLADIMIR on 17.01.2017.
 */
public class Mapping {

//    public String[] fileNames = new String[1024];
//
//    /**
//     * Метод создает временные файлы содержащие информацию о длинне строки и индексах.
//     *
//     * @throws IOException
//     */
//    public void generateFilesIndex() throws IOException {
//        int index = 0;
//        do {
//            int sizeArray = 8;
//            long[][] lengthsAndIndexes = this.countStringLengthsAndIndexesPosition(sizeArray);
//            this.bubbleSort(lengthsAndIndexes);
//            String pathToSaveFile = "C:\\Temp\\0tmp" + index;
//            this.writeFileFromArray(lengthsAndIndexes, pathToSaveFile);
//            this.fileNames[index] = pathToSaveFile;
//            index++;
//        } while (!(this.readToEnd));
//    }


    /**
     * Сортирует двумерный массив мотодом пузырька. TEST OK.
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
     * @param pathToSaveFile -
     */
    public void writeFileFromArray(long[][] lengthsAndIndexes, String pathToSaveFile) {
        StringBuilder stringBuilder = new StringBuilder();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pathToSaveFile);

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
                /*NONE*/
            }
        }
    }



    /**
     * Перебирает попарно элементы массива (пути к файлам). TEST OK.
     * Передает в метод три переменные (2 пути к файлам для слияния) + (1 путь к файлу с результатом).
     * Выполняется пока не останется один файл.
     * @param pathFilesForMerged - массив путей к файлам для слияния.
     * @return - путь к файлу после слияния.
     */
    public String dualUnionElementsOfArray(String[] pathFilesForMerged) {

        boolean again = true;
        String pathFirstFile = null;
        String pathSecondFile = null;
        int countLoop = 1;

        while (again) {
            again = false;
            for (int index = 0; index < pathFilesForMerged.length; index++) {
                // получаем первую переменную и в массив передаем null
                if (pathFirstFile == null) {
                    if (pathFilesForMerged[index] != null) {
                        pathFirstFile = pathFilesForMerged[index];
                        pathFilesForMerged[index] = null;
                    }
                    // получаем вторую переменную и в массив передаем null
                } else {
                    if (pathFilesForMerged[index] != null) {
                        pathSecondFile = pathFilesForMerged[index];
                        pathFilesForMerged[index] = null;
                    }
                }
                // если обе переменные заполнены
                if ((pathFirstFile != null) && (pathSecondFile != null)) {
                    // передаем в массив новое значение
                    // вызываем метод mergeFiles();
                    String newFileName = System.getProperty("java.io.tmpdir") + "\\" + countLoop + "tmp" + pathSecondFile.split("tmp")[1];
                    this.mergeFiles(pathFirstFile, pathSecondFile, newFileName);
                    pathFilesForMerged[index] = newFileName;
                    pathFirstFile = null;
                    pathSecondFile = null;
                    again = true;
                }
                // если дошли до конца а пары не найдено, то записать в последнюю
                if ((index == pathFilesForMerged.length - 1) && (pathFirstFile != null) && (pathSecondFile == null)) {
                    pathFilesForMerged[index] = pathFirstFile;
                    pathFirstFile = null;
                }
            }
//            for (String s : pathFilesForMerged) {
//                System.out.println(s);
//            }
//            System.out.println("********************" + countLoop);
            countLoop++;
        }
        return pathFilesForMerged[pathFilesForMerged.length - 1];
    }



    /**
     * Выполняет слияние двух отсортированных файлов в один. TEST OK.
     *
     * @param pathFirstFile  - путь к первому файлу с индексами.
     * @param pathSecondFile - путь ко второму файлу с индексами.
     * @param pathResultFile - путь к готовому файлу.
     */
    public void mergeFiles(String pathFirstFile, String pathSecondFile, String pathResultFile) {
        FileReader firstReader = null;
        FileReader secondReader = null;
        BufferedReader firstBufferedReader = null;
        BufferedReader secondBufferedReader = null;
        FileWriter fileWriter = null;

        try {
            firstReader = new FileReader(pathFirstFile);
            firstBufferedReader = new BufferedReader(firstReader);
            secondReader = new FileReader(pathSecondFile);
            secondBufferedReader = new BufferedReader(secondReader);
            fileWriter = new FileWriter(pathResultFile);

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

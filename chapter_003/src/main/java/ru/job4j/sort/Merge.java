package ru.job4j.sort;

import java.io.*;

/**
 * Created by vladimir on 26.01.2017.
 */
public class Merge {

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

            while (again) {
                String stringA = firstBufferedReader.readLine();
                String stringB = secondBufferedReader.readLine();
                // если считались обе строки
                if ((stringA != null) && (stringB != null)) {
                    // если А меньше Б
                    if ((Long.parseLong(stringA.split(" ")[0])) < (Long.parseLong(stringB.split(" ")[0]))) {
                        // добавить А
                        fileWriter.append(stringA);
                        fileWriter.append('\n');
                        // если Б меньше А
                    } else if ((Long.parseLong(stringB.split(" ")[0])) < (Long.parseLong(stringA.split(" ")[0]))) {
                        // добавить Б
                        fileWriter.append(stringB);
                        fileWriter.append('\n');
                        // если А равно Б
                    } else {
                        // добавить А и Б
                        fileWriter.append(stringA);
                        fileWriter.append('\n');
                        fileWriter.append(stringB);
                        fileWriter.append('\n');
                    }
                    // если считалась только стокаА
                } else if ((stringA != null) && (stringB == null)) {
                    // добавить А
                    fileWriter.append(stringA);
                    fileWriter.append('\n');
                    // если считалась только стокаБ
                } else if ((stringA == null) && (stringB != null)) {
                    // добавить Б
                    fileWriter.append(stringB);
                    fileWriter.append('\n');
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

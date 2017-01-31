package ru.job4j.sort;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.RandomAccessFile;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


/**
 * Created by VLADIMIR on 29.01.2017.
 * TEST OK.
 */
public class WriteBigFile {

    /**
     * FileReader.
     */
    private FileReader fileReader;
    /**
     * BufferedReader.
     */
    private BufferedReader bufferedReader;
    /**
     * RandomAccessFile.
     */
    private RandomAccessFile randomAccessFile;
    /**
     * FileWriter.
     */
    private FileWriter fileWriter;

    /**
     * Конструктор.
     *
     * @param source     - файл не отсортированный.
     * @param indexMap - файл с индексами начала строк
     * @param distance    - путь куда записать отсортированный файл.
     */
    public WriteBigFile(File source, File indexMap, File distance) {
        try {
            this.fileReader = new FileReader(indexMap);
            this.bufferedReader = new BufferedReader(this.fileReader);
            this.randomAccessFile = new RandomAccessFile(source, "r");
            this.fileWriter = new FileWriter(distance);
            this.overwriteFileOnMap();
            indexMap.delete();
        } catch (IOException e) {
            e.printStackTrace();
            this.closeResources();
        }
    }


    /**
     * Выполняет чтение индексов начала строки, чтение исходного файла и запись нового файла.
     */
    public void overwriteFileOnMap() {
        try {
            String lineIndex = null;
            String newLine = "";
            while ((lineIndex = this.bufferedReader.readLine()) != null) {
                // получить позицию
                long indexByteBeginningLine = Long.valueOf(lineIndex.split(" ")[1]);
                // установить позицию
                this.randomAccessFile.seek(indexByteBeginningLine);
                // считать строку и записать в новый файл
                String line = randomAccessFile.readLine();
                if (line != null) {
                    this.fileWriter.write(line);
                }
                this.fileWriter.write(newLine);
                newLine = "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.closeResources();
        }
    }


    /**
     * Закрывает ресурсы.
     */
    public void closeResources() {
        if (this.fileReader != null) {
            try {
                this.fileReader.close();
            } catch (IOException e) {
                /*NONE*/
            }
        }
        if (this.bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                /*NONE*/
            }
        }
        if (this.randomAccessFile != null) {
            try {
                this.randomAccessFile.close();
            } catch (IOException e) {
                /*NONE*/
            }
        }
        if (this.fileWriter != null) {
            try {
                this.fileWriter.flush();
                this.fileWriter.close();
            } catch (IOException e) {
                /*NONE*/
            }
        }
    }

}

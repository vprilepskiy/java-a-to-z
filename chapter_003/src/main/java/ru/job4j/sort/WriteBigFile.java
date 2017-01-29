package ru.job4j.sort;

import java.io.*;

/**
 * Created by VLADIMIR on 29.01.2017.
 */
public class WriteBigFile {

    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private RandomAccessFile randomAccessFile;
    private FileWriter fileWriter;

    /**
     * Конструктор.
     *
     * @param pathRead     - файл не отсортированный.
     * @param pathIndexMap - файл с индексами начала строк
     * @param pathWrite    - путь куда записать отсортированный файл.
     */
    public WriteBigFile(String pathRead, String pathIndexMap, String pathWrite) {
        try {
            this.fileReader = new FileReader(pathIndexMap);
            this.randomAccessFile = new RandomAccessFile(pathRead, "r");
            this.fileWriter = new FileWriter(pathWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void overwriteFileOnMap () {
        this.fileReader.
    }


    public void closeResources() {
        if (this.fileReader != null)  {
            try {
                this.fileReader.close();
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

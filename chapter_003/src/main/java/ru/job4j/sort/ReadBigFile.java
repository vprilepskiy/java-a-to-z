package ru.job4j.sort;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by VLADIMIR on 27.01.2017.
 * TEST OK.
 */
public class ReadBigFile {
    /**
     * FileInputStream.
     */
    private FileReader fileReader;
    /**
     * BufferedInputStream.
     */
    private BufferedReader bufferedReader;

    /**
     * Конструктор.
     *
     * @param source - файл для чтения.
     */
    public ReadBigFile(File source) {
        try {
            this.fileReader = new FileReader(source);
            this.bufferedReader = new BufferedReader(this.fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.closeResources();
        }
    }

    /**
     * номер байта начала строки.
     */
    private long bytePosition;

    /**
     * прочитано до конца.
     */
    private boolean readToEnd;

    /**
     * прочитано до конца.
     * @return - true если файл прочитан до конца.
     */
    public boolean isReadToEnd() {
        return readToEnd;
    }

    /**
     * Метод частично считывает файл. Выполнять пока не прочитает весь файл, о чем символизирует переменная boolean readToEnd. TEST OK.
     *
     * @param sizeArray - кол-во строк которое следует считать из файла.
     * @return - массив содержащий {динна строки; номер байта начало строки}
     */
    public long[][] countStringLengthsAndIndexesPosition(final int sizeArray) {

        // массив содержит {динна строки; номер байта начало строки}
        long[][] lengthsAndIndexes = new long[sizeArray][2];

        // байт
        String line = null;
        // динна строки
        long stringLength = 0;
        // счетчик строк
        int countString = 0;

        // читаем файл
        try {
            while ((line = this.bufferedReader.readLine()) != null) {
                // считаем позицию
                this.bytePosition = this.bytePosition + line.getBytes().length + 1;
                // считаем длинну строки
                stringLength = line.getBytes().length + 1;
                // запишем в массив
                lengthsAndIndexes[countString][0] = stringLength;
                lengthsAndIndexes[countString][1] = this.bytePosition - stringLength;
                // номер читаемой строки
                countString++;
                // если массив заполнится
                if (countString >= sizeArray) {
                    break;
                }
            }
            // если конец файла
            if (line == null) {
                this.readToEnd = true;
                this.closeResources();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lengthsAndIndexes;
    }

    /**
     * Закрывает ресурсы.
     */
    private void closeResources() {
        if (this.fileReader != null) {
            try {
                this.fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.bufferedReader != null) {
            try {
                this.bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

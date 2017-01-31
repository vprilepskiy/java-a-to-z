package ru.job4j.sort;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;

/**
 * Created by VLADIMIR on 27.01.2017.
 * TEST OK.
 */
public class ReadBigFile {
    /**
     * FileInputStream.
     */
    private FileInputStream fileInputStream;
    /**
     * BufferedInputStream.
     */
    private BufferedInputStream bufferedInputStream;

    /**
     * Конструктор.
     *
     * @param source - файл для чтения.
     */
    public ReadBigFile(File source) {
        try {
            this.fileInputStream = new FileInputStream(source);
            this.bufferedInputStream = new BufferedInputStream(this.fileInputStream);
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
    public boolean readToEnd;

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
        int oneByte = 0;
        // динна строки
        long stringLength = 0;
        // счетчик строк
        int countString = 0;

        while (true) {
            try {
                oneByte = this.bufferedInputStream.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.bytePosition++;
            stringLength++;
            if (((char) oneByte == '\n') || (oneByte == -1)) {

                lengthsAndIndexes[countString][0] = stringLength;
                lengthsAndIndexes[countString][1] = this.bytePosition - stringLength;

                stringLength = 0;
                countString++;
                // если конец файла
                if (oneByte == -1) {
                    this.readToEnd = true;
                    this.closeResources();
                    break;
                }
            }
            // если массив заполнится
            if (countString >= sizeArray) {
                break;
            }
        }
        return lengthsAndIndexes;
    }

    /**
     * Закрывает ресурсы.
     */
    private void closeResources() {
        if (this.fileInputStream != null) {
            try {
                this.fileInputStream.close();
            } catch (IOException e) {
                    /*NONE*/
            }
        }
        if (this.bufferedInputStream != null) {
            try {
                this.bufferedInputStream.close();
            } catch (IOException e) {
                    /*NONE*/
            }
        }
    }
}

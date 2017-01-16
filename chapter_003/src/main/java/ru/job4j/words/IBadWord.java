package ru.job4j.words;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by VLADIMIR on 16.01.2017.
 */
public interface IBadWord {

    /**
     * Уберет из потока лишние слова.
     * @param in - входной поток.
     * @param out - выходной поток.
     * @param abuse - плохие слова.
     * @throws IOException - ош.
     */
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException;

}

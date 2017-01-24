package ru.job4j.chat;

import java.io.IOException;

/**
 * Created by VLADIMIR on 24.01.2017.
 */
public class FileNullSizeException extends IOException {
    public FileNullSizeException(String message){
        super(message);
    }
}

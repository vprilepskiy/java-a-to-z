package ru.job4j.manager.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;

/**
 * Created by VLADIMIR on 13.02.2017.
 */
public interface Actions {

    DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;

    File homeDirectory = null;
    File currentDirectory = null;

//    public Actions(Socket socket, File homeDirectory);

    /**
     * Выйти.
     */
    public void exit();

    /**
     * Отправляет в поток информацию о содержании такущего каталога.
     */
    public void show();

    /**
     * Переход в каталог выше.
     * @param select - Имя папки в которую следует перейти.
     */
    public void goToDirectory(String select);

    /**
     * Переход в домашний каталог.
     */
    public void toHomeDir();

    /**
     * Отправит в поток запрашивемый файл.
     * @param fileName - имя файла.
     */
    public void download(String fileName);

    /**
     * Получит из потока отправляемый файл.
     * @param fileName - имя файла.
     */
    public void upload(String fileName);
}

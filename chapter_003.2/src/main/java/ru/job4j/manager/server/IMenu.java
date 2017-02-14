package ru.job4j.manager.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;


/**
 * Created by VLADIMIR on 13.02.2017.
 */
public interface IMenu {

    /**
     * Команда для выхода из цикла.
     */
    public final String selExit = "EXIT";
    /**
     * Команда отображения содержимого текущего каталога.
     */
    public final String selShow = "SHOW";
    /**
     * Команда для перехода в следующую директорию.
     */
    public final String selGoToDirectory = "/";
    /**
     * Команда для перехода в домашнюю директорию.
     */
    public final String selHomeDir = "HOME";
    /**
     * Команда для скачивания файла с сервера.
     */
    public final String selDownload = "DOWNLOAD";
    /**
     * Команда для загрузки файла на сервер.
     */
    public final String selUpload = "UPLOAD";
    /**
     * Неизвестная команда.
     */
    public final String errSel = "unknown command";

    public DataInputStream dataInputStream = null;
    public DataOutputStream dataOutputStream = null;




//    /**
//     * Конструктор.
//     */
//    public IMenu(Socket socket) throws IOException {
//
//        this.dataInputStream = new DataInputStream(socket.getInputStream());
//        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());


    /**
     * Вызывает действие в зваисимости от выбранного пункта меню.
     * @param IActions
     */
    public void menuNavigator(IActions IActions);

}

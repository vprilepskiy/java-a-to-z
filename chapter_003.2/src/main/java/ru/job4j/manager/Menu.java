package ru.job4j.manager;

import ru.job4j.manager.IActions;
import ru.job4j.manager.IMenu;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class Menu implements IMenu {

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
     * Пример: "/NEXT DIR"
     */
    public final String selGoToDirectory = "/";
    /**
     * Команда для перехода в домашнюю директорию.
     */
    public final String selHomeDir = "HOME";
    /**
     * Команда для скачивания файла с сервера.
     * Пример: "/DOWNLOAD Example.txt"
     */
    public final String selDownload = "DOWNLOAD";
    /**
     * Команда для загрузки файла на сервер.
     * Пример: "/UPLOAD Example.txt"
     */
    public final String selUpload = "UPLOAD";
    /**
     * Меню для сервера.
     */
    private final boolean usingForServer;

    /**
     * Входной поток.
     */
    public DataInputStream dataInputStream;
    /**
     * Входной поток.
     */
    public Scanner console;

    /**
     * Конструктор для сервера.
     */
    public Menu(Socket socket) throws IOException {
        this.usingForServer = true;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
    }

    /**
     * Конструктор для клиента.
     */
    public Menu() throws IOException {
        this.usingForServer = false;
        this.console = new Scanner(System.in);
    }

    @Override
    public void menuNavigator(IActions actions) {
        boolean again = true;
        String select = null;

        try {
            while (again) {

                if (this.usingForServer == true) {
                    // читаем что послал клиент
                    select = this.dataInputStream.readUTF();
                } else {
                    // читаем что печатает клиент
                    select = this.console.nextLine();
                }

                if (select != null) {

                    if (this.selExit.equals(select)) {
                        // выход.
                        again = false;
                        if (this.usingForServer == true) {
                            actions.exit();
                        } else {
                            actions.sendMessage(select);
                            actions.exit();
                        }

                    } else if (selShow.equals(select)) {
                        if (this.usingForServer == true) {
                            // показать все содержимое.
                            actions.show();
                        } else {
                            actions.sendMessage(select);
                            // читать сообщение
                            actions.readMessage();
                        }

                    } else if (select.startsWith(selGoToDirectory)) {
                        if (this.usingForServer == true) {
                            // перейти в каталог выше
                            actions.goToDirectory(select);
                        } else {
                            actions.sendMessage(select);
                            // читать сообщение
                            actions.readMessage();
                        }

                    } else if (selHomeDir.equals(select)) {
                        if (this.usingForServer == true) {
                            // перейти в домашний каталог.
                            actions.toHomeDir();
                        } else {
                            actions.sendMessage(select);
                            // читать сообщение
                            actions.readMessage();
                        }

                    } else if (select.startsWith(selDownload)) {
                        String fileName = select.substring(selDownload.length() + 1, select.length());
                        if (this.usingForServer == true) {
                            // отправить файл
                            actions.upload(fileName);
                        } else {
                            actions.sendMessage(select);
                            // принять файл
                            actions.download(fileName);
                        }

                    } else if (select.startsWith(selUpload)) {
                        String fileName = select.substring(selDownload.length() + 1, select.length());
                        if (this.usingForServer == true) {
                            // принять файл
                            actions.download(fileName);
                        } else {
                            actions.sendMessage(select);
                            // отправить файл
                            actions.upload(fileName);
                        }
                    } else {
                        actions.unknownCommand();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

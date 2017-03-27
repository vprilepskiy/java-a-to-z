package ru.job4j.manager;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class Menu implements IMenu {

    /**
     * Команда для выхода из цикла.
     */
    private final String selExit = "EXIT";
    /**
     * Команда отображения содержимого текущего каталога.
     */
    private final String selShow = "SHOW";
    /**
     * Команда для перехода в следующую директорию.
     * Пример: "/NEXT DIR"
     */
    private final String selGoToDirectory = "/";
    /**
     * Команда для перехода в домашнюю директорию.
     */
    private final String selHomeDir = "HOME";
    /**
     * Команда для скачивания файла с сервера.
     * Пример: "/DOWNLOAD Example.txt"
     */
    private final String selDownload = "DOWNLOAD";
    /**
     * Команда для загрузки файла на сервер.
     * Пример: "/UPLOAD Example.txt"
     */
    private final String selUpload = "UPLOAD";
    /**
     * Меню для сервера.
     */
    private final boolean usingForServer;

    /**
     * Входной поток.
     */
    private DataInputStream dataInputStream;
    /**
     * Входной поток.
     */
    private Scanner console;

    /**
     * Конструктор для сервера.
     * @param socket - socket server.
     * @throws IOException exception.
     */
    public Menu(Socket socket) throws IOException {
        this.usingForServer = true;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
    }

    /**
     * Конструктор для клиента.
     * @throws IOException exception.
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

                if (this.usingForServer) {
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
                        if (this.usingForServer) {
                            actions.exit();
                        } else {
                            actions.sendMessage(select);
                            actions.exit();
                        }

                    } else if (selShow.equals(select)) {
                        if (this.usingForServer) {
                            // показать все содержимое.
                            actions.show();
                        } else {
                            actions.sendMessage(select);
                            // читать сообщение
                            actions.readMessage();
                        }

                    } else if (select.startsWith(selGoToDirectory)) {
                        if (this.usingForServer) {
                            // перейти в каталог выше
                            actions.goToDirectory(select);
                        } else {
                            actions.sendMessage(select);
                            // читать сообщение
                            actions.readMessage();
                        }

                    } else if (selHomeDir.equals(select)) {
                        if (this.usingForServer) {
                            // перейти в домашний каталог.
                            actions.toHomeDir();
                        } else {
                            actions.sendMessage(select);
                            // читать сообщение
                            actions.readMessage();
                        }

                    } else if (select.startsWith(selDownload)) {
                        String fileName = select.substring(selDownload.length() + 1, select.length());
                        if (this.usingForServer) {
                            // отправить файл
                            actions.upload(fileName);
                        } else {
                            actions.sendMessage(select);
                            // принять файл
                            actions.download(fileName);
                        }

                    } else if (select.startsWith(selUpload)) {
                        String fileName = select.substring(selDownload.length() + 1, select.length());
                        if (this.usingForServer) {
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

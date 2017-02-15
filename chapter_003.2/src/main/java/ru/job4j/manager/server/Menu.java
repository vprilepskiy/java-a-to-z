package ru.job4j.manager.server;

import java.io.*;
import java.net.Socket;

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

    /**
     * Входной поток.
     */
    public DataInputStream dataInputStream;
//    public InputStream inputStream;
    /**
     * Выходной поток.
     */
    public DataOutputStream dataOutputStream;

    /**
     * Конструктор.
     */
    public Menu(Socket socket) throws IOException {
        this.dataInputStream = new DataInputStream(socket.getInputStream());
//        this.inputStream = socket.getInputStream();
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void menuNavigator(IActions actions) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.dataInputStream));

        boolean again = true;

        String select = null;

        while (again) {
            // читаем что послал клиент

            try {
                select = bufferedReader.readLine();
//                select = this.dataInputStream.readUTF();

                System.out.println(select);

                if (select != null) {

                    if (selExit.equalsIgnoreCase(select)) {
                        again = false;
                        actions.exit();
                    } else if (selShow.equalsIgnoreCase(select)) {
                        // показать все содержимое.
                        actions.show();
                    } else if (selGoToDirectory.equals(select.substring(0, selGoToDirectory.length()))) {
                        // перейти в каталог выше
                        actions.goToDirectory(select);
                    } else if (selHomeDir.equals(select)) {
                        // перейти в домашний каталог.
                        actions.toHomeDir();
                    } else if (selDownload.equalsIgnoreCase(select.substring(0, selDownload.length()))) {
                        String fileName = select.substring(selDownload.length() + 1, select.length());
                        // скачать файл
                        actions.download(fileName);
                    } else if (selUpload.equalsIgnoreCase(select.substring(0, selUpload.length()))) {
                        // закачать фаайл
                        String fileName = select.substring(selUpload.length() + 1, select.length());
                        actions.upload(fileName);
                    } else {
                        // неизвестная команда
                        this.dataOutputStream.writeUTF(errSel);
                        this.dataOutputStream.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package ru.job4j.manager.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by VLADIMIR on 07.02.2017.
 */
public class DirectionalControl {

    public final String selExit = "EXIT";
    public final String selShow = "SHOW";
    public final String selGoToDirectory = "/";
    public final String selHomeDir = "HOME";
    public final String selDownload = "DOWNLOAD";
    public final String selUpload = "UPLOAD";
    public final String errSel = "unknown command";

    public DataInputStream dataInputStream;
    public DataOutputStream dataOutputStream;

    public final File homeDirectory;
//    public File currentDirectory;



    /**
     * Конструктор.
     */
    public DirectionalControl(Socket socket, File homeDirectory) throws IOException {

        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());

        this.homeDirectory = homeDirectory;
//        this.currentDirectory = homeDirectory;
    }


    public void selector(Actions actions) throws IOException {

        boolean again = true;

        while (again) {
            // читаем что послал клиент
            String select = this.dataInputStream.readUTF();

            if (selExit.equalsIgnoreCase(select)) {
                again = false;
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
            } else {
                // неизвестная команда
                this.dataOutputStream.writeUTF(errSel);
            }
            // отправка в поток.

        }
    }

//    /**
//     * Отправляет в поток информацию о содержании такущего каталога.
//     * @throws IOException
//     */
//    public void show() throws IOException {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("The contents of the folder: ");
//        stringBuilder.append(this.currentDirectory.getAbsolutePath());
//        stringBuilder.append(lineSeparator);
//
//        File[] files = this.currentDirectory.listFiles();
//
//        for (File file : files) {
//            if (file.isDirectory()) {
//                stringBuilder.append("<DIR> ");
//            } else {
//                stringBuilder.append("      ");
//            }
//            stringBuilder.append(file.getName());
//            stringBuilder.append(lineSeparator);
//        }
//        this.dataOutputStream.writeUTF(stringBuilder.toString());
//        this.dataOutputStream.flush();
//    }
//
//    /**
//     * Переход в каталог выше.
//     * @param select - Команда.
//     */
//    public void goToDirectory(String select) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.currentDirectory.getAbsolutePath());
//        stringBuilder.append(select);
//        this.currentDirectory = new File(stringBuilder.toString());
//    }
//
//    /**
//     * Переход в домашний каталог.
//     */
//    public void toHomeDir() {
//        this.currentDirectory = this.homeDirectory;
//    }
//
//    /**
//     * Отправит в поток запрашивемый файл.
//     * @param select
//     */
//    public void download(String select) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.currentDirectory.getAbsolutePath());
//        stringBuilder.append("/");
//        stringBuilder.append(select.substring(selDownload.length() + 1, select.length()));
//        File file = new File(stringBuilder.toString());
//        if (file.isFile()) {
//            System.out.println("ready " + file.getTotalSpace());
//        } else {
//            System.out.println("Fack....");
//        }
//    }
//
//    /**
//     * Получит из потока отправляемый файл.
//     */
//    public void upload() {
//
//    }

}

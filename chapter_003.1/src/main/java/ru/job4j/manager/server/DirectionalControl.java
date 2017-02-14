package ru.job4j.manager.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by VLADIMIR on 07.02.2017.
 */
public class DirectionalControl {

//    public final String selExit = "EXIT";
//    public final String selShow = "SHOW";
//    public final String selGoToDirectory = "/";
//    public final String selHomeDir = "HOME";
//    public final String selDownload = "DOWNLOAD";
//    public final String selUpload = "UPLOAD";
//    public final String errSel = "unknown command";
//
//    public DataInputStream dataInputStream;
//    public DataOutputStream dataOutputStream;
//
////    public final File homeDirectory;
////    public File currentDirectory;
//
//
//
//    /**
//     * Конструктор.
//     */
//    public DirectionalControl(Socket socket) throws IOException {
//
//        this.dataInputStream = new DataInputStream(socket.getInputStream());
//        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
//
////        this.homeDirectory = homeDirectory;
////        this.currentDirectory = homeDirectory;
//    }
//
//
//    public void selector(Actions actions) throws IOException {
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.dataInputStream));
//
//        boolean again = true;
//
//        while (again) {
//            // читаем что послал клиент
//            String select = bufferedReader.readLine();
//
//            if (selExit.equalsIgnoreCase(select)) {
//                again = false;
//                actions.exit();
//            } else if (selShow.equalsIgnoreCase(select)) {
//                // показать все содержимое.
//                actions.show();
//            } else if (selGoToDirectory.equals(select.substring(0, selGoToDirectory.length()))) {
//                // перейти в каталог выше
//                actions.goToDirectory(select);
//            } else if (selHomeDir.equals(select)) {
//                // перейти в домашний каталог.
//                actions.toHomeDir();
//            } else if (selDownload.equalsIgnoreCase(select.substring(0, selDownload.length()))) {
//                String fileName = select.substring(selDownload.length() + 1, select.length());
//                // скачать файл
//                actions.download(fileName);
//            } else if (selUpload.equalsIgnoreCase(select.substring(0, selUpload.length()))) {
//                // закачать фаайл
//                String fileName = select.substring(selUpload.length() + 1, select.length());
//                actions.upload(fileName);
//            } else {
//                // неизвестная команда
//                this.dataOutputStream.writeUTF(errSel);
//                this.dataOutputStream.flush();
//            }
//        }
//    }

}

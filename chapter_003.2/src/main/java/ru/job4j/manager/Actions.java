package ru.job4j.manager;

import java.io.*;
import java.net.Socket;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class Actions implements IActions {

    /**
     * Входной поток.
     */
    private DataInputStream dataInputStream;
    /**
     * Выходной поток.
     */
    private DataOutputStream dataOutputStream;
    /**
     * Домашний каталог.
     */
    private final File homeDirectory;
    /**
     * Текущий каталог.
     */
    private File currentDirectory;
//    /**
//     * Символ файловый разделитель.
//     */
//    private final String slash = System.getProperty("file.separator");
    /**
     * Символ разделитель строк.
     */
    private final String lineSeparator = System.getProperty("line.separator");

    /**
     * Конструктор для сервера.
     *
     * @param socket        - Сокет.
     * @param homeDirectory - Домашний каталог.
     */
    public Actions(Socket socket, File homeDirectory) {
        this.currentDirectory = this.homeDirectory = homeDirectory;
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Конструктор для клиента.
     *
     * @param socket        - Сокет.
     */
    public Actions(Socket socket) {
        this.currentDirectory = this.homeDirectory = null;
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exit() {
        try {
            if (this.dataInputStream != null) {
                this.dataInputStream.close();
            }
            if (this.dataOutputStream != null) {
                this.dataOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show() {
        StringBuilder stringBuilder = new StringBuilder();
        // получить список файлов в каталоге
        File[] files = this.currentDirectory.listFiles();

        for (File file : files) {

            if (file.isDirectory()) {
                // если каталог
                stringBuilder.append("<DIR> ");
            } else {
                // если файл
                stringBuilder.append("      ");
            }
            // имя файла
            stringBuilder.append(file.getName());
            stringBuilder.append(this.lineSeparator);
        }
        // отправить список в поток
        try {
            this.dataOutputStream.writeUTF(stringBuilder.toString());
            this.dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goToDirectory(String select) {
//        // новый путь (\temp)
        File newDir = new File(this.currentDirectory, select);
        // если путь - папка
        if (newDir.isDirectory()) {
            this.currentDirectory = newDir;
        }
        // отправить в поток текущий каталог
        try {
            this.dataOutputStream.writeUTF(this.currentDirectory.getAbsolutePath());
            this.dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toHomeDir() {
        this.currentDirectory = this.homeDirectory;
        // отправить в поток текущий каталог
        try {
            this.dataOutputStream.writeUTF(this.currentDirectory.getAbsolutePath());
            this.dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upload(String fileName) {
        File file = new File(this.currentDirectory, fileName);
        try {
            if (file.isFile()) {
                // получаем размер файла
                long fileSize = file.length();
                // отправляем размер
                System.out.println("upload file: " + file.getAbsolutePath() + "; size: " + fileSize);
                this.dataOutputStream.writeLong(fileSize);
                // читаем файл
                FileInputStream fileInputStream = new FileInputStream(file);
                int oneByte = 0;
                // отправляем в поток
                while ((oneByte = fileInputStream.read()) != -1) {
                    this.dataOutputStream.write(oneByte);
                }
                this.dataOutputStream.flush();
                fileInputStream.close();
                System.out.println("upload ok");
            } else {
                // отправляем размер 0
                this.dataOutputStream.writeLong(0);
                this.dataOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void download(String fileName) {
        File file = new File(this.currentDirectory, fileName);
        try {
            // пришем в файл
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // читаем размер файла
            long fileSize = this.dataInputStream.readLong();
            System.out.println("download file: " + file.getAbsolutePath() + "; size: " + fileSize);
            long index = 0;
            int oneByte;
            // читаем побайтово из потока и пишем в файл
            while (fileSize >= ++index) {
                oneByte = this.dataInputStream.read();
                fileOutputStream.write(oneByte);
//                System.out.print((char) oneByte);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println("download ok");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unknownCommand() {
        System.out.println("unknown command");
    }

    @Override
    public void sendMessage(String message) {
        try {
            this.dataOutputStream.writeUTF(message);
            this.dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readMessage() {
        try {
            String message = this.dataInputStream.readUTF();
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

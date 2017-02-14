package ru.job4j.manager.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class Actions implements IActions {

    /**
     * Входной поток.
     */
    private DataInputStream dataInputStream = null;
    /**
     * Выходной поток.
     */
    private DataOutputStream dataOutputStream = null;
    /**
     * Домашний каталог.
     */
    private File homeDirectory = null;
    /**
     * Текущий каталог.
     */
    private File currentDirectory = null;
    /**
     * Символ файловый разделитель.
     */
    private final String slash = System.getProperty("file.separator");
    /**
     * Символ разделитель строк.
     */
    private final String lineSeparator = System.getProperty("line.separator");

    /**
     * Конструктор.
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
            stringBuilder.append(lineSeparator);
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
        StringBuilder pathDir = new StringBuilder();
        // путь к текущему каталогу
        pathDir.append(this.currentDirectory.getAbsolutePath());
        // новый путь (\temp)
        pathDir.append(select);
        File newDir = new File(pathDir.toString());
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
    public void download(String fileName) {
        StringBuilder pathFile = new StringBuilder();
        pathFile.append(this.currentDirectory.getAbsolutePath());
        pathFile.append(this.slash);
        pathFile.append(fileName);
        File file = new File(pathFile.toString());
        try {
            if (file.isFile()) {
                // если это файл, то отправить в поток вопрос клиенту. Готов принять?

                this.dataOutputStream.writeUTF("ready");

                this.dataOutputStream.flush();
                // если получен ответ от клиента, что он готов, то начать передачу
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.dataInputStream));
                if ("ready".equals(bufferedReader.readLine())) {
                    // читаем файл и отправляем в поток
                    FileInputStream fileInputStream = new FileInputStream(file);

                    int oneByte;
                    while ((oneByte = fileInputStream.read()) != -1) {
                        this.dataOutputStream.write(oneByte);
                    }
                    this.dataOutputStream.flush();
                    fileInputStream.close();
                }
            } else {
                // если это не файл, то оправить в поток клиенту. Это не файл.
                this.dataOutputStream.writeUTF("file not found");
                this.dataOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upload(String fileName) {
        // клиент отправляет ready?
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.dataInputStream));
        try {
            if ("ready".equals(bufferedReader.readLine())) {
                StringBuilder pathFile = new StringBuilder();
                pathFile.append(this.currentDirectory.getAbsolutePath());
                pathFile.append(this.slash);
                pathFile.append(fileName);

                // отвечаем ready
                this.dataOutputStream.writeUTF("ready");

                // читаем из потока и пишем в файл
                FileOutputStream fileOutputStream = new FileOutputStream(new File(pathFile.toString()));
                int oneByte;
                while ((oneByte = bufferedReader.read()) != -1) {
                    fileOutputStream.write(oneByte);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ru.job4j.manager.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by VLADIMIR on 08.02.2017.
 */
public class Actions {

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;


    private final String slash = System.getProperty("file.separator");
    private final String lineSeparator = System.getProperty("line.separator");

    private final File homeDirectory;


    private File currentDirectory;


    public Actions(Socket socket, File homeDirectory){
        this.currentDirectory = this.homeDirectory = homeDirectory;
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Отправляет в поток информацию о содержании такущего каталога.
     * @throws IOException
     */
    public void show() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        // показать рабочий каталог
//        stringBuilder.append(this.getCurrentDirectoryAbsolutePath());

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
        this.dataOutputStream.writeUTF(stringBuilder.toString());
        this.dataOutputStream.flush();
    }

    /**
     * Переход в каталог выше.
     * @param select - Команда.
     */
    public void goToDirectory(String select) throws IOException {
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
        this.dataOutputStream.writeUTF(this.currentDirectory.getAbsolutePath());
        this.dataOutputStream.flush();
    }

    /**
     * Переход в домашний каталог.
     */
    public void toHomeDir() throws IOException {
        this.currentDirectory = this.homeDirectory;
        // отправить в поток текущий каталог
        this.dataOutputStream.writeUTF(this.currentDirectory.getAbsolutePath());
        this.dataOutputStream.flush();
    }

    /**
     * Отправит в поток запрашивемый файл.
     */
    public void download(String fileName) throws IOException {

        StringBuilder pathFile = new StringBuilder();
        pathFile.append(this.currentDirectory.getAbsolutePath());
        pathFile.append(this.slash);
        pathFile.append(fileName);
        File file = new File(pathFile.toString());

        if (file.isFile()) {
            // если это файл, то отправить в поток вопрос клиенту. Готов принять?
            this.dataOutputStream.writeUTF("ready");
            this.dataOutputStream.flush();
            // если получен ответ от клиента, что он готов, то начать передачу
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.dataInputStream));
            if ("ready".equals(bufferedReader.readLine())) {
                // отправка файла
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
    }

    /**
     * Получит из потока отправляемый файл.
     */
    public void upload() {



    }

//    public String getCurrentDirectoryAbsolutePath() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("The contents of the folder: ");
//        stringBuilder.append(lineSeparator);
//        stringBuilder.append(this.currentDirectory.getAbsolutePath());
//        stringBuilder.append(lineSeparator);
//        return stringBuilder.toString();
//    }

}

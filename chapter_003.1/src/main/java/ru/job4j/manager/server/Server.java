package ru.job4j.manager.server;

import ru.job4j.manager.Settings;
import ru.job4j.manager.client.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

/**
 * 2. Серверная часть должна реализовывать следующее апи
 * - получить список корневого каталога. Корневой каталог задается при запуске сервера.
 * - перейти в подкаталог.
 * - спуститься в родительский каталог
 * - скачать файл
 * - загрузить файл.
 * <p>
 * Created by VLADIMIR on 05.02.2017.
 */
public class Server {

//    Settings settings;
//    final String ip;
//    final int port;
   // final static int port = 5000;

    public Server() throws IOException {
//        ClassLoader classLoader = Settings.class.getClassLoader();
//        try (InputStream inputStream = classLoader.getResourceAsStream("app.properties")) {
//            this.settings = new Settings(inputStream);
//        }
////        this.settings = new Settings(new FileInputStream("C:\\projects\\vprilepskiy\\chapter_003.1\\src\\main\\resources\\app.properties"));
//        this.ip = settings.getValue("ip");
//        this.port = Integer.valueOf(settings.getValue("port"));
    }


    public void start(int port) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("server Ждем подключения к серверу");
        Socket socket = serverSocket.accept();
        System.out.println("Подключение состоялось");

//        InputStream inputStream = socket.getInputStream();
//        OutputStream outputStream = socket.getOutputStream();
//
//        DataInputStream dataInputStream = new DataInputStream(inputStream);
//        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        String string = null;
        boolean again = true;
        while (again) {
            // читаем из потока.
//            string = dataInputStream.readUTF();
//            System.out.println("server Мы получили следующее сообщение: " + string);
//            System.out.println("server Отправка обратно");
//            dataOutputStream.writeUTF(string);
//            dataOutputStream.flush();
        }
    }
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
////        new Server(port);
////        new Server().getAll();
//        Server server = new Server();
//        System.out.println(server.ip + " " + server.port);
//    }
//
//    public void getAll() {
//        File file = new File("C:/Temp/////projects");
//
//        System.out.println(file.getAbsolutePath());
//
//    }
}

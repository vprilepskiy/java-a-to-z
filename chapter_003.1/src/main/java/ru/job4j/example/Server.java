package ru.job4j.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by VLADIMIR on 02.02.2017.
 */
public class Server {

    public static void main(String[]args) throws IOException {
        // 1025-65535
        int port = 5000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("server Ждем подключения к серверу");
        Socket socket = serverSocket.accept();
        System.out.println("Подключение состоялось");

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        DataInputStream dataInputStream = new DataInputStream(inputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        String string = null;
        while (true) {
            string = dataInputStream.readUTF();
            System.out.println("server Мы получили следующее сообщение: " + string);
            System.out.println("server Отправка обратно");
            dataOutputStream.writeUTF(string);
            dataOutputStream.flush();
        }
    }

}

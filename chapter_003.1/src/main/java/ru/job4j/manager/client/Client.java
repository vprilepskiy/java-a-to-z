package ru.job4j.manager.client;

import ru.job4j.manager.Settings;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by VLADIMIR on 05.02.2017.
 */
public class Client {

    final static String ip = "127.0.0.1";
    final static int port = 5000;
    final File file = new File("");

    public Client(String ip, int port) throws IOException {
        InetAddress inetAddress = InetAddress.getByName(ip);
        System.out.println("client Подключаемся к серверу: " + port);
        Socket socket = new Socket(inetAddress, port);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        DataInputStream dataInputStream = new DataInputStream(inputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        System.out.println("client Введите фразу для передачи серверу: ");

        while (true) {
            // ввод с консоли и отправка в поток.
            string = bufferedReader.readLine();
            dataOutputStream.writeUTF(string);
            dataOutputStream.flush();
            // читаем из потока.
            string = dataInputStream.readUTF();
            System.out.println("client Сервер пислал в ответ: " + string);
            System.out.println("client Введите фразу для отправки на сервер: ");
        }
    }

    public static void main(String[] args) throws IOException {
        new Client(ip, port);
    }

}

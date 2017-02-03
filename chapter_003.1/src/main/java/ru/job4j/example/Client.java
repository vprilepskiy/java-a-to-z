package ru.job4j.example;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by VLADIMIR on 02.02.2017.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        int port = 5000;
        String ip = "127.0.0.1";

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
            string = bufferedReader.readLine();
            dataOutputStream.writeUTF(string);
            dataOutputStream.flush();

            string = dataInputStream.readUTF();
            System.out.println("client Сервер пислал в ответ: " + string);
            System.out.println("client Введите фразу для отправки на сервер: ");
        }
    }

}

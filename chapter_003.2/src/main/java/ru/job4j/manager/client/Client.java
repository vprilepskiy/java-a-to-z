package ru.job4j.manager.client;

import ru.job4j.manager.Settings;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class Client implements IClient {
    @Override
    public void start() {
        final String propertiesFileName = "app.properties";
        Settings settings = new Settings(propertiesFileName);
        String ip = settings.getValue("ip");
        int port = Integer.valueOf(settings.getValue("port"));

        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(ip);
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
                System.out.println("читаем из потока");
                string = dataInputStream.readUTF();
                System.out.println("client Сервер пислал в ответ: " + string);
                System.out.println("client Введите фразу для отправки на сервер: ");
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Client().start();
    }
}

package ru.job4j.manager.client;

import ru.job4j.manager.Settings;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

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

        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            Socket socket = new Socket(inetAddress, port);

            System.out.println(socket.isConnected());

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

//            DataInputStream dataInputStream = new DataInputStream(inputStream);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));

//            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            Scanner console = new Scanner(System.in);
            String string = null;
            System.out.println("client Введите фразу для передачи серверу: ");

            while (true) {
                // ввод с консоли и отправка в поток.
                string = console.nextLine();
                System.out.println("send: " + string + " читаем из потока");
                outputStream.write(string.getBytes());
                outputStream.flush();
//                out.write(string);
//                out.flush();
//                dataOutputStream.writeUTF(string);
//                dataOutputStream.flush();
                // читаем из потока.

//                string = dataInputStream.readUTF();
                string = in.readLine();
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

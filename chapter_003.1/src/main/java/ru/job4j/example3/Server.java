package ru.job4j.example3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by VLADIMIR on 20.02.2017.
 *
 *******НЕ РАБОТАЕТ******
 *
 */
public class Server {

    public static void main(String[]args) throws IOException {
        int port = 5000;
        ServerSocket serverSocket = new ServerSocket(port);
        // ЖДЕМ КЛИЕНТА
        Socket socket = serverSocket.accept();

//        new Server().serverBufferedStreams(socket);
        new Server().serverDataStreams(socket);
    }

    /**
     * Метод с использованием BufferedReader и BufferedWriter.
     * ******НЕ РАБОТАЕТ******
     */
    public void serverBufferedStreams(Socket socket) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // ПОЛУЧЕНИЕ
        String response = null;
        // ОТПРАВКА
        String request = null;

        int index = 0;
        while (true) {
            // ПОЛУЧЕНИЕ
            response = bufferedReader.readLine();
            System.out.println("получено сообщение: " + response);
            // ОТПРАВКА
            index++;
            request = response + index;

            bufferedWriter.write(request);
            bufferedWriter.flush();
            System.out.println("отправлено сообщение: " + request);
        }
    }



    public void serverDataStreams(Socket socket) throws IOException {

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        // ПОЛУЧЕНИЕ
        String response = null;
        // ОТПРАВКА
        String request = null;

        int index = 0;
        while (true) {
            // ПОЛУЧЕНИЕ
            response = dataInputStream.readUTF();
            System.out.println("получено сообщение: " + response);
            // ОТПРАВКА
            index++;
            request = response + index;

            dataOutputStream.writeUTF(request);
            dataOutputStream.flush();
            System.out.println("отправлено сообщение: " + request);
        }
    }
}

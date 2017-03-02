package ru.job4j.example3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Использование классов ввода/вывода с Socket.
 *
 * Created by VLADIMIR on 20.02.2017.
 */
public class Server {

    final String lineSeparator = System.getProperty("line.separator");

    public static void main(String[]args) throws IOException {
        int port = 5000;
        ServerSocket serverSocket = new ServerSocket(port);
        // ЖДЕМ КЛИЕНТА
        Socket socket = serverSocket.accept();

//        new Server().serverStreams(socket);
//        new Server().serverBufferedStreams(socket);
//        new Server().serverDataStreams(socket);
        new Server().serverDataStreamsAcceptFile(socket);
    }


    /**
     * Метод с использованием InputStream и OutputStream.
     */
    public void serverStreams(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // ПОЛУЧЕНИЕ
        String response = null;
        // ОТПРАВКА
        String request = null;

        int index = 0;
        while (true) {
            // ПОЛУЧЕНИЕ
            int oneByte;
            StringBuilder stringBuilder = new StringBuilder();
            while ((oneByte = inputStream.read()) != '\n'){
                stringBuilder.append((char) oneByte);
            }
            response = stringBuilder.toString();
            System.out.println("получено сообщение: " + response);
            // ОТПРАВКА
            index++;
            request = response + index + '\n';
            outputStream.write(request.getBytes());
            outputStream.flush();
            System.out.println("отправлено сообщение: " + request);
        }
    }



    /**
     * Метод с использованием BufferedReader и BufferedWriter.
     * РАБОТАЕТ. Требовалось bufferedWriter.newLine();
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
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("отправлено сообщение: " + request);
        }
    }


    /**
     * Метод с использованием DataInputStream и DataOutputStream.
     */
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


    /**
     * Метод с использованием DataInputStream и DataOutputStream + BufferedReader и BufferedWriter.
     */
    public void serverDataStreamsAcceptFile(Socket socket) throws IOException {

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        File file = new File("C:\\Temp\\projects\\Tracker\\copy_activity diagram.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        long fileSize = dataInputStream.readLong();
        long index = 0;
        int oneByte = 0;

        while (fileSize >= ++index) {
            oneByte = dataInputStream.read();
            fileOutputStream.write(oneByte);
            System.out.print((char) oneByte);
        }
        fileOutputStream.flush();
        fileOutputStream.close();

        dataOutputStream.writeUTF("file_accepted");
    }
}

package ru.job4j.example3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Использование классов ввода/вывода с Socket.
 *
 * Created by VLADIMIR on 20.02.2017.
 */
public class Client {

    final String lineSeparator = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 5000;
        String ip = "127.0.0.1";

        InetAddress inetAddress = InetAddress.getByName(ip);
        Socket socket = new Socket(inetAddress, port);

//        new Client().clientStreams(socket);
//        new Client().clientBufferedStreams(socket);
//        new Client().clientDataStreams(socket);
        new Client().clientDataStreamsSendFile(socket);
    }


    /**
     * Метод с использованием InputStream и OutputStream.
     */
    public void clientStreams(Socket socket) throws IOException, InterruptedException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // ОТПРАВКА
        String request = "Hello!!! \n";
        // ПОЛУЧЕНИЕ
        String response = null;

        while (true) {
            Thread.sleep(1000);
            // ОТПРАВКА
            outputStream.write(request.getBytes());
            outputStream.flush();
            System.out.println("отправлено сообщение: " + request);
            // ПОЛУЧЕНИЕ
            int oneByte;
            StringBuilder stringBuilder = new StringBuilder();
            while ((oneByte = inputStream.read()) != '\n'){
                stringBuilder.append((char) oneByte);
            }
            response = stringBuilder.toString();
            System.out.println("получено сообщение: " + response);
        }
    }



    /**
     * Метод с использованием BufferedReader и BufferedWriter.
     * РАБОТАЕТ. Требовалось bufferedWriter.newLine();
     */
    public void clientBufferedStreams(Socket socket) throws IOException, InterruptedException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // ОТПРАВКА
        String request = "Hello!!!";
        // ПОЛУЧЕНИЕ
        String response = null;

        while (true) {
            Thread.sleep(1000);
            // ОТПРАВКА
            bufferedWriter.write(request);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("отправлено сообщение: " + request);
            // ПОЛУЧЕНИЕ
            response = bufferedReader.readLine();
            System.out.println("получено сообщение: " + response);
        }
    }


    /**
     * Метод с использованием DataInputStream и DataOutputStream.
     */
    public void clientDataStreams(Socket socket) throws IOException, InterruptedException {

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        // ОТПРАВКА
        String request = "Hello!!!";
        // ПОЛУЧЕНИЕ
        String response = null;

        while (true) {
            Thread.sleep(1000);
            // ОТПРАВКА
            dataOutputStream.writeUTF(request);
            dataOutputStream.flush();
            System.out.println("отправлено сообщение: " + request);
            // ПОЛУЧЕНИЕ
            response = dataInputStream.readUTF();
            System.out.println("получено сообщение: " + response);
        }
    }


    /**
     * Метод с использованием DataInputStream и DataOutputStream + BufferedReader и BufferedWriter.
     */
    public void clientDataStreamsSendFile(Socket socket) throws IOException {

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        File file = new File("C:\\Temp\\projects\\Tracker\\activity diagram.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);

        long fileSize = file.length();
        long index = 0;
        int oneByte = 0;

        // отправка размера файла.
        dataOutputStream.writeLong(fileSize);
        // отправка файла
        while ((oneByte = fileInputStream.read()) != -1) {
            dataOutputStream.write(oneByte);
            System.out.print((char) oneByte);
            index++;
        }
        System.out.println(fileSize + "; " + index);
        dataOutputStream.flush();
        fileInputStream.close();

        // читаем
        System.out.println(dataInputStream.readUTF());
    }
}

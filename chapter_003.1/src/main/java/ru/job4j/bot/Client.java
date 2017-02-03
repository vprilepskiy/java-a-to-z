package ru.job4j.bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by VLADIMIR on 02.02.2017.
 *
 */
public class Client {

    public Client(String ip, int port) throws IOException {

        Socket socket = new Socket(InetAddress.getByName(ip), port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String request = null;
        String response = null;
        do {
            // отсылаем сообщение на сервер
            request = console.nextLine();
            out.println(request);
            // читаем из потока
            if (!("exit".equals(request))) {
                while (!(response = in.readLine()).isEmpty()) {
                    System.out.println(response);
                }
            }
        } while (!("exit".equals(request)));
    }
}

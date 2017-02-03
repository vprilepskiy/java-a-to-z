package ru.job4j.bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by VLADIMIR on 02.02.2017.
 * Сервер должен отвечать на простые вопросы. Если Оралку сказали пока. То приложение выключается.
 * Важно, что Оракл может отправлять большие сообщения. Что бы понять когда конец сообщение он отправляет пустую строку.
 */
public class Server {

    public Server(int port) throws IOException {

        Socket socket = new ServerSocket(port).accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask = null;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("Hello oracle".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else {
                out.println("I don't understand");
                out.println();
            }
        } while (!("exit".equals(ask)));
    }
}

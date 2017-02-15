package ru.job4j.manager.server;

import ru.job4j.manager.Settings;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class Server implements IServer {
    @Override
    public void start() {

        final String propertiesFileName = "app.properties";
        Settings settings = new Settings(propertiesFileName);
        int port = Integer.valueOf(settings.getValue("port"));
        File homeDir = new File(settings.getValue("homeDir"));

        try (ServerSocket serverSocket = new ServerSocket(port)){
            Socket socket = serverSocket.accept();
            System.out.println("server connect");
            Menu menu = new Menu(socket);
            menu.menuNavigator(new Actions(socket, homeDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }
}

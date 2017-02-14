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

        Settings settings = new Settings("app.properties");

        int port = Integer.getInteger(settings.getValue("port"));
        File homeDir = new File(settings.getValue("homeDir"));

        try (ServerSocket serverSocket = new ServerSocket(port)){
            Socket socket = serverSocket.accept();
            Menu menu = new Menu(socket);
            menu.menuNavigator(new Actions(socket, homeDir));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

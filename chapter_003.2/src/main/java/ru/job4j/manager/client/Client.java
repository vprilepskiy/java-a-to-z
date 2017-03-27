package ru.job4j.manager.client;

import ru.job4j.manager.Actions;
import ru.job4j.manager.Menu;
import ru.job4j.manager.Settings;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by VLADIMIR on 18.03.2017.
 */
public class Client implements IClient {

    @Override
    public void start() {

        final String propertiesFileName = "app.properties";

        final Settings settings = new Settings(propertiesFileName);
        final String ip = settings.getValue("ip");
        final int port = Integer.valueOf(settings.getValue("port"));

        try (Socket socket = new Socket(InetAddress.getByName(ip), port)) {
            System.out.println("client connect");
            Menu menu = new Menu();
            menu.menuNavigator(new Actions(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Start client. Only after start Server.
     * @param args - noop.
     */
    public static void main(String[] args) {
        new Client().start();
    }
}

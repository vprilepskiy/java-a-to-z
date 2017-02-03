package ru.job4j.bot;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by VLADIMIR on 02.02.2017.
 */
public class TestClient {

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 5000);
    }
}

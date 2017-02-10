package ru.job4j.bot;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;


/**
 * Created by VLADIMIR on 02.02.2017.
 */
public class TestServer {

    public final String lineSeparator = System.getProperty("line.separator");

    @Test
    public void whenAskAnswearThenChooseRandom() throws IOException {
        this.testServer("exit", "");
    }


    @Test
    public void whenAskAnswear() throws IOException {
        this.testServer("Hello oracle" + lineSeparator + "exit", "Hello, dear friend, I'm a oracle." + lineSeparator + lineSeparator);
    }

    /**
     * Передаем socket в тестируемый метод.
     * Гоняем байты в InputStream проверяем что на выходе из OutputStream.
     *
     * @param input
     * @param expected
     * @throws IOException
     */
    public void testServer(String input, String expected) throws IOException {

        Socket socket = Mockito.mock(Socket.class);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());

        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);
        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        Server server = new Server(socket);
        server.start();

        Assert.assertThat(byteArrayOutputStream.toString(), Is.is(expected));

    }

}

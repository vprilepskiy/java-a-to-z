package ru.job4j.manager.server;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.manager.Actions;

import java.io.*;
import java.net.Socket;
import java.net.URISyntaxException;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class TestActions {

    File rootTestCatalog;
    File firstTestCatalog;
    final String slash = System.getProperty("file.separator");
    final String lineSeparator = System.getProperty("line.separator");

    @Before
    public void createTestFile() throws URISyntaxException, IOException {
        // путь к ресурсному каталогу
        File resourceCatalog = new File(new Server().getClass().getResource( "/app.properties").toURI()).getParentFile();
        // создаем тестовые каталоги
        File rootTestCatalog = new File(resourceCatalog, "rootTestCatalog");
        File firstTestCatalog = new File(rootTestCatalog, "firstTestCatalog");
        File secondTestCatalog = new File(rootTestCatalog, "secondTestCatalog");
        firstTestCatalog.mkdirs();
        secondTestCatalog.mkdirs();
        // создаем тестовые файлы
        new File(firstTestCatalog, "firstTestFile.txt").createNewFile();
        new File(secondTestCatalog, "secondTestFile.txt").createNewFile();
        File rootFile = new File(rootTestCatalog, "rootTestFile.txt");
        rootFile.createNewFile();
        // запишем строку
        FileWriter fileWriter = new FileWriter(rootFile);
        fileWriter.write("ABCD");
        fileWriter.flush();
        fileWriter.close();
        // тестовый каталог
        this.rootTestCatalog = new File(resourceCatalog.getAbsolutePath(), "rootTestCatalog");
        this.firstTestCatalog = new File(new File(resourceCatalog,"rootTestCatalog"), "firstTestCatalog");
    }



    /**
     * Test Show.
     * @throws IOException
     */
    @Test
    public void whenShowThenGetStream() throws IOException {
        // ожидаемое значение
        StringBuilder expected = new StringBuilder();
        expected.append("<DIR> firstTestCatalog");
        expected.append(lineSeparator);
        expected.append("      rootTestFile.txt");
        expected.append(lineSeparator);
        expected.append("<DIR> secondTestCatalog");
        expected.append(lineSeparator);

        Socket socket = Mockito.mock(Socket.class);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
        // тестируемый метод
        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.show();
        // проверяем
        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(expected.toString()));
    }

    /**
     * Test for goToDirectory and toHomeDir.
     * @throws IOException
     */
    @Test
    public void whenToDirThenGetStreamAndWhenToHomeDirThenGetStream() throws IOException {

        final String expected = this.rootTestCatalog.toString() + this.slash + "secondTestCatalog";

        Socket socket = Mockito.mock(Socket.class);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.goToDirectory(this.slash + "secondTestCatalog");

        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(expected));

        byteArrayOutputStream.reset();

        actions.toHomeDir();
        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(this.rootTestCatalog.getAbsolutePath().toString()));
    }

    /**
     * Test for download.
     * @throws IOException
     */
    @Test
    public void whenDownloadThenSetStream() throws IOException {
        final String fileName = "DownloadFile.txt";
        final byte[] input = {0, 0, 0, 0, 0, 0, 0, 4, 'A', 'B', 'C', 'D'};
        byte[] expected = new byte[4];
        byte[] result = new byte[4];

        Socket socket = Mockito.mock(Socket.class);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.download(fileName);

        File file = new File(this.rootTestCatalog, fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(expected);
        fileInputStream.close();

        System.arraycopy(input, 8, result, 0, 4);

        Assert.assertThat(result, Is.is(expected));
        file.delete();
    }

    /**
     * Test for upload.
     * @throws IOException
     */
    @Test
    public void whenUploadThenGetStream() throws IOException {
        final String fileName = "rootTestFile.txt";
        final byte[] expected = {0, 0, 0, 0, 0, 0, 0, 4, 'A', 'B', 'C', 'D'};

        Socket socket = Mockito.mock(Socket.class);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.upload(fileName);

        Assert.assertThat(byteArrayOutputStream.toByteArray(), Is.is(expected));
    }

    /**
     * Test for SendMessage.
     * @throws IOException
     */
    @Test
    public void whenSendMessageThenGetStream() throws IOException {
        final String message = "Hello world";
        final byte[] expected = {0, 11, 'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};

        Socket socket = Mockito.mock(Socket.class);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.sendMessage(message);

        Assert.assertThat(byteArrayOutputStream.toByteArray(), Is.is(expected));
    }

    @Test
    public void whenReadMessageThenSetStream() throws IOException {
        byte[] input = {0, 11, 'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        final String expected = "Hello world\r\n";

        Socket socket = Mockito.mock(Socket.class);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.readMessage();

        Assert.assertThat(result.toString(), Is.is(expected));

    }

}

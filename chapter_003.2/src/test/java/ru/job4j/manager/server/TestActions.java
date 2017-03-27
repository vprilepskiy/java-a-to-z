package ru.job4j.manager.server;

import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.manager.Actions;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URISyntaxException;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class TestActions {
    /**
     * Корневой тестовый каталог.
     */
    private File rootTestCatalog;
    /**
     * Спецсимол разделяющий каталоги или файлы.
     */
    private final String slash = System.getProperty("file.separator");
    /**
     * Спецсимол разделяющий строки.
     */
    private final String lineSeparator = System.getProperty("line.separator");

    /**
     * Предварительные настроки для теста.
     * @throws URISyntaxException - Exception.
     * @throws IOException - Exception.
     */
    @Before
    public void createTestFile() throws URISyntaxException, IOException {
        // путь к ресурсному каталогу
        File resourceCatalog = new File(new Server().getClass().getResource("/app.properties").toURI()).getParentFile();
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
//        this.firstTestCatalog = new File(new File(resourceCatalog,"rootTestCatalog"), "firstTestCatalog");
    }

    /**
     * Test Show.
     * @throws IOException - Exception.
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
     * @throws IOException - Exception.
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
     * @throws IOException - Exception.
     */
    @Test
    public void whenDownloadThenSetStream() throws IOException {
        final String fileName = "DownloadFile.txt";
        final byte[] input = {0, 0, 0, 0, 0, 0, 0, 4, 'A', 'B', 'C', 'D'};
        final byte size = 4;
        byte[] expected = new byte[size];
        byte[] result = new byte[size];

        Socket socket = Mockito.mock(Socket.class);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.download(fileName);

        File file = new File(this.rootTestCatalog, fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(expected);
        fileInputStream.close();

        // обрезать с 8го, 4 байта.
        final int srcPos = 8;
        final int length = 4;
        System.arraycopy(input, srcPos, result, 0, length);

        Assert.assertThat(result, Is.is(expected));
        file.delete();
    }

    /**
     * Test for upload.
     * @throws IOException - Exception.
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
     * @throws IOException - Exception.
     */
    @Test
    public void whenSendMessageThenGetStream() throws IOException {
        final String message = "Hello world";
        final byte[] expected = ArrayUtils.addAll(new byte[]{0, 11}, message.getBytes());

        Socket socket = Mockito.mock(Socket.class);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.sendMessage(message);

        Assert.assertThat(byteArrayOutputStream.toByteArray(), Is.is(expected));
    }

    /**
     * Test for readMessage.
     * @throws IOException - Exception.
     */
    @Test
    public void whenReadMessageThenSetStream() throws IOException {
        final String expected = "Hello world\r\n";
        final byte[] input = ArrayUtils.addAll(new byte[]{0, 11}, expected.getBytes());

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

package ru.job4j.manager.server;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URISyntaxException;

/**
 * Created by VLADIMIR on 08.02.2017.
 */
public class ActionsTest {

    File rootTestCatalog;
    final String slash = System.getProperty("file.separator");
    final String lineSeparator = System.getProperty("line.separator");

    @Before
    public void createTestFile() throws URISyntaxException, IOException {
        // путь к ресурсному каталогу
        File resourceCatalog = new File(new Server().getClass().getResource( "/app.properties").toURI()).getParentFile();
        // создаем тестовые каталоги
        new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "firstTestCatalog" + this.slash).mkdirs();
        new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "secondTestCatalog" + this.slash).mkdirs();
        // создаем тестовые файлы
        new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "firstTestCatalog" + this.slash + "firstTestFile.txt").createNewFile();
        new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "secondTestCatalog" + this.slash + "secondTestFile.txt").createNewFile();
        new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "rootTestFile.txt").createNewFile();
        // тестовый каталог
        this.rootTestCatalog = new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash);
    }


    /**
     * Test Show.
     * @throws IOException
     */
    @Test
    public void whenShowThenGetStream() throws IOException {

        StringBuilder expected = new StringBuilder();
        expected.append("<DIR> firstTestCatalog");
        expected.append(lineSeparator);
        expected.append("      rootTestFile.txt");
        expected.append(lineSeparator);
        expected.append("<DIR> secondTestCatalog");
        expected.append(lineSeparator);

        Socket socket = Mockito.mock(Socket.class);

//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

//        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);
        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.show();

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

//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

//        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);
        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.goToDirectory(this.slash + "secondTestCatalog");

        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(expected));

        byteArrayOutputStream.reset();

        actions.toHomeDir();
        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(this.rootTestCatalog.getAbsolutePath().toString()));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void whenDownloadThenGetStream() throws IOException {
//        final String expected = this.rootTestCatalog.toString() + this.slash + "secondTestCatalog";

        Socket socket = Mockito.mock(Socket.class);

        final String input = "ready";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());

        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);
        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        Actions actions = new Actions(socket, this.rootTestCatalog);
        actions.download("rootTestFile.txt");
//        actions.goToDirectory(this.slash + "secondTestCatalog");

        System.out.println(byteArrayOutputStream.toString());
//        byteArrayOutputStream.reset();

//        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(expected));
    }



}

package ru.job4j.manager.server;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;
import java.net.Socket;
import java.net.URISyntaxException;

/**
 * Created by VLADIMIR on 08.02.2017.
 */
public class ActionsTest {

//    File rootTestCatalog;
//    File firstTestCatalog;
//    final String slash = System.getProperty("file.separator");
//    final String lineSeparator = System.getProperty("line.separator");
//
//    @Before
//    public void createTestFile() throws URISyntaxException, IOException {
//        // путь к ресурсному каталогу
//        File resourceCatalog = new File(new Server().getClass().getResource( "/app.properties").toURI()).getParentFile();
//        // создаем тестовые каталоги
//        new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "firstTestCatalog" + this.slash).mkdirs();
//        new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "secondTestCatalog" + this.slash).mkdirs();
//        // создаем тестовые файлы
//        new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "firstTestCatalog" + this.slash + "firstTestFile.txt").createNewFile();
//        new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "secondTestCatalog" + this.slash + "secondTestFile.txt").createNewFile();
//        File rootFile = new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "rootTestFile.txt");
//        rootFile.createNewFile();
//        // запишем строку
//        FileWriter fileWriter = new FileWriter(rootFile);
//        fileWriter.write("ABCD");
//        fileWriter.flush();
//        fileWriter.close();
//        // тестовый каталог
//        this.rootTestCatalog = new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash);
//        this.firstTestCatalog = new File(resourceCatalog.getAbsolutePath() + this.slash + "rootTestCatalog" + this.slash + "firstTestCatalog" + this.slash);
//    }
//
//
//
//    /**
//     * Test Show.
//     * @throws IOException
//     */
//    @Test
//    public void whenShowThenGetStream() throws IOException {
//        // ожидаемое значение
//        StringBuilder expected = new StringBuilder();
//        expected.append("<DIR> firstTestCatalog");
//        expected.append(lineSeparator);
//        expected.append("      rootTestFile.txt");
//        expected.append(lineSeparator);
//        expected.append("<DIR> secondTestCatalog");
//        expected.append(lineSeparator);
//
//        Socket socket = Mockito.mock(Socket.class);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
//        // тестируемый метод
//        Actions actions = new Actions(socket, this.rootTestCatalog);
//        actions.show();
//        // проверяем
//        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(expected.toString()));
//    }
//
//    /**
//     * Test for goToDirectory and toHomeDir.
//     * @throws IOException
//     */
//    @Test
//    public void whenToDirThenGetStreamAndWhenToHomeDirThenGetStream() throws IOException {
//
//        final String expected = this.rootTestCatalog.toString() + this.slash + "secondTestCatalog";
//
//        Socket socket = Mockito.mock(Socket.class);
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
//
//        Actions actions = new Actions(socket, this.rootTestCatalog);
//        actions.goToDirectory(this.slash + "secondTestCatalog");
//
//        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(expected));
//
//        byteArrayOutputStream.reset();
//
//        actions.toHomeDir();
//        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(this.rootTestCatalog.getAbsolutePath().toString()));
//    }
//
//    /**
//     * Test for download.
//     * @throws IOException
//     */
//    @Test
//    public void whenDownloadThenGetStream() throws IOException {
//        final String fileName = "rootTestFile.txt";
//        final String input = "ready";
//        final String expected = "readyABCD";
//
//        Socket socket = Mockito.mock(Socket.class);
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
//
//        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);
//        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
//
//        Actions actions = new Actions(socket, this.rootTestCatalog);
//        actions.download(fileName);
//
//        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(expected));
//    }
//
//    /**
//     * Test for upload.
//     * @throws IOException
//     */
//    @Test
//    public void whenUploadThenGetStream() throws IOException {
//        final String fileName = "downloadTestFile.txt";
//        final String input = "ready" + this.lineSeparator + "ABC";
//        final String expected = "ready";
//
//        Socket socket = Mockito.mock(Socket.class);
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
//
//        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);
//        Mockito.when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
//
//        Actions actions = new Actions(socket, this.rootTestCatalog);
//        actions.upload(fileName);
//
//        Assert.assertThat(byteArrayOutputStream.toString().substring(2), Is.is(expected));
//
//        File file = new File(this.rootTestCatalog.getAbsolutePath() + this.slash + fileName);
//
//        FileReader fileReader = new FileReader(file);
//        String result = new BufferedReader(fileReader).readLine();
//
//
//        Assert.assertThat(result, Is.is("ABC"));
//        fileReader.close();
//        file.delete();
//    }

}

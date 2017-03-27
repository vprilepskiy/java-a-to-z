package ru.job4j.manager.server;

import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.manager.Actions;
import ru.job4j.manager.Menu;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class TestMenu {

    /**
     * Спецсимол разделяющий строки.
     */
    private final String lineSeparator = System.getProperty("line.separator");

    /**
     * Проверка.
     * @throws IOException - Exception.
     */
    @Test
    public void testAllCommands() throws IOException {
        this.testSelector(new String[]{"EXIT"}, "exitMethod" + this.lineSeparator);
        this.testSelector(new String[]{"SHOW", "EXIT"}, "showMethod" + this.lineSeparator + "exitMethod" + this.lineSeparator);
        this.testSelector(new String[]{"/DIR", "EXIT"}, "goToDirectoryMethod" + this.lineSeparator + "exitMethod" + this.lineSeparator);
        this.testSelector(new String[]{"HOME", "EXIT"}, "toHomeDirMethod" + this.lineSeparator + "exitMethod" + this.lineSeparator);
        this.testSelector(new String[]{"DOWNLOAD FileName", "EXIT"}, "uploadMethod" + this.lineSeparator + "exitMethod" + this.lineSeparator);
        this.testSelector(new String[]{"UPLOAD FileName", "EXIT"}, "downloadMethod" + this.lineSeparator + "exitMethod" + this.lineSeparator);
        this.testSelector(new String[]{"qwerty", "EXIT"}, "unknownCommandMethod" + this.lineSeparator + "exitMethod" + this.lineSeparator);
    }

    /**
     * Отправляет в поток команду и проверяет выбранный метод.
     * @param messages - Сообщение.
     * @param expected - Проверяемое значение.
     * @throws IOException - Exception.
     */
    public void testSelector(String[] messages, String expected) throws IOException {

        byte[] bytes = new byte[0];
        for (String message : messages) {
            bytes = ArrayUtils.addAll(bytes, ArrayUtils.addAll(new byte[]{0, (byte) message.length()}, message.getBytes()));
        }

        Socket socket = Mockito.mock(Socket.class);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Mockito.when(socket.getInputStream()).thenReturn(byteArrayInputStream);

        Menu menu = new Menu(socket);
        ActionTest actions = new ActionTest(socket, null);
        menu.menuNavigator(actions);

        Assert.assertThat(actions.getSelectedMethods(), Is.is(expected));
    }

    /**
     * Переопределение методов для тестирования.
     */
    class ActionTest extends Actions {
        /**
         * Спсок выбранных методов.
         */
        private StringBuilder selectedMethods = new StringBuilder();

        /**
         * Получить список выбранных методов.
         * @return - список.
         */
        public String getSelectedMethods() {
            return this.selectedMethods.toString();
        }

        /**
         * Конструктор.
         * @param socket - Socket server.
         * @param homeDirectory - Каталог по умолчанию.
         */
        ActionTest(Socket socket, File homeDirectory) {
            super(socket, homeDirectory);
        }
        @Override
        public void exit() {
            this.selectedMethods.append("exitMethod");
            this.selectedMethods.append(lineSeparator);
        }
        @Override
        public void show() {
            this.selectedMethods.append("showMethod");
            this.selectedMethods.append(lineSeparator);
        }
        @Override
        public void goToDirectory(String select) {
            this.selectedMethods.append("goToDirectoryMethod");
            this.selectedMethods.append(lineSeparator);
        }
        @Override
        public void toHomeDir() {
            this.selectedMethods.append("toHomeDirMethod");
            this.selectedMethods.append(lineSeparator);
        }
        @Override
        public void upload(String fileName) {
            this.selectedMethods.append("uploadMethod");
            this.selectedMethods.append(lineSeparator);
        }
        @Override
        public void download(String fileName) {
            this.selectedMethods.append("downloadMethod");
            this.selectedMethods.append(lineSeparator);
        }
        @Override
        public void unknownCommand() {
            this.selectedMethods.append("unknownCommandMethod");
            this.selectedMethods.append(lineSeparator);
        }
        @Override
        public void sendMessage(String message) {
            this.selectedMethods.append("sendMessageMethod");
            this.selectedMethods.append(lineSeparator);
        }
        @Override
        public void readMessage() {
            this.selectedMethods.append("readMessageMethod");
            this.selectedMethods.append(lineSeparator);
        }


    }

}

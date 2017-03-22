package ru.job4j.manager.server;

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

    final String lineSeparator = System.getProperty("line.separator");

    /**
     * Проверка.
     * @throws IOException
     */
    @Test
    public void testAllCommands() throws IOException {
        this.testSelector("EXIT", "exitMethod");
        this.testSelector("SHOW" + this.lineSeparator + "EXIT", "showMethod" + "exitMethod");
        this.testSelector("/DIR" + this.lineSeparator + "EXIT", "goToDirectoryMethod" + "exitMethod");
        this.testSelector("HOME" + this.lineSeparator + "EXIT", "toHomeDirMethod" + "exitMethod");
        this.testSelector("DOWNLOAD FileName" + this.lineSeparator + "EXIT", "downloadMethod" + "exitMethod");
        this.testSelector("UPLOAD FileName" + this.lineSeparator + "EXIT", "uploadMethod" + "exitMethod");
    }

    /**
     * Отправляет в поток команду и проверяет выбранный метод.
     * @param input
     * @param expected
     * @throws IOException
     */
    public void testSelector(String input, String expected) throws IOException {

        Socket socket = Mockito.mock(Socket.class);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
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

        private StringBuilder selectedMethods = new StringBuilder();

        public ActionTest(Socket socket, File homeDirectory) {
            super(socket, homeDirectory);
        }
        @Override
        public void exit(){
            this.selectedMethods.append("exitMethod");
        }
        @Override
        public void show(){
            this.selectedMethods.append("showMethod");
        }
        @Override
        public void goToDirectory(String select){
            this.selectedMethods.append("goToDirectoryMethod");
        }
        @Override
        public void toHomeDir(){
            this.selectedMethods.append("toHomeDirMethod");
        }
        @Override
        public void download(String fileName){
            this.selectedMethods.append("downloadMethod");
        }
        @Override
        public void upload(String fileName) {
            this.selectedMethods.append("uploadMethod");
        }

        public String getSelectedMethods(){
            return this.selectedMethods.toString();
        }
    }

}

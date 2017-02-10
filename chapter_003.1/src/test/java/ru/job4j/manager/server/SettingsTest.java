package ru.job4j.manager.server;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.manager.Settings;

import java.io.*;

/**
 * Created by VLADIMIR on 04.02.2017.
 */
public class SettingsTest {

//    @Test
//    public void whenLoadThenGetFile() throws IOException {
//
//        Settings settings = new Settings();
//
//        File file = new File("C:/projects/vprilepskiy/app.properties");
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//        settings.load(fileInputStream);
//
//        String value = settings.getValue("home.path");
//        Assert.assertThat(value, Is.is("c:/temp/"));
//    }
//
//    @Test
//    public void whenIndepPath() throws IOException {
////        File file = new File("./");
//        Settings settings = new Settings();
//        File file = new File("./../app.properties");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        settings.load(fileInputStream);
//
//        String value = settings.getValue("home.path");
//        Assert.assertThat(value, Is.is("c:/temp/"));
//
//    }
//
//    @Test
//    public void whenClassLoader() throws Exception {
////        File file = new File("./");
//        Settings settings = new Settings();
//        ClassLoader classLoader = Settings.class.getClassLoader();
//
//        try (InputStream inputStream = classLoader.getResourceAsStream("app.properties")) {
//            settings.load(inputStream);
//        }
//
//        String value = settings.getValue("home.path");
//        Assert.assertThat(value, Is.is("c:/temp/"));
//
//    }
}

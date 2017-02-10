package ru.job4j.manager;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.manager.server.Actions;
import ru.job4j.manager.server.Server;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by VLADIMIR on 08.02.2017.
 */
public class TestSettings {

    @Test
    public void test() throws IOException {

        final String propertiesFileName = "app.properties";
        final String key = "testKey";
        final String value = "testValue";

        Settings settings = new Settings(propertiesFileName);
        Assert.assertThat(value, Is.is(settings.getValue(key)));
    }


}

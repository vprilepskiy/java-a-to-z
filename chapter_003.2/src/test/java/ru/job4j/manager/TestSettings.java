package ru.job4j.manager;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by VLADIMIR on 14.02.2017.
 */
public class TestSettings {

    /**
     * Test settings.
     * @throws IOException - Exception.
     */
    @Test
    public void test() throws IOException {

        final String propertiesFileName = "app.properties";
        final String key = "testKey";
        final String value = "testValue";

        Settings settings = new Settings(propertiesFileName);
        Assert.assertThat(value, Is.is(settings.getValue(key)));
    }

}

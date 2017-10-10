package jdbc;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;



/**
 * Created by VLADIMIR on 10.10.2017.
 */
public class MainClassTest {

    /**
     * Test for main method.
     * @throws Exception - ex.
     */
    @Test
    public void run() throws Exception {

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        MainClass mc = new MainClass();
        mc.setUrl("jdbc:postgresql://localhost:5432/job4j");
        mc.setUsername("postgres");
        mc.setPassword("POSTGRESQL");
        final int number = 10;
        mc.setNumber(number);

        mc.run();

        Assert.assertThat("55\r\n", Is.is(outputStream.toString()));

    }

}
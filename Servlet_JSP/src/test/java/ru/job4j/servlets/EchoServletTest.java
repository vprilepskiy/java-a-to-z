package ru.job4j.servlets;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.*;


/**
 * Created by VLADIMIR on 08.11.2017.
 */
public class EchoServletTest {

    /**
     * Test.
     * @throws Exception ex.
     */
    @Test
    public void doGet() throws Exception {

        EchoServlet servlet = new EchoServlet();

        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse resp = Mockito.mock(HttpServletResponse.class);

        Mockito.when(req.getMethod()).thenReturn(null);

    }

}
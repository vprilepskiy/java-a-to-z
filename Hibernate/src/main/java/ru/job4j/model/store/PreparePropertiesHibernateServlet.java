package ru.job4j.model.store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by VLADIMIR on 15.02.2018.
 */
public class PreparePropertiesHibernateServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        HibernateORM.getInstance().setUp();
    }

    @Override
    public void destroy() {
        HibernateORM.getInstance().close();
    }


}

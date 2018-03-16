package ru.job4j.model.store;

import ru.job4j.model.store.defaultData.AddEnums;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by VLADIMIR on 15.02.2018.
 */
public class PreparePropertiesHibernateServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        HibernateORM.getInstance().setUp();
        new AddEnums().bodyTypes();
        new AddEnums().cars();
    }


    @Override
    public void destroy() {
        HibernateORM.getInstance().close();
    }
}

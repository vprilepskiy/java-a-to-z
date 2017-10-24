package ru.job4j;

import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by VLADIMIR on 20.10.2017.
 */
public class MainClass {

    /**
     * Logger.
     */
    private final Logger logger = Logger.getLogger(MainClass.class);

    /**
     * Settings.
     */
    private final Settings settings = new Settings("settings.properties");

    /**
     * Main method.
     * @param args - args.
     */
    public static void main(String[] args) {

        while (true) {
            MainClass mc = new MainClass();
            mc.start();

            try {
                final int millisInOneMinutes = 1000 * 60;
                Thread.sleep(millisInOneMinutes * Integer.parseInt(mc.settings.getValue("waitingTimeMinutes")));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * Запустит один раз.
     */
    public void start() {
        DB db = new DB();

        try {
            // соедениться в БД
            db.setConnection(settings.getValue("db_url"), settings.getValue("db_username"), settings.getValue("db_password"));
            // получить менеджера БД
            final DB.Manager manager = db.new Manager();

            // создать таблицу если отсутствует
            if (manager.select(settings.getValue("SQL_SELECT_TABLE_VACANCIES")) == 0) {
                manager.update(settings.getValue("SQL_CREATE_TABLE_VACANCIES"));
            }

            // URL сайта
            final URL url = new URL(settings.getValue("URL"));
            // получить кол-во дней с момента последнего запуска
            final int days = manager.select(settings.getValue("SQL_SELECT_DAYS"));
            // получить все объявления с сайта
            final List<Row> rows = new Site(url, days).parse();

            // залить все объявления в БД.
            for (Row row : rows) {
                final String prepareSQL = settings.getValue("SQL_INSERT_INTO_VACANCIES");
                final String[] args = new String[]{row.getUrl().toString(), row.getSubject(), row.getUrl().toString()};
                // если запись добавлена в БД
                if (manager.update(prepareSQL, args) > 0) {
                    logger.info(row.toString());
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

}

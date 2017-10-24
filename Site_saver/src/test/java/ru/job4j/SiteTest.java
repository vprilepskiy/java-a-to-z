package ru.job4j;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by VLADIMIR on 20.10.2017.
 */
public class SiteTest {

    /**
     * Constructor.
     * @throws MalformedURLException - Exception.
     */
    public SiteTest() throws MalformedURLException {
    }

    /**
     * URL с условиями поиска.
     * 66-форум.
     */
    private final URL url = new URL("http://www.sql.ru/forum/actualsearch.aspx?search=Java~Script~JavaScript&sin=1&bid=66&a=&ma=0&dt");

    /**
     * На сайте если выбрать во вкладке фильта поиска "за последний год", то фильтр установит 356 дней (почему-то не 365).
     */
    private final Site site = new Site(this.url, 356);


    /**
     * Получаем объявления со страницы.
     */
    @Test
    public void parseURL() {
        final List<Row> rows = this.site.parse(this.url);

        System.out.println(rows);

        System.out.printf("Rows count: %s", rows.size());
    }


    /**
     * Получить ссылки на все страницы.
     */
    @Test
    public void pagesRef() {
        final List<URL> urls = this.site.pagesRef(this.url);

        for (URL url : urls) {
            System.out.println(url);
        }

        System.out.printf("Rows count: %s", urls.size());
    }


    /**
     * Получаем со всех страниц объявления.
     * @throws Exception - Exception.
     */
    @Test
    public void parse() throws Exception {
        final List<Row> rows = this.site.parse();

        System.out.println(rows);

        System.out.printf("Rows count: %s", rows.size());
    }

}
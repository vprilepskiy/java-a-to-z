package ru.job4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 20.10.2017.
 */
public class Site {

    /**
     * URL.
     */
    private final URL url;

    /**
     * Filter for number days.
     */
    private final int days;

    /**
     * Constructor.
     * @param url - URL.
     * @param days - DAYS.
     */
    public Site(URL url, int days) {
        this.url = url;
        this.days = days;
    }


    /**
     * Получить все записи.
     * @return - все записи.
     */
    public List<Row> parse() {

        final List<Row> rows = new LinkedList<>();

        // получить URL с ключем "отобразить за n дней".
        final URL modifyUrl = this.modifyUrl(this.url, this.days);
        // получить все URL (Страницы: 1 2 3)
        final List<URL> pages = this.pagesRef(modifyUrl);
        // получить записи со всех страниц
        for (URL page : pages) {
            rows.addAll(this.parse(page));
        }
        return rows;
    }


    /**
     * Добавить к URL ключ с количеством просматриваемых дней.
     * @param url - URL без ключа.
     * @param days - кол-во дней.
     * @return - URL с ключом.
     */
    protected URL modifyUrl(URL url, int days) {
        final String key = "&s";
        URL resultURL = null;

        try {
            resultURL = new URL(String.format("%s%s%d%s", url, '=', days, key));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return resultURL;
    }


    /**
     * Получить ссылки на следующие страницы.
     * @param url - ссылка на первую страницу.
     * @return - ссылки на все страницы.
     */
    protected List<URL> pagesRef(URL url) {

        final List<URL> urls = new LinkedList<>();

        urls.add(url);

        try {
            Document document = Jsoup.connect(url.toString()).get();

            // http://www.sql.ru/forum
            Elements forumMenuElements = document.getElementsByAttributeValue("class", "forummenu");
            String forum = forumMenuElements.select("a").get(0).attr("href");

            Elements forumTableResultsElements = document.getElementsByAttributeValue("class", "forumtable_results");
            if (forumTableResultsElements.size() > 0) {
                Element forumTableResultsElement = forumTableResultsElements.get(1);

                for (Element hrefElement : forumTableResultsElement.getElementsByAttribute("href")) {
                    // http://www.sql.ru/forum + actualsearch.aspx?search=....
                    urls.add(new URL(String.format("%s/%s", forum, hrefElement.attr("href"))));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return urls;
    }


    /**
     * Получить все записи со страницы.
     * @param url - URL.
     * @return - Объявления.
     */
    protected List<Row> parse(URL url) {

        List<Row> rows = new LinkedList<>();

        try {
            Document document = Jsoup.connect(url.toString()).get();

            Elements topicElements = document.getElementsByAttributeValue("class", "postslisttopic");

            if (topicElements.size() > 0) {
                for (Element topicElement : topicElements) {

                    String urlRow = topicElement.child(0).attr("href");
                    String subjectRow = topicElement.text();

                    rows.add(new Row(new URL(urlRow), subjectRow));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }
}

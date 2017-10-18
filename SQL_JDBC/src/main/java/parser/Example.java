package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by VLADIMIR on 12.10.2017.
 */
public class Example {

    /**
     * Main.
     * @param args - args.
     * @throws IOException - exception.
     */
    public static void main(String[] args) throws IOException {
        new Example().parseSqlRu();
    }

    /**
     * Parse.
     * @throws IOException - ex.
     */
    public void parse4pdaRu() throws IOException {

        Document document = Jsoup.connect("http://4pda.ru").get();
        Elements h1elements = document.getElementsByAttributeValue("class", "list-post-title");

        for (Element h1element : h1elements) {
            Element element = h1element.child(0);

            String url = element.attr("href");
            String title = element.child(0).text();

            System.out.printf("%S %S \n", "URL: ", url);
            System.out.printf("%S %S \n", "TITLE: ", title);
        }
    }


    /**
     * Parse.
     * @throws IOException - ex.
     */
    public void parseSqlRu() throws IOException {
        Document document = Jsoup.connect("http://www.sql.ru/forum/job/1").get();
        Elements forumTableElements = document.getElementsByAttributeValue("class", "forumTable");
        Elements trElements = forumTableElements.select("tr");

        for (Element trElement : trElements) {

            Elements topicElements = trElement.getElementsByAttributeValue("class", "postslisttopic");
            if (topicElements.size() > 0) {
                System.out.printf("Text:\t%S\n", topicElements.get(0).text());
                System.out.printf("URL:\t%S\n", topicElements.get(0).child(0).attr("href"));
            }

            Elements altColElements = trElement.getElementsByAttributeValue("class", "altCol");
            if (altColElements.size() > 1) {
                System.out.printf("DATE:\t%S\n", altColElements.get(1).text());
            }

            System.out.println();
//            System.out.println(trElement + "**********************************************************");
        }
    }

}

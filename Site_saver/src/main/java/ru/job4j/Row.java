package ru.job4j;

import java.net.URL;

/**
 * Created by VLADIMIR on 20.10.2017.
 */
public class Row {

    /**
     * URL.
     */
    private final URL url;

    /**
     * Subject.
     */
    private final String subject;

    /**
     * Constructor.
     * @param url - URL.
     * @param subject - Subject.
     */
    public Row(URL url, String subject) {
        this.url = url;
        this.subject = subject;
    }

    /**
     * Getter.
     * @return - URL.
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Getter.
     * @return - Subject.
     */
    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        sb.append(String.format("Url:\t%S\n", this.url));
        sb.append(String.format("Subj:\t%S\n", this.getSubject()));

        return sb.toString();
    }
}

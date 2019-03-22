package ru.prilepskiy.response;

public class Register {

    public Register(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    private String shortUrl;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}

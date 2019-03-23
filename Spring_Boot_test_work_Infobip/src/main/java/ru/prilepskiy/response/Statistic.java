package ru.prilepskiy.response;


import java.util.Map;

public class Statistic {

    private Map<String, Integer> redirectsCounter;

    public Map<String, Integer> getRedirectsCounter() {
        return redirectsCounter;
    }

    public void setRedirectsCounter(Map<String, Integer> redirectsCounter) {
        this.redirectsCounter = redirectsCounter;
    }
}

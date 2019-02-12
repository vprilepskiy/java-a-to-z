package ru.job4j.test;

import java.util.Calendar;

public class CalendarUTC {

    public static void main(String[] args) {
        CalendarUTC calendarUTC = new CalendarUTC();
        calendarUTC.printMillis(calendarUTC.getCalendar());
    }

    private Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 1 - 1, 1, +03, 00, 00); // UTC+03:00
        return calendar;
    }


    private void printMillis(Calendar calendar) {
        System.out.println(calendar.getTimeInMillis() / 1000 * 1000);
    }




}

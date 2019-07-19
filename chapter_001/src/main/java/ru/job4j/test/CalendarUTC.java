package ru.job4j.test;

import java.util.Calendar;

public class CalendarUTC {

    public static void main(String[] args) {
        CalendarUTC calendarUTC = new CalendarUTC();
        calendarUTC.printMillis(calendarUTC.getCalendar());
        calendarUTC.a();
    }

    private Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 1 - 1, 1, +05, 00, 00); // UTC+05:00
        return calendar;
    }


    private void printMillis(Calendar calendar) {
        System.out.println(calendar.getTimeInMillis() / 1000 * 1000);
    }

    private void a() {
        Calendar c1 = Calendar.getInstance();
        c1.set(1970, 1 - 1, 1, 00, 00, 00);

        Calendar c2 = Calendar.getInstance();
        c2.set(2000, 1 - 1, 1, 00, 00, 00);

        System.out.println(c2.after(c1));
    }
}

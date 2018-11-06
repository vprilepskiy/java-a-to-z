package ru.job4j.test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by VLADIMIR on 18.10.2018.
 */
public class test {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0, 1, 0,0,0);
        calendar.add(Calendar.MILLISECOND, 0);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        Long s = calendar.getTimeInMillis() / 1000;

        System.out.println(s);


        System.out.println("------------------");

        java.time.LocalDate localDate = LocalDate.ofEpochDay(0);

        System.out.println(localDate);

        System.out.println(localDate.toEpochDay());

    }

}

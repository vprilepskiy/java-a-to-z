package ru.job4j.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CalendarAfter {

    public static void main(String[] args) {
        Calendar a_start = Calendar.getInstance();
        a_start.set(1970, 1 - 1, 1, 00, 00, 00);

        Calendar a_end = Calendar.getInstance();
        a_end.set(2010, 1 - 1, 1, 00, 00, 00);


        Calendar b_start = Calendar.getInstance();
        b_start.set(2011, 1 - 1, 1, 00, 00, 00);

        Calendar b_end = Calendar.getInstance();
        b_end.set(2012, 1 - 1, 1, 00, 00, 00);

        System.out.println(isOverlapping(a_start, a_end, b_start, b_end));

        System.out.println(Objects.equals("asdf", "asdf"));

    }

    public static boolean isOverlapping(Calendar start1, Calendar end1, Calendar start2, Calendar end2) {
        return !start1.after(end2) && !start2.after(end1);
    }

//    // Смещение вперед по оси времени "/ \ / \"
//    @Test
//    public void testTsOverlappingFadeForvard() {
//        Date d1B = new Date(2000, 1, 1, 1, 0);
//        Date d1E = new Date(2000, 1, 1, 3, 0);
//
//        Date d2B = new Date(2000, 1, 1, 2, 0);
//        Date d2E = new Date(2000, 1, 1, 4, 0);
//
//        boolean isOverlap = PriceMerge.isOverlapping(d1B, d1E, d2B, d2E);
//        assertTrue(isOverlap);
//    }
}

package ru.job4j.bank;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by VLADIMIR on 26.04.2017.
 */
public class TestBank {

    /**
     * Тест.
     * @throws InvalidTimeException - Исключение.
     */
    @Test
    public void whenEnterAndOutThenFindTimeMaxCount() throws InvalidTimeException {
        // время начала и окончания
        final long timeBegin = 5;
        final long timeEnd = 100;

        // время входивших и выходивших
        final long[] time = {15, 20, 25, 30, 35, 40, 45, 50};
        // входили и выходили
        final boolean[] enter = {true, false, true, true, true, false, false, false};
        // ожидаемый результат
        final long result = 35;

        Bank bank = new Bank(timeBegin, timeEnd);

        for (int i = 0; i < time.length; i++) {
            bank.addEvent(enter[i], time[i]);
        }

        Assert.assertThat(result, Is.is(bank.getTimeMaxCount()));
    }

}

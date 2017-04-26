package ru.job4j.bank;

/**
 * Created by VLADIMIR on 26.04.2017.
 */
public class Bank {

    /**
     * Начало работы.
     */
    private long timeBegin = 0;
    /**
     * Окончание работы.
     */
    private long timeEnd = 0;

    /**
     * Конструктор.
     * @param timeBegin - начало работы.
     * @param timeEnd - окончание работы.
     * @throws InvalidTimeException - упадет если время начала больше времени окончания.
     */
    public Bank(long timeBegin, long timeEnd) throws InvalidTimeException {
        if (timeBegin < timeEnd) {
            this.timeBegin = timeBegin;
            this.timeEnd = timeEnd;
        } else {
            throw new InvalidTimeException("Время начала работы должно быть меньше чем время закрытия.");
        }
    }

    /**
     * Максимальный трафик за день.
     */
    private final int maxTraffic = 1024;
    /**
     * Время последнего вошедшего/вышедшего.
     */
    private long time = 0;
    /**
     * Кол-во человек на данный момент.
     */
    private int count = 0;
    /**
     * Счетчик для массива.
     */
    private int index = 0;
    /**
     * Массив фиксирующий количество и время.
     */
    private long[][] countTime = new long[this.maxTraffic * 2][2];

    /**
     * Добавить в список событие.
     * @param entered - true если человек входит и false если человек выходит.
     * @param time - время вошедшего или вышедшего.
     * @throws InvalidTimeException - упадет если нарушен порядок времени действий или неверный период рабочего времени.
     */
    public void addEvent(boolean entered, long time) throws InvalidTimeException {

        if ((this.time < time) && (this.timeBegin <= time) && (this.timeEnd >= time)) {
            this.time = time;
            if (entered) {
                this.count++;
                this.countTime[this.index][0] = this.count;
                this.countTime[this.index][1] = this.time;
                this.index++;
            } else {
                this.count--;
            }
        } else {
            throw new InvalidTimeException("Введенное время меньше чем предыдущее или не в периоде рабочего времени.");
        }
    }

    /**
     * Получить момент времени с максимальным кол-вом человек.
     * @return - момент времени с максимальным кол-вом человек.
     */
    public long getTimeMaxCount() {

        long maxCount = 0;
        long time = 0;

        for (int i = 0; i < this.countTime.length; i++) {
            long count = this.countTime[i][0];
            if (count > maxCount) {
                maxCount = count;
                time = this.countTime[i][1];
            }
        }
        return time;
    }
}

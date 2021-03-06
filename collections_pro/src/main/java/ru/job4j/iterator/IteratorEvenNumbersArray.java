package ru.job4j.iterator;

/**
 * 5.1.2. Создать итератор четные числа [#15307].
 *
 * Created by VLADIMIR on 22.05.2017.
 */
public class IteratorEvenNumbersArray {

    /**
     * Array.
     */
    private final int[] values;
    /**
     * Index.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param values - Array.
     */
    public IteratorEvenNumbersArray(final int[] values) {
        this.values = values;
    }

    /**
     * Проверяет возможность извлечения следующих объектов из массива.
     * @return - true если есть следующий объект. False - если конец массива.
     */
    public boolean hasNext() {
        boolean result = false;

        if (this.getNextIndex() != -1) {
            result = true;
        }

        return result;
    }

    /**
     * Вернет объект из массива и сдвинет индекс на следующую ячейку.
     * @return - объект.
     */
    public Object next() {

        this.index = this.getNextIndex();
        Object result = this.values[this.index];
        this.index++;

        return result;
    }

    /**
     * Найдет следующий индекс элемента, значение которого - четное число.
     * @return - индекс элемента или -1 если не найден.
     */
    private int getNextIndex() {
        int result = -1;

        for (int i = this.index; i < this.values.length; i++) {
            if ((this.values[i] % 2) == 0) {
                result = i;
                break;
            }
        }

        return result;
    }
}

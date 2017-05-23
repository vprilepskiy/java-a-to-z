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

        for (int i = this.index; i < this.values.length; i++) {
            if ((this.values[i] % 2) == 0) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * Вернет объект из массива и сдвинет индекс на следующую ячейку.
     * @return - объект.
     */
    public Object next() {

        Object result = null;
        boolean again;

        do {
            if ((this.values[this.index] % 2) == 0) {
                result = this.values[this.index];
                again = false;
            } else {
                again = true;
            }
            this.index++;
        } while (again);

        return result;
    }

}

package ru.job4j.bank;

/**
 * Created by VLADIMIR on 11.05.2017.
 *
 * Банковский счёт.
 */
public class Account {

    /**
     * кол-во денег.
     */
    private double value;

    /**
     * реквизиты счёта.
     */
    private int requisites;

    /**
     * Банковский счёт.
     * @param value - кол-во денег.
     * @param requisites - реквизиты счёта.
     */
    public Account(double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Банковский счёт.
     * @param requisites - реквизиты счёта.
     */
    public Account(int requisites) {
        this.value = 0;
        this.requisites = requisites;
    }

    /**
     * Получить состояние счета.
     * @return - сумма.
     */
    public double getValue() {
        return value;
    }

    /**
     * Установить состояние счета.
     * @param value - сумма.
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        return requisites;
    }
}

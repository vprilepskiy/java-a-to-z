package ru.job4j.testwork;


/**
 * Created by VLADIMIR on 30.08.2017.
 */
public class Order implements Comparable<Order> {

    /**
     * Book.
     */
    private final Book book;

    /**
     * Volume.
     * Может принимать как положительное значение так и отрицательное.
     * Отрицательное когда Ask(Продавцы).
     * Положительное когда Bid(Покупатели).
     */
    private int volume;

    /**
     * Constructor.
     * @param book - book.
     * @param volume - volume.
     */
    public Order(Book book, int volume) {
        this.book = book;
        this.volume = volume;
    }

    /**
     * Getter.
     * @return - book.
     */
    public Book getBook() {
        return this.book;
    }

    /**
     * Getter.
     * @return - volume.
     */
    public int getVolume() {
        return this.volume;
    }

    /**
     * Setter.
     * @param volume - volume.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Get string Order. Form: volume@price
     * @return - line.
     */
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getVolume());
        sb.append('@');
        sb.append(this.getBook().getPrice());
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{book=");
        sb.append(book);
        sb.append(", volume=");
        sb.append(volume);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        if (volume != order.volume) {
            return false;
        }
        return book != null ? book.equals(order.book) : order.book == null;
    }

    @Override
    public int hashCode() {
        final int shift = 31;
        int result = book != null ? book.hashCode() : 0;
        result = shift * result + volume;
        return result;
    }


    @Override
    public int compareTo(Order o) {

        int result;

        result = this.book.compareTo(o.getBook());

        if (result == 0) {
            result = Integer.compare(this.volume, o.volume);
        }

        return result;
    }
}
